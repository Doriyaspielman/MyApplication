package com.example.doriyaspielman.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Manager_listview extends ArrayAdapter<String>{

        private  String[] productName;
        private String[] price;
        private Integer[] pic_id;
        private Activity context;


    public Manager_listview(Activity context, String[] productName, String[] price, Integer[] pic_id) {
            super(context, R.layout.listview_manager_layout,productName);

            this.context=context;
            this.productName=productName;
            this.price=price;
            this.pic_id=pic_id;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View r = convertView;
            ViewHolder viewHolder=null;
            if(r==null){
                LayoutInflater layoutInflater=context.getLayoutInflater();
                r=layoutInflater.inflate(R.layout.listview_manager_layout,null,true);
                viewHolder=new ViewHolder(r);

                r.setTag(viewHolder);

            }
            else{
                viewHolder=(ViewHolder) r.getTag();
            }
            viewHolder.ivw.setImageResource(pic_id[position]);
            viewHolder.tvw1.setText(productName[position]);
            viewHolder.tvw2.setText(price[position]);
            return r;
        }

        class ViewHolder{
            TextView tvw1;
            TextView tvw2;
            ImageView ivw;

            ViewHolder(View v){
                tvw1=(TextView) v.findViewById(R.id.product_name2);
                tvw2=(TextView) v.findViewById(R.id.product_price2);
                ivw=(ImageView) v.findViewById(R.id.product_pic2);
            }
        }

}
