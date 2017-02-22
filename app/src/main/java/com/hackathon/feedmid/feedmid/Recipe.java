package com.hackathon.feedmid.feedmid;

/**
 * Created by Nicolas on 22/02/2017.
 */

public class Recipe {
    private int id;
    private String name;
    private float price;
    private int serving;
    private String ingredients;
    private String bestLocation;
    private float bestPrice;

    public Recipe(){}

    public Recipe(int id, String name, float price, int serving, String ingredients){
        this.id = id;
        this.name = name;
        this.price = price;
        this.serving = serving;
        this.ingredients = ingredients;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setServing(int serving){
        this.serving = serving;
    }

    public void setIngredients(String ingredients){
        this.ingredients = ingredients;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public float getPrice(){
        return price;
    }

    public int getServing(){
        return serving;
    }

    public String getIngredients(){
        return ingredients;
    }

    public String getBestLocation(){return bestLocation;}

    public void setBestLocation(String bestlocation){ this.bestLocation = bestlocation;}

    public float getBestPrice(){return bestPrice;}

    public void setBestPrice(float bestPrice){this.bestPrice = bestPrice;}
}
