package com.example.doriyaspielman.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RemoveManager extends AppCompatActivity {
     private ImageButton deletBtn;
    private EditText nameInput;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_manager);
        this.deletBtn=(ImageButton) findViewById(R.id.RemoveProduct);
        this.nameInput = (EditText) findViewById(R.id.idToRemove2);

        deletBtn.setOnClickListener(new View.OnClickListener() {
            final String name = nameInput.getText().toString();
            @Override
            public void onClick(View v) {
                ClickOnRemoveProduct(name);
            }
        });

    }

    public void ClickOnRemoveProduct( String name) {
        name = nameInput.getText().toString();
        final DatabaseReference products= FirebaseDatabase.getInstance().getReference("products").child(name);
        products.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()) {
                    Toast.makeText(RemoveManager.this,  " doesn't exists", Toast.LENGTH_LONG).show();
            }
            else{
                    products.removeValue();
                    Toast.makeText(RemoveManager.this,  " deleted!", Toast.LENGTH_LONG).show();
                }
            }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
        });

    }

}