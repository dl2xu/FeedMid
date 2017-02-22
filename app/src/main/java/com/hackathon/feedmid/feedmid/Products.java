package com.hackathon.feedmid.feedmid;


/**
 * Created by Nicolas on 21/02/2017.
 */

public class Products {
    private String location;
    private String name;
    private float original_price;
    private float discount_price;

    public Products(){}

    public Products(String location, String name, float op, float dp) {
        this.location = location;
        this.name = name;
        this.original_price = op;
        this.discount_price = dp;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setOP(float op){
        this.original_price = op;
    }

    public void setDP(float dp){
        this.discount_price = dp;
    }

    public String getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }

    public float getOP(){
        return original_price;
    }

    public float getDP(){
        return discount_price;
    }

}
