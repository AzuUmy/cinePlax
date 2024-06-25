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
    private File salesDir = new File("D:\\cinema\\cinema\\database\\foodSales");

    public void createFoodSalesTicket(userSession session, Food food, int quantity) {
        logger.info("Creating food sales ticket");

        if (!salesDir.exists()) {
            salesDir.mkdirs(); 
        }

        File salesTicket = new File(salesDir, "orders.txt");

        try {
            if (salesTicket.createNewFile()) {
                logger.info("Sales ticket created: " + salesTicket.getName());
            } else {
                logger.warn("Sales ticket already exists: " + salesTicket.getName());
            }
            

            String user = session.getNome();
            String order =  food.getName();
            String id = session.getUserId().toString();

            writeTicket(id, user, order, quantity, salesTicket); 



        } catch (IOException e) {
            logger.error("Error creating or writing to sales ticket", e);
        }
    }

    private void writeTicket(String id,  String user, String order, int quantity, File salesTicket) {
        try (FileWriter fileWriter = new FileWriter(salesTicket, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {

           writer.println("Id: " +  id + "," + " " +  "Usuario: " + user + "," + " "
            + "Pedido: " + order + "," + " " + "Quantidade: " + quantity + ";");

            logger.info("Finished writing to the sales ticket");
        } catch (IOException e) {
            logger.error("Error writing to the sales ticket", e);
        }
    }
}
