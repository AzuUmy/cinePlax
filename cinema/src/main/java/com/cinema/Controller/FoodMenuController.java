package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.Food;

public class FoodMenuController {
    
    public static List<Food> menuFood = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static Food menuFood(String nome, Double preco, String descprition){


        Food foodMenu = new Food(nome, preco, descprition);
        fillMenuArray(foodMenu);

        return null;
    }


    public static void fillMenuArray(Food menu){
        menuFood.add(menu);
    }


    public static void clearTickets() {
        logger.info("Clearing menu array");
        menuFood.clear();
    }

    public static List<Food> getFoodMenu(){
        return menuFood;
    }


}
