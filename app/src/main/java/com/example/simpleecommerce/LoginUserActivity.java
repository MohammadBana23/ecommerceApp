package com.example.simpleecommerce;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserActivity extends AppCompatActivity {
    private TextInputLayout txtInputUsername;
    private TextInputLayout txtInputPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        txtInputUsername = findViewById(R.id.txt_input_login_username);
        txtInputPassword = findViewById(R.id.txt_input_login_password);
        btnSubmit = findViewById(R.id.btn_login);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtInputUsername.getEditText().getText().toString();
                String password = txtInputPassword.getEditText().getText().toString();
                UserEndPoints service = ApiClient.getInstance().getUserEndPoints();
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
                                Toast.makeText(LoginUserActivity.this, "successful", Toast.LENGTH_LONG).show();
                            }else if (response.code() == 500){
                                Toast.makeText(LoginUserActivity.this, "you should signup", Toast.LENGTH_LONG).show();
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


    }
}