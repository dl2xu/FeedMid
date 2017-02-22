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

        Log.d("Insert: ", "Inserting ...");
        createDB1();

        Log.d("Reading: ", "Reading all shops...");
        List<Products> products = db.getAllIngredients();

        for (Products product:products){
            String log = "Id: " + product.getId() + " Name: " + product.getName() + " Original Price: " + product.getOP() + " Discount Price: " + product.getDP();
            Log.d("Product:: ", log);
        }
    }


    private void nextWindow(){
        Intent intent = new Intent(this, Window2.class);
        startActivity(intent);
    }

    private void createDB1(){
        db.addIngredient(new Products(1,"Sweet Potatoes", 5.99f, 3.99f));
        db.addIngredient(new Products(2,"Beef Sirloin", 15.99f, 12.99f));
        db.addIngredient(new Products(3,"Broccoli", 8.99f, 5.99f));
    }

}
