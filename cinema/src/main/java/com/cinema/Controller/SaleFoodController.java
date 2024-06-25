package com.cinema.Controller;

import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.Food;
import com.cinema.exception.ErroReadingFiles;
import com.cinema.functions.CreateFoodTickets;
import com.cinema.functions.DeleteFoodTicket;
import com.cinema.functions.readFoodSalesTicket;

public class SaleFoodController {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static UUID id = null;

    // Compra de tickets de alimentos
    public static void buyFood(Food food, int quantity) throws ErroReadingFiles {
        logger.info("Calling method to buy food");

        CreateFoodTickets foodSalesWriter = new CreateFoodTickets();
        foodSalesWriter.createFoodSalesTicket(food, quantity);
    }

    // Deleção de tickets de alimentos
    public static void deleteFoodTicket(String foodName) {
        logger.info("Calling method to delete food ticket");
        DeleteFoodTicket.deleteFoodTicket(foodName);
    }

    public static void callReadFood(String foodName){
        logger.info("Calling method to reading food ticket");

        System.out.println(readFoodSalesTicket.readFoodFile(foodName));
    }
}
