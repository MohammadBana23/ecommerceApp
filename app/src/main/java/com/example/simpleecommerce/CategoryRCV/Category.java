package com.example.simpleecommerce.CategoryRCV;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("_id")
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
