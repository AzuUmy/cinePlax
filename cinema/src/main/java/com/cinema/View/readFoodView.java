package com.cinema.View;
import java.util.Map;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.userOrders;
import com.cinema.Model.Food;
import com.cinema.Model.userSession;
import com.cinema.exception.ErroReadingFiles;
import com.cinema.functions.readFoodSalesTicket;


public class readFoodView {
    final static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static void main(String[] args) throws ErroReadingFiles {
    readFoodSalesTicket.readFood();

    Map<userSession, Food> orders =  userOrders.getOrder();


    for (Map.Entry<userSession, Food> entry : orders.entrySet()) {
        System.out.println("================ " + "pedido de: " + entry.getKey().getNome() + " ===============");
        System.out.println("pedidos: " + entry.getValue().getName());
        System.out.println("Quantidade " + entry.getValue().getQuantity());
    }
 }

}
