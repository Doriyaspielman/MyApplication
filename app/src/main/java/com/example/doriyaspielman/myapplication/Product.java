package com.example.doriyaspielman.myapplication;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private int price;
    private String description;
    private int quantity;
    private int pic_id;
    private int rating;

    public Product(){

    }

    public Product(int id, String name, int price, String description, int quantity, int pic_id, int rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.pic_id = pic_id;
        this.rating = rating;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPicture() {
        return pic_id;
    }

    public void setPicture(int pic_id) {
        this.pic_id = pic_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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


