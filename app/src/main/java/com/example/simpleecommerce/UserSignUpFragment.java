package com.example.simpleecommerce;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserSignUpFragment extends Fragment {
    private TextInputLayout txtInputUsername;
    private TextInputLayout txtInputPassword;
    private Button btnSignUp;
    private Button btnBackToLogin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_signup_fragment,container,false);
        txtInputUsername = view.findViewById(R.id.txt_input_submit_username);
        txtInputPassword = view.findViewById(R.id.txt_input_submit_password);
        btnSignUp = view.findViewById(R.id.btn_signup);
        btnBackToLogin = view.findViewById(R.id.btn_back_to_login);

        UserEndPoints service = ApiClient.getInstance().getUserEndPoints();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtInputUsername.getEditText().getText().toString().trim();
                String password = txtInputPassword.getEditText().getText().toString();

                JSONObject data = new JSONObject();
                try {
                    data.put("username", username);
                    data.put("password", password);
                    RequestBody requestBody = RequestBody
                            .create(MediaType.parse("application/json"),
                                    data.toString());
                    service.createNewUser(requestBody).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.code() == 200) {
                                Toast.makeText(getActivity(), "create user", Toast.LENGTH_LONG).show();
                                assert getFragmentManager() != null;
                                getFragmentManager().beginTransaction().
                                        replace(R.id.main_container,new UserLoginFragment()).
                                        commit();
                            }
                        }
                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getActivity(), " user failed", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().
                        replace(R.id.main_container,new UserLoginFragment()).
                        commit();
            }
        });
        return view;
    }
}
