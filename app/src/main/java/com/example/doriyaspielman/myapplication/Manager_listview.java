package com.example.doriyaspielman.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Manager_listview extends ArrayAdapter<Product>{

    private Activity context;
    private List<Product> arr_p;


    public Manager_listview(Activity context, List<Product> arr_p) {
            super(context, R.layout.listview_manager_layout,arr_p);
            this.context=context;
            this.arr_p = arr_p;
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
            viewHolder.ivw.setImageResource(Integer.parseInt(arr_p.get(position).getPicture()));
            viewHolder.tvw1.setText(arr_p.get(position).getName());
            viewHolder.tvw2.setText(arr_p.get(position).getPrice());
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
