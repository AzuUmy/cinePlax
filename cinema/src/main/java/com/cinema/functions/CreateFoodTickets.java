package com.cinema.functions;

import com.cinema.Model.Food;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFoodTickets {
    private static final Logger logger = LogManager.getLogger(CreateFoodTickets.class);
    private File salesDir = new File("/Users/gabriel_lourenco/Documents/Codigos/cinePlax/cinema/database/foodSales");

    public void createFoodSalesTicket(Food food, int quantity) {
        logger.info("Creating food sales ticket");

        if (!salesDir.exists()) {
            salesDir.mkdirs(); // Cria o diretório se não existir
        }

        File salesTicket = new File(salesDir, food.getName() + ".txt");

        try {
            if (salesTicket.createNewFile()) {
                logger.info("Sales ticket created: " + salesTicket.getName());
            } else {
                logger.warn("Sales ticket already exists: " + salesTicket.getName());
            }
            
            writeTicket(food, quantity, salesTicket); // Sempre chama o método para escrever no ticket

        } catch (IOException e) {
            logger.error("Error creating or writing to sales ticket", e);
        }
    }

    private void writeTicket( Food food, int qtd, File salesTicket) {
        try (FileWriter fileWriter = new FileWriter(salesTicket, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {

            writer.println("----- Nota Fiscal -----");
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
