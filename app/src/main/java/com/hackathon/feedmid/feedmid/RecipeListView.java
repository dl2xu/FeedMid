package com.hackathon.feedmid.feedmid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class RecipeListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list_view);

        //acceptedRecipes
        //get list of all recipes
        //for each recipe, find ingredients
        //superstorePrice = 0, coopPrice = 0, safewayPrice = 0;
            //for each ingredient
                //find superstore price, coop price, safeway price, add to total price of respective store
            //compare 3 total prices, choose lowest one, set bestPrice and bestLocation and add to acceptedRecipes
        //when this loop is done, acceptedRecipes is ready
        LinearLayout recipes = (LinearLayout) findViewById(R.id.recipeLayout);
        RecipeItem test = new RecipeItem(getBaseContext());
        String testname = "test name";
        test.setName(testname);
        test.setPeopleServed("69-96");
        test.setPrice((float)45.30);
        recipes.addView(test);

        //iterate through acceptedRecipes, adding objects to recipes
    }

}
