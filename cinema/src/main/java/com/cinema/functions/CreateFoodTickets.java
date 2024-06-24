package com.cinema.functions;

import com.cinema.Model.Food;
import com.cinema.Model.userSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFoodTickets {
    private static final Logger logger = LogManager.getLogger(CreateFoodTickets.class);
    private File salesDir = new File("/Users/gabriel_lourenco/Documents/Codigos/cinePlax/cinema/database/foodSales");

    public void createFoodSalesTicket(userSession session, Food food, int quantity) {
        logger.info("Creating food sales ticket");
        
        if (!salesDir.exists()) {
            salesDir.mkdirs();
        }

        File salesTicket = new File(salesDir, session.getUserId() + 
                "-" + session.getNome() + "-" + food.getName() + "-" + ".txt");

        try {
            if (salesTicket.createNewFile()) {
                logger.info("Sales ticket created: " + salesTicket.getName());
                writeTicket(session, food, quantity, salesTicket);
            } else {
                logger.warn("Sales ticket already exists: " + salesTicket.getName());
                writeTicket(session, food, quantity, salesTicket);
            }
        } catch (IOException e) {
            logger.error("Error creating sales ticket", e);
        }
    }

    private void writeTicket(userSession session, Food food, int qtd, File salesTicket) {
        try (FileWriter fileWriter = new FileWriter(salesTicket, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {

            writer.println("----- Nota Fiscal -----");
            writer.println("Usuário: " + session.getNome());
            writer.println("Código usuário: " + session.getUserId());
            writer.println("Item: " + food.getName());
            writer.println("Descrição: " + food.description());
            writer.println("Quantidade: " + qtd);
            writer.println("Valor: " + food.getPrice() * qtd);
            writer.println("-----------------------------");

            logger.info("Finished writing to the sales ticket");
        } catch (IOException e) {
            logger.error("Error writing to the sales ticket", e);
        }
    }
}
