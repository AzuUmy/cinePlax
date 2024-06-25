package com.cinema.View;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.SaleFoodController;

public class FoodDeleteView {
    final static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Running food delete menu");

        System.out.println("Digite o nome do alimento para deletar o ticket:");
        String name = scanner.nextLine();
        SaleFoodController.deleteFoodTicket(name);

        try {
            System.out.println("Ticket deletado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao deletar o ticket: " + e.getMessage());
        }
    }
}
