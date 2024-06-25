package com.cinema.View;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.SaleFoodController;

public class readFoodView {
    final static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static void main(String[] args) {
        String foodName;
        System.out.println("Informe o nome do arquivo: ");
        foodName = scanner.nextLine(); 

        SaleFoodController read = new SaleFoodController();
        read.callReadFood(foodName);
    }
}
