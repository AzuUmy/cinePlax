package com.cinema.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;

public class readFoodSalesTicket {
    private static final Logger logger = LogManager.getLogger(readFoodSalesTicket.class);
    private File salesDir = new File("/Users/gabriel_lourenco/Documents/Codigos/cinePlax/cinema/database/foodSales");

    public String readFood(String foodName) {
        File salesTicket = new File(salesDir, foodName + ".txt");

        if (!salesTicket.exists()) {
            logger.error("Sales ticket does not exist: " + salesTicket.getName());
            return null;
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(salesTicket))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            logger.info("Finished reading the sales ticket");
        } catch (IOException e) {
            logger.error("Error reading the sales ticket", e);
            return null;
        }

        return content.toString();
    }
}
