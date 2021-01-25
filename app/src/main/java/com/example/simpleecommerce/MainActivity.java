package com.example.simpleecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtUsername;
    private TextInputEditText edtPassword;
    private TextInputLayout txtInputUsername;
    private TextInputLayout txtInputPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findProperty();


        UserEndPoints service = ApiClient.getInstance().getUserEndPoints();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtInputUsername.getEditText().getText().toString();
                String password = txtInputPassword.getEditText().getText().toString();

                JSONObject data = new JSONObject();
                try {
                    data.put("username",username);
                    data.put("password",password);
                    RequestBody requestBody = RequestBody
                            .create(MediaType.parse("application/json"),
                                    data.toString());
                    service.createNewUser(requestBody).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.code() == 200){
                                Toast.makeText(MainActivity.this,"create user", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this," user failed", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });





    }


    public void findProperty(){
        txtInputUsername = findViewById(R.id.txt_input_submit_username);
        txtInputPassword = findViewById(R.id.txt_input_submit_password);
        edtUsername = findViewById(R.id.edt_submit_username);
        edtPassword = findViewById(R.id.edt_submit_password);
        btnSubmit = findViewById(R.id.btn_submit);
    }
}