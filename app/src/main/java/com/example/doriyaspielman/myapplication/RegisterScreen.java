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

public class RegisterScreen extends AppCompatActivity {

    private EditText emailInput;
    private EditText passwordInput;
    private EditText nameInput;
    private Button  signUpBtn;
    private boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        this.emailInput = (EditText) findViewById(R.id.new_Email);
        this.passwordInput = (EditText) findViewById(R.id.new_Password);
        this.nameInput = (EditText) findViewById(R.id.new_UserName);
        this.signUpBtn = findViewById(R.id.new_signIn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickOnRegister();
            }
        });
    }

    public void goBackToLogIn(){
        Intent i = new Intent(this, LoginScreen.class);
        startActivity(i);
    }
    public void ClickOnRegister() {

        final DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        final User user = new User(
                nameInput.getText().toString(),
                emailInput.getText().toString(),
                passwordInput.getText().toString(),
                false);

        if ((HasEmptyFields() == false)) {

            Toast.makeText(RegisterScreen.this, "There is empty field,try again!", Toast.LENGTH_LONG).show();
        } else {

            db.child("Users").child(user.getEmail().replace(".", "|").toLowerCase()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                            Toast.makeText(RegisterScreen.this, "E-mail already exists", Toast.LENGTH_LONG).show();

                    } else {
                        flag=true;
                        db.child("Users").child(user.getEmail().replace(".", "|")).setValue(user);
                        Toast.makeText(RegisterScreen.this, "Registration done. please login", Toast.LENGTH_LONG).show();
                        goBackToLogIn();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            if(flag) {
                Intent i = new Intent(this, LoginScreen.class);
                startActivity(i);
            }
        }
    }
        private boolean HasEmptyFields(){
        if(emailInput.getText().toString().isEmpty() || passwordInput.getText().toString().isEmpty()|| nameInput.getText().toString().isEmpty()){
            return false;
        }
          return true;
        }

}
