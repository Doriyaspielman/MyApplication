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

public class AddManager extends AppCompatActivity {
    private EditText idInput;
    private EditText nameInput;
    private EditText priceInput;
    private EditText quantityInput;
    private EditText pic_idInput;
    private Button AddProductBtn;
    private boolean flag=false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__store_manager);

        this.idInput = (EditText) findViewById(R.id.idInput);
        this.nameInput = (EditText) findViewById(R.id.nameInput);
        this.priceInput = (EditText) findViewById(R.id.priceInput);
        this.quantityInput = (EditText) findViewById(R.id.quantityInput);
        this.pic_idInput = (EditText) findViewById(R.id.pic_idInput);

        AddProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickOnAddProduct();
            }
        });
    }

    public void ClickOnAddProduct() {
        final DatabaseReference products= FirebaseDatabase.getInstance().getReference();
        final Product product = new Product(idInput.getText().toString(),
                nameInput.getText().toString(),
                priceInput.getText().toString(),
                quantityInput.getText().toString(),
                pic_idInput.getText().toString());


        if ((HasEmptyFields() == false)) {

            Toast.makeText(AddManager.this, "There is empty field,try again!", Toast.LENGTH_LONG).show();
        } else {

            products.child("Products").child(product.getId().toLowerCase()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Toast.makeText(AddManager.this, "Product already exists", Toast.LENGTH_LONG).show();

                    } else {
                        flag=true;
                        products.child("Product").child(product.getName()).setValue(product);
                        Toast.makeText(AddManager.this, "Product added!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            if(flag) {
                Intent i = new Intent(this, StoreScreenManager.class);
                startActivity(i);
            }
        }
    }

    private boolean HasEmptyFields(){
        if(idInput.getText().toString().isEmpty() ||
                nameInput.getText().toString().isEmpty() ||
                priceInput.getText().toString().isEmpty() ||
                quantityInput.getText().toString().isEmpty()||
                pic_idInput.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }
}