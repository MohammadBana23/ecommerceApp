package com.example.simpleecommerce.ProductRoomDb;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface ProductDao {

    //create product
    @Insert
    void createProduct(ProductRoom productRoom);
}
