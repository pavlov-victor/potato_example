package com.nire.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.nire.myapplication.db.Recipe;
import com.nire.myapplication.db.RecipeDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecipeDatabase recipeDatabase;
    TextView title, description, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title_recipe);
        description = findViewById(R.id.description_recipe);
        text = findViewById(R.id.recipe_text);

        recipeDatabase = Room.databaseBuilder(
                this,
                RecipeDatabase.class,
                "database"
        ).build();
        new Thread(this::getData).start();

//        Recipe recipe = new Recipe();
//        recipe.text = "Рецепт создания пюре из картофеля";
//        recipe.title = "Пюре из картофеля";
//        recipe.description = "Отваривается картошка с солью," +
//                " размельчается картофелямялкой" +
//                " добавить масло и укроп, закрыть крышкой на 10 минут";
//        new Thread(()->{
//            recipeDatabase.recipeDao().addRecipe(recipe);
//        }).start();

    }

    public void getData() {
        class GetData extends AsyncTask<Void, Void, Recipe>{
            @Override
            protected Recipe doInBackground(Void... voids) {
                List<Recipe> recipes = recipeDatabase.recipeDao().getRecipes();
                Recipe recipe = recipes.get(0);
                title.setText(recipe.title);
                description.setText(recipe.description);
                text.setText(recipe.text);
                return recipe;
            }
        }
        GetData gd = new GetData();
        gd.execute();
    }
}