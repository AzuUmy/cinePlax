package com.cinema.Model;

public class Food implements ItemSale {
    private String name;
    private double price;
    private String description;
    private int quantity;


    public Food() {
        
    }


    public Food(String name) {
        this.name = name;
    }


    public Food(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }



    public Food(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    


    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String description() {
        return description;
    }



    @Override
    public int getQuantity() {
      return quantity;
    }  

    
}
