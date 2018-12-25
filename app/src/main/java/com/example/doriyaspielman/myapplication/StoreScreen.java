package com.example.doriyaspielman.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class StoreScreen extends AppCompatActivity {
    private Button pay;

    ListView lst;
String[] productName = {"red shoes", "black shoes", "black coat", "casual dress", "evening dress", "pink shirt", "white shirt", "wedding dress"};
String[] price = {"140", "120", "150", "90" , "170", "100", "80", "300"};
Integer[] pic_id={R.drawable.red_adidas, R.drawable.black_shoes, R.drawable.black_coat, R.drawable.casual_dress, R.drawable.evening_dress, R.drawable.pink_shirt, R.drawable.white_shirt,R.drawable.wedding_dress };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_screen);

    lst=(ListView) findViewById(R.id.listview);
        Custom_listview custom_listview=new Custom_listview(this,productName,price,pic_id);
        lst.setAdapter(custom_listview);

        this.pay = (Button) findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPay();
            }
        });
    }

    public void onPay(){
        Intent i = new Intent(this, confirm.class);
        startActivity(i);

    }
}
