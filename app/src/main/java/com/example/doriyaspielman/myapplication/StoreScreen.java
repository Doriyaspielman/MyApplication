package com.example.doriyaspielman.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StoreScreen extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener{
    private Button pay;
    public static Boolean check=false;
    ListView lst;
    ArrayList<Product> arr_p = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_screen);
        lst=(ListView) findViewById(R.id.listview);
        displayProductList();
        Custom_listview custom_listview=new Custom_listview(this,arr_p);
        lst.setAdapter(custom_listview);

        this.pay = (Button) findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPay();
            }
        });
    }
    private void displayProductList(){
        arr_p.add(new Product("001","red shoes","140","2",R.drawable.red_adidas));
        arr_p.add(new Product("002","black shoes","120","2",R.drawable.black_shoes));
        arr_p.add(new Product("003","black coat","150","2",R.drawable.black_coat));
        arr_p.add(new Product("004","casual dress","150","2",R.drawable.casual_dress));
        arr_p.add(new Product("005","evening dress","170","2",R.drawable.evening_dress));
        arr_p.add(new Product("006","pink shirt","100","2",R.drawable.pink_shirt));
        arr_p.add(new Product("007","white shirt","80","2",R.drawable.white_shirt));
        arr_p.add(new Product("008","wedding dress","300","2",R.drawable.wedding_dress));
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
        if(pos != ListView.INVALID_POSITION){
            Product p = arr_p.get(pos);
            p.setSelectes(isChecked);
            Toast.makeText(this, p.getName() + " added! " , Toast.LENGTH_LONG).show();


        }
    }
}
