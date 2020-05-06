package com.honeydhiman.session_management_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //check session if user logged in then move to the main activity

        SessionManagement sessionManagement=new SessionManagement(LoginActivity.this);
        int isLoggedIn=sessionManagement.getSession();

        if(isLoggedIn!=-1)
        {
         moveToMainActivity();
        }
        else
        {
            //do nothing
        }

    }

    public void loginClick(View view) {
        ///1)log in to app and save session to user
        ///2)move to main activity

        User user=new User(12,"Ram");

        SessionManagement sessionManagement=new SessionManagement(LoginActivity.this);

        sessionManagement.saveSession(user);

        moveToMainActivity();
    }

    private void moveToMainActivity() {
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
