package com.cinema.functions;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cinema.Model.Food;
import com.cinema.Model.userSession;

public class DeleteFoodTicket {
    private static File foodTicketsDir = new File("/Users/gabriel_lourenco/Documents/Codigos/cinePlax/cinema/database/foodSales");
    private static final Logger logger = LogManager.getLogger(DeleteFoodTicket.class);

    public static void deleteUserFoodTicket(userSession session, Food food) {
        logger.info("Deleting food ticket file");
        File ticketFile = new File(foodTicketsDir, session.getUserId() + 
            "-" + session.getNome() + "-"  + food.getName() + "-" + ".txt");

        if (ticketFile.isFile()) {
            System.out.println("Path: " + ticketFile.getAbsolutePath());
            if (ticketFile.delete()) {
                logger.info("File deleted successfully: " + ticketFile.getAbsolutePath());
            } else {
                logger.error("Failed to delete the file: " + ticketFile.getAbsolutePath());
            }
        } else {
            logger.warn("File does not exist: " + ticketFile.getAbsolutePath());
        }
    }
}
