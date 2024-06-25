package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;
import com.cinema.Model.Food;

public class FoodMenuController {
    
    public static List<Food> menuFood = new ArrayList<>();

    public static Food menuFood(String nome, Double preco, String descprition){


        Food foodMenu = new Food(nome, preco, descprition);
        fillMenuArray(foodMenu);

        return null;
    }


    public static void fillMenuArray(Food menu){
        menuFood.add(menu);
    }

    public static List<Food> getFoodMenu(){
        return menuFood;
    }


}
