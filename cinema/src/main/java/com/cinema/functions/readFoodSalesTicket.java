package com.cinema.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.UUID;

public class readFoodSalesTicket {
    
    private static final Logger logger = LogManager.getLogger(readFoodSalesTicket.class);
    private  File salesDir = new File("D:\\cinema\\cinema\\database\\foodSales");

    public void readFood() {
        File salesTicket = new File(salesDir, "orders.txt");

        if (!salesTicket.exists()) {
            logger.error("Sales ticket does not exist: " + salesTicket.getName());
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(salesTicket))) {
            String line;
            String uuidString = "";
            UUID id = null;
            String nome = "";
            String pedido = "";
            String quantidadeString = "";
            int quantidade = 0;


            while ((line = reader.readLine()) != null) {


                if(line.contains("Id:")){
                    int start = line.indexOf("Id:") + "Id:".length();
                    int end =  line.indexOf(",", start);
                    uuidString = line.substring(start, end).trim();
                    id = UUID.fromString(uuidString);
                }


                if(line.contains("Usuario:")){
                    int start = line.indexOf("Usuario:") + "Usuario:".length();
                    int end =  line.indexOf(",", start);
                    nome = line.substring(start, end).trim();
                }
                

                if(line.contains("Pedido:")){
                    int start = line.indexOf("Pedido:") + "Pedido:".length();
                    int end =  line.indexOf(",", start);
                    pedido = line.substring(start, end).trim();
                }
                

                if(line.contains("Quantidade:")){
                    int start = line.indexOf("Quantidade:") + "Quantidade:".length();
                    int end =  line.indexOf(";");
                    quantidadeString = line.substring(start, end).trim();
                    quantidade = Integer.valueOf(quantidadeString);
                }
                
                

            }
            logger.info("Finished reading the sales ticket");
        } catch (IOException e) {
            logger.error("Error reading the sales ticket" + e);
        }
    }
}
