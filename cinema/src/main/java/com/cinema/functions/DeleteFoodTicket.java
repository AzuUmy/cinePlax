package com.cinema.functions;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteFoodTicket {
    private static final Logger logger = LogManager.getLogger(DeleteFoodTicket.class);

    public static boolean deleteFoodTicket(String foodName) {
        logger.info("Deleting food ticket file");
        
        File ticketFile = new File("/Users/gabriel_lourenco/Documents/Codigos/cinePlax/cinema/database/foodSales/" + foodName + ".txt");

        return ticketFile.exists() && ticketFile.delete();
    }
}
