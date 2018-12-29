package com.example.doriyaspielman.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginScreen extends AppCompatActivity {
    public Button login;
    public Button signIn;
    private EditText emailInput;
    private EditText passowrdInput;
    private boolean loginIsOk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailInput = (EditText)findViewById(R.id.emailInput);
        passowrdInput = (EditText)findViewById(R.id.passwordInput);
        this.login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLoginButton();
            }
        });
    }
    public void onClickLoginButton() {
        final String emailInputString = emailInput.getText().toString();
        final String passwordInputString = passowrdInput.getText().toString();
        final DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        if( (emailInputString.equals("doriya@gmail.com") || emailInputString.equals("noyt@gmail.com")) && passwordInputString.equals("1234")) {//if manager
            Intent i = new Intent(this, StoreScreenManager.class);
            startActivity(i);
        }
        else if((emailInputString.toLowerCase().equals("doriya@gmail.com") || emailInputString.toLowerCase().equals("noyt@gmail.com")) && !passwordInputString.equals("1234")){
            Toast.makeText(LoginScreen.this, "Wrong password,try again!", Toast.LENGTH_LONG).show();
        }
        else {
            db.child("Users").child(emailInputString.replace(".", "|").toLowerCase()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        User user;
                        user = dataSnapshot.getValue(User.class);
                        if (passwordInputString.equals(user.getPassword())) {
                            loginIsOk = true;
                        }
                        else{
                            Toast.makeText(LoginScreen.this, "Wrong password,try again!", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
            if (loginIsOk) {//if user exists
                Intent i = new Intent(this, StoreScreen.class);
                startActivity(i);
            }
        }
    }

    public void OnClickSignInButton(View v) {//new user,need to sintup
        Intent i = new Intent(this,RegisterScreen.class);
        startActivity(i);
    }
}