package com.nire.myapplication.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recipe {

    @PrimaryKey
    public int id;

    public String title;

    public String description;

    public String text;
}
