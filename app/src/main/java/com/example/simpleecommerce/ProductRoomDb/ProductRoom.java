package com.example.simpleecommerce.ProductRoomDb;

import android.os.Bundle;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.simpleecommerce.ProductRCV.ProductDetails;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "product")
public class ProductRoom {
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "rate")
    private int rate;

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "price")
    private  int price;

    @ColumnInfo(name = "isAvailable")
    private Boolean isAvailable;

    @ColumnInfo(name = "categoryId")
    private String categoryId;


    public ProductRoom(String name, String description, int rate, int price,boolean isAvailable,String categoryId) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.price = price;
        this.isAvailable = isAvailable;
        this.categoryId = categoryId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
