package com.cinema.functions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.Controller.userOrders;
import com.cinema.Model.userSession;
import java.io.*;
import java.util.UUID;

public class readFoodSalesTicket {
    private static final Logger logger = LogManager.getLogger(readFoodSalesTicket.class);
    private static File salesDir = new File("D:\\cinema\\cinema\\database\\foodSales");

    public static void readFood() {
        userOrders.clearTickets();
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

                if(line.contains("id:")){
                    int start = line.indexOf("id:") + "id:".length();
                    int end =  line.indexOf(",", start);
                    uuidString = line.substring(start, end).trim();
                    id = UUID.fromString(uuidString);
                }


                if(line.contains("usuario:")){
                    int start = line.indexOf("usuario:") + "usuario:".length();
                    int end =  line.indexOf(",", start);
                    nome = line.substring(start, end).trim();
                }
                

                if(line.contains("pedido:")){
                    int start = line.indexOf("pedido:") + "pedido:".length();
                    int end =  line.indexOf(",", start);
                    pedido = line.substring(start, end).trim();
                }
                

                if(line.contains("quantidade:")){
                    int start = line.indexOf("quantidade:") + "quantidade:".length();
                    int end =  line.indexOf(";");
                    quantidadeString = line.substring(start, end).trim();
                    quantidade = Integer.valueOf(quantidadeString);
                    
                }
                
                userSession user = new userSession(id, nome);
                userOrders.readOrder(user, pedido, quantidade);    
           }
        } catch (IOException e) {
            logger.error("Error reading the sales ticket" + e);
        }
    }
}
