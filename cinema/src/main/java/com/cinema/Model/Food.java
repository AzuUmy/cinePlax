package com.cinema.Model;

public class Food implements ItemSale {
    private String name;
    private double price;
    private String description;


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
        return name + " - " + price + " - " + description;
    }
}
