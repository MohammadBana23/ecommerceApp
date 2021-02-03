package com.example.simpleecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.simpleecommerce.CategoryRCV.CategoryFragment;
import com.example.simpleecommerce.R;

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