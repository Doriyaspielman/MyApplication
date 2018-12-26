package com.example.doriyaspielman.myapplication;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String price;
    private String description;
    private String quantity;
    private int pic_id;
    private String rating;
    private boolean selectes= false;


    public Product(){

    }

    public Product(String id, String name, String price, String quantity, int pic_id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.pic_id = pic_id;
    }

    public Product(String name,String price,int pic_id){
        this.name = name;
        this.price = price;
        this.pic_id = pic_id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPicture() {
        return pic_id;
    }

    public void setPicture(int pic_id) {
        this.pic_id = pic_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isSelectes() {
        return selectes;
    }

    public void setSelectes(boolean selectes) {
        this.selectes = selectes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", picture='" + pic_id + '\'' +
                ", rating=" + rating +
                '}';
    }
}