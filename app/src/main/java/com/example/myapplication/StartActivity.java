package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class StartActivity extends AppCompatActivity {

    public static Context context_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        context_start = this;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(MySharedPreferences.getPrefChecked(StartActivity.this)) {
                    String strEmail = MySharedPreferences.getPrefEmail(StartActivity.this);
                    String strPwd = MySharedPreferences.getPrefPwd(StartActivity.this);

                    ((LoginActivity)LoginActivity.context_login).SignIn(strEmail, strPwd);
                }
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}