package com.example.simpleecommerce.ProductRoomDb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ProductRoom.class},version = 1,exportSchema = false)
public abstract class ProductDatabase extends RoomDatabase {

    public abstract ProductDao productDao();

    private static ProductDatabase instance = null;
    public static ProductDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, ProductDatabase.class, "AppDb")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
