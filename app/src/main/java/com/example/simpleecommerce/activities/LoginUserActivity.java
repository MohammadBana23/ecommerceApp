package com.example.simpleecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.simpleecommerce.R;
import com.example.simpleecommerce.userPage.UserLoginFragment;

public class LoginUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.main_container,new UserLoginFragment()).
                commit();
    }
}