package com.example.doriyaspielman.myapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    public Button login;
    public Button signIn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
        }

        public void OnClickLoginButton(View view) {
            EditText usernameInput = (EditText)findViewById(R.id.userNameInput);
            EditText passwordInput = (EditText)findViewById(R.id.passwordInput);

            if(usernameInput.getText().toString().equals("user") &&// check in the database if the user and password exists and valid.
                    passwordInput.getText().toString().equals("1234")) {
                System.out.println("Here");
                Intent i = new Intent(this,StoreScreen.class);
                startActivity(i);
            }
        }

    public void OnClickSignInButton(View v) {
        Intent i = new Intent(this,RegisterScreen.class);
        startActivity(i);


    }
    }


