package com.example.doriyaspielman.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StoreScreen extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener{
    private Button pay;
    public static Boolean check=false;
    ListView lst;
    private DatabaseReference db;
    Set<Integer> indexes = new HashSet<Integer>();
    private Integer position;
    final ArrayList<Product> arr_p2 = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_screen);
        db = FirebaseDatabase.getInstance().getReference();
        lst=(ListView) findViewById(R.id.listview);
        final Custom_listview custom_listview=new Custom_listview(this,arr_p2);
        lst.setAdapter(custom_listview);
        this.pay = (Button) findViewById(R.id.pay);

        db.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildAdded (@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    Product product = userSnapshot.getValue(Product.class);
                    arr_p2.add(new Product(product.getName(),product.getPrice(),product.getPicture()));
                    custom_listview.notifyDataSetChanged();
                }

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPay();
            }
        });
    }

    public void onClickCheck(View v){
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            check =true;
        }
        else{
            check=false;
        }
    }

    public void onPay(){
        if(check) {
            Intent i = new Intent(StoreScreen.this, confirm.class);
            startActivity(i);
        }
        else{
            Toast.makeText(StoreScreen.this, "Please select product!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int pos = lst.getPositionForView(buttonView);
        if(isChecked){
            indexes.add(position);
        }else{
            indexes.remove(position);
        }
        if(pos != ListView.INVALID_POSITION){
            Product p = arr_p2.get(pos);
            p.setSelectes(isChecked);
            if(indexes.isEmpty()){
                Toast.makeText(this, p.getName() + " remove! " , Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, p.getName() + " added! " , Toast.LENGTH_LONG).show();

            }
        }
    }
}