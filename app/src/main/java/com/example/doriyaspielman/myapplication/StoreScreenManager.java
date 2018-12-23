package com.example.doriyaspielman.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class StoreScreenManager extends AppCompatActivity {
    ListView lst;
    String[] productName = {"red shoes", "black shoes", "black coat", "casual dress", "evening dress", "pink shirt", "white shirt", "wedding dress"};
    String[] price = {"140", "120", "150", "90" , "170", "100", "80", "300"};
    Integer[] pic_id={R.drawable.red_adidas, R.drawable.black_shoes, R.drawable.black_coat, R.drawable.casual_dress, R.drawable.evening_dress, R.drawable.pink_shirt, R.drawable.white_shirt,R.drawable.wedding_dress };
    Button plus;
    Button minus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__store_manager);

        lst = (ListView) findViewById(R.id.listviewmanager);
        Manager_listview manager_listview = new Manager_listview(this, productName, price, pic_id);
        lst.setAdapter(manager_listview);
    }

    }

