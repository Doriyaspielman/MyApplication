package com.example.doriyaspielman.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Custom_listview extends ArrayAdapter<Product> {


    private List<Product> arr_p2;
    private Activity context;
    private Product p;
    public Custom_listview(Activity context, List<Product> arr_p2) {
        super(context, R.layout.listview_layout,arr_p2);
        this.context=context;
        this.arr_p2 = arr_p2;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
            viewHolder.checkBox=r.findViewById(R.id.checkBox);
            viewHolder.checkBox.setOnCheckedChangeListener((StoreScreen)context);
        }
        else{
            viewHolder=(ViewHolder) r.getTag();
        }
        p = arr_p2.get(position);
        Picasso.get().load(arr_p2.get(position).getPicture()).into(viewHolder.ivw);
        viewHolder.tvw1.setText(arr_p2.get(position).getName());
        viewHolder.tvw2.setText(arr_p2.get(position).getPrice());
        viewHolder.checkBox.setChecked(p.isSelectes());
        viewHolder.checkBox.setTag(p);
        return r;
    }

    public void onClickCheck(View v){
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            StoreScreen.check =true;
        }
        else{
            StoreScreen.check=false;
        }
    }

    class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        CheckBox checkBox;


        ViewHolder(View v){
            tvw1=(TextView) v.findViewById(R.id.product_name);
            tvw2=(TextView) v.findViewById(R.id.product_price);
            ivw=(ImageView) v.findViewById(R.id.product_pic1);
            checkBox=(CheckBox) v.findViewById(R.id.checkBox);
        }
    }
}