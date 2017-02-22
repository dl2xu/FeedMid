package com.hackathon.feedmid.feedmid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    DBHandler db;
    DBHandler2 db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        /*
        Button mButton = (Button) findViewById(R.id.nextPageButton);

        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nextWindow();
            }
        });


        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
    */
        db = new DBHandler(this);
        //db2 = new DBHandler2(this);

        runDB1();
        //runDB2();
    }


    private void nextWindow(){
        Intent intent = new Intent(this, Window2.class);
        startActivity(intent);
    }



    private void runDB1(){
        Log.d("Insert: ", "Inserting ...");
        db.addIngredient(new Products("Superstore","Sweet Potatoes", 5.99f, 3.99f));
        db.addIngredient(new Products("Safeway","Beef Sirloin", 15.99f, 12.99f));
        db.addIngredient(new Products("Co-op","Broccoli", 8.99f, 5.99f));


        Log.d("Reading: ", "Reading all ingredients...");
        List<Products> products = db.getAllIngredients();

        for (Products product:products){
            String log = "Location: " + product.getLocation() + " Name: " + product.getName() + " Original Price: " + product.getOP() + " Discount Price: " + product.getDP();
            Log.d("Product:: ", log);
        }

        this.deleteDatabase(db.getDatabaseName());
    }

    private void runDB2(){
        Log.d("Insert: ", "Inserting ...");
        db2.addRecipe(new Recipe(1,"Grilled Caesar Salad", 15.99f, 1, "Lettuce, Ranch"));
        db2.addRecipe(new Recipe(2,"Beef Wellington", 25.99f, 2, "Fillet of beef, Mushroom, Pastry, egg"));
        db2.addRecipe(new Recipe(3,"Fried rice", 10.99f, 2, "Rice, eggs, carrots"));


        Log.d("Reading: ", "Reading all recipes...");
        List<Recipe> recipes = db2.getAllRecipes();

        for (Recipe recipe:recipes){
            String log = "Id: " + recipe.getId() + " Name: " + recipe.getName() + " Price: " + recipe.getPrice() + " Servings: " + recipe.getServing() + " Ingredients: " + recipe.getIngredients();
            Log.d("Recipe:: ", log);
        }

        this.deleteDatabase(db2.getDatabaseName());
    }

}
