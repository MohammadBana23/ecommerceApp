package com.example.simpleecommerce.userPage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.simpleecommerce.ApiClient;
import com.example.simpleecommerce.MyEndPoints.MyEndPoints;
import com.example.simpleecommerce.RememberMeSharedPref;
import com.example.simpleecommerce.activities.MainActivity;
import com.example.simpleecommerce.R;
import com.example.simpleecommerce.models.User;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginFragment extends Fragment {
    private TextInputLayout txtInputUsername;
    private TextInputLayout txtInputPassword;
    private Button btnLogin;
    private Button btnSignUp;
    private CheckBox chRememberMe;
    private RememberMeSharedPref rememberMeSharedPref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_login_fragment,container,false);

        rememberMeSharedPref = new RememberMeSharedPref(getActivity());
        txtInputUsername = view.findViewById(R.id.txt_input_login_username);
        txtInputPassword = view.findViewById(R.id.txt_input_login_password);
        btnLogin = view.findViewById(R.id.btn_login);
        btnSignUp = view.findViewById(R.id.btn_go_to_signup);
        chRememberMe = view.findViewById(R.id.chb_remember_me);



        chRememberMe.setChecked(RememberMeSharedPref.getRememberMe());
        if (chRememberMe.isChecked()){
            txtInputUsername.getEditText().setText(rememberMeSharedPref.getUsername());
            txtInputPassword.getEditText().setText(rememberMeSharedPref.getPassword());
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtInputUsername.getEditText().getText().toString().trim();
                String password = txtInputPassword.getEditText().getText().toString();
                MyEndPoints.UserEndPoints service = ApiClient.getInstance().getEndPoints(MyEndPoints.UserEndPoints.class);
                JSONObject data = new JSONObject();
                try {
                    data.put("username",username);
                    data.put("password",password);
                    RequestBody requestBody = RequestBody
                            .create(MediaType.parse("application/json"),
                                    data.toString());
                    service.getUserByUsernamePassword(requestBody).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.code() == 200){
                                RememberMeSharedPref.setRememberMe(chRememberMe.isChecked());
                                if (chRememberMe.isChecked()){
                                    rememberMeSharedPref.setUsernameAndPassword(username,password);
                                }else {
                                    rememberMeSharedPref.removeUserAndPass();
                                }
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                            }else if (response.code() == 401){
                                Toast.makeText(getActivity(), "Check your username and password or sign up", Toast.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().
                        replace(R.id.main_container,new UserSignUpFragment()).
                        commit();
            }
        });
        return view;
    }
}
