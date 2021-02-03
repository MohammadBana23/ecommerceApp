package com.example.simpleecommerce;

import android.content.Context;
import android.content.SharedPreferences;

public class RememberMeSharedPref {

    private static SharedPreferences sharedPreferences;
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String REMEMBER_ME = "remember_me";

    public RememberMeSharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE);
    }

    public void setUsernameAndPassword(String username, String password){
        sharedPreferences.edit().putString(USERNAME,username).apply();
        sharedPreferences.edit().putString(PASSWORD,password).apply();
    }

    public String getUsername(){
        return sharedPreferences.getString(USERNAME,"");
    }
    public String getPassword(){
        return sharedPreferences.getString(PASSWORD,"");
    }
    public static void setRememberMe(boolean rememberMe){
        sharedPreferences.edit().putBoolean(REMEMBER_ME,rememberMe).apply();
    }
    public static boolean getRememberMe(){
        return sharedPreferences.getBoolean(REMEMBER_ME,false);
    }
    public void removeUserAndPass(){
        sharedPreferences.edit().remove(USERNAME).apply();
        sharedPreferences.edit().remove(PASSWORD).apply();
    }
}
