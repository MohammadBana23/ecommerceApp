package com.example.simpleecommerce.ProductRCV;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("rate")
    private int rate;
    @SerializedName("_id")
    private String id;
    @SerializedName("price")
    private  int price;
    @SerializedName("isAvailable")
    private Boolean isAvailable;
    @SerializedName("categoryId")
    private String categoryId;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
