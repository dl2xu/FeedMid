package com.hackathon.feedmid.feedmid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.security.keystore.KeyInfo;

import com.hackathon.feedmid.feedmid.Products;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 21/02/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "IngredientsInfo";
    // Contacts table name
    private static final String TABLE_INGREDIENTS = "ingredients";
    // Ingredients table columns names
    private static final String KEY_LOCATION = "location";
    private static final String KEY_NAME = "name";
    private static final String KEY_OP = "original_price";
    private static final String KEY_DP = "discount_price";


    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_INGREDIENTS + "(" + KEY_LOCATION + " TEXT," + KEY_NAME + " TEXT," + KEY_OP + " FLOAT," + KEY_DP + " FLOAT," + " PRIMARY KEY (" + KEY_LOCATION + ", " + KEY_NAME + "))";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INGREDIENTS);
        //Create tables again
        onCreate(db);

    }

    //Adding new ingredient
    public void addIngredient(Products ingredient){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LOCATION, ingredient.getLocation());
        values.put(KEY_NAME, ingredient.getName());
        values.put(KEY_OP, ingredient.getOP());
        values.put(KEY_DP, ingredient.getDP());
        //Inserting row
        db.insert(TABLE_INGREDIENTS, null, values);
        db.close();
    }

    //Reads row
    public Products getIngredients(String location, String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_INGREDIENTS, new String[]{KEY_LOCATION, KEY_NAME, KEY_OP, KEY_DP}, KEY_LOCATION + "=? OR " + KEY_NAME + "=?", new String[] {location, name}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Products contact = new Products(cursor.getString(0), cursor.getString(1), cursor.getFloat(2), cursor.getFloat(3));
        //return ingredients
        return contact;
    }

    //Gets all ingredients
    public List<Products> getAllIngredients(){
        List<Products> ingredientList = new ArrayList<Products>();
        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_INGREDIENTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping through all rows and adding to list
        if (cursor.moveToFirst()){
            do{
                Products ingredients = new Products();
                ingredients.setLocation((cursor.getString(0)));
                ingredients.setName(cursor.getString(1));
                ingredients.setOP(cursor.getFloat(2));
                ingredients.setDP(cursor.getFloat(3));

                ingredientList.add(ingredients);

            }while(cursor.moveToNext());
        }

        return ingredientList;
    }


    //Get ingredients count
    public int getProductCount(){
        String countQuery = "SELECT * FROM " + TABLE_INGREDIENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    //Update a product
    public int updateProduct(Products ingredient){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, ingredient.getName());
        values.put(KEY_OP, ingredient.getOP());
        values.put(KEY_DP, ingredient.getDP());

        return db.update(TABLE_INGREDIENTS, values, KEY_LOCATION + " = ? OR " + KEY_NAME + " = ?", new String[]{ingredient.getLocation(), ingredient.getName()});
    }

    //Deleting a product
    public void deleteProduct(Products ingredient){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_INGREDIENTS, KEY_LOCATION + " = ? OR " + KEY_NAME + " = ?", new String[]{ingredient.getLocation(), ingredient.getName()});
        db.close();
    }



}
