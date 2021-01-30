package com.example.simpleecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.simpleecommerce.CategoryRCV.CategoryFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.main_container,new CategoryFragment()).
                commit();

    }
}