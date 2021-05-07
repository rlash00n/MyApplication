package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = ((LoginActivity)LoginActivity.context_login).sp;
                pref = getSharedPreferences("temp",MODE_PRIVATE);

                if(pref.getBoolean("checkbox", false)){
                    String strEmail = pref.getString("email","");
                    String strPwd = pref.getString("pwd","");
                    ((LoginActivity)LoginActivity.context_login).SignIn(strEmail,strPwd);
                }
            }
        }, 2000);
    }
}