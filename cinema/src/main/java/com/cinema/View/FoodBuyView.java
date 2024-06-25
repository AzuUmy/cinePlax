package com.cinema.View;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.SaleFoodController;
import com.cinema.Model.Food;
import com.cinema.exception.ErroReadingFiles;

public class FoodBuyView {
    final static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Running food purchase menu");

        System.out.println("Digite o nome do alimento:");
        String name = scanner.nextLine();

        System.out.println("Digite o preço do alimento:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        System.out.println("Digite a descrição do alimento:");
        String description = scanner.nextLine();

        Food selectedFood = new Food(name, price, description);

        System.out.println("Quantidade:");
        int quantity = scanner.nextInt();

        try {
            SaleFoodController.buyFood(selectedFood, quantity);
            System.out.println("Compra realizada com sucesso!");
        } catch (ErroReadingFiles e) {
            System.err.println("Erro ao processar a compra: " + e.getMessage());
        }
    }
}
