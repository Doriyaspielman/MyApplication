package com.example.doriyaspielman.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class StoreScreenManager extends AppCompatActivity {
    ListView lst;
    private EditText product_id;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__store_manager);

        db = FirebaseDatabase.getInstance().getReference();
        final ArrayList<Product> arr_p = new ArrayList();

        lst = (ListView) findViewById(R.id.listviewmanager);
        final Manager_listview manager_listview = new Manager_listview(this, arr_p);
        lst.setAdapter(manager_listview);
        db.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildAdded (@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d(db.toString(), "BLA1");

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    Log.d("BLA", "BLA2");

                    Product product = userSnapshot.getValue(Product.class);
                    Log.d(product.getName(), "BLA3");
                    arr_p.add(new Product(product.getName(),product.getPrice(),product.getPicture()));
                    Log.d(product.getPicture(), "BLA2");

                    manager_listview.notifyDataSetChanged();
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
    }
    public void OnClickPlus (View v){
        Intent i = new Intent(this, AddManager.class);
        startActivity(i);
    }

    public void OnClickMinos (View v){
        Intent i = new Intent(this, RemoveManager.class);
        startActivity(i);
    }
}