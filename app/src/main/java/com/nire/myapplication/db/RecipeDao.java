package com.nire.myapplication.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("select * from recipe")
    public List<Recipe> getRecipes();

    @Query("select * from recipe where id == :id")
    public Recipe getRecipe(int id);

    @Insert()
    public void addRecipe(Recipe recipe);

}
