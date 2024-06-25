package com.cinema.View;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.FoodMenuController;
import com.cinema.Controller.SaleFoodController;
import com.cinema.Model.Food;
import com.cinema.exception.ErroReadingFiles;
import com.cinema.functions.readFoodsMenu;

public class FoodBuyView {
    final static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ErroReadingFiles {
        logger.info("Running food purchase menu");

      //String foodName;
        readFoodsMenu.readMenu();
        List<Food> menuList = FoodMenuController.getFoodMenu();


        for (Food food : menuList) {
            System.out.println("=======================");
            System.out.println("Nome: " + food.getName());
            System.out.println("Preco: " + food.getPrice());
            System.out.println("Descricao: " + food.description());
            System.out.println("=======================");
        }


        System.out.println("Selecione a refeicao desejada");
        int index = scanner.nextInt(); 

        if(index >= 0 && index < menuList.size()){
            Food selectedFood = menuList.get(index);
            System.out.println("Selected food: " +selectedFood.getName());
            System.out.println("Selecione a quantidade");
            int quan = scanner.nextInt();
            
            SaleFoodController.buyFood(selectedFood, quan);
        }

    }
}
