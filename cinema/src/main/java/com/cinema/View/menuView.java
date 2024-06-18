package com.cinema.View;
import java.util.Scanner;

public class menuView {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
      
        int runtime = 100;

        for(int i = 0; i < runtime; i++){
            System.out.println("Menu");
            System.out.println("1: Cadastrar usuario");
            System.out.println("2: listar filmes em cartaz");
            System.out.println("3: Logar na aplicacao");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                executeCreatUser();
                break;

                case 2:
                executeCartaz();
                break;
            
                case 3:
                login();
                break;
                default:
                    break;
            }
        }
        
    }


//Creat a class ta handles this exceptions
    public static void executeCreatUser(){
        try {
            cadasstroDeUsuarioView.main(new String[0]);
        }catch (Exception e){
          //  logger.error("Erro Executing User Registration" + e.getMessage());
            System.out.println("Erro Executing User Registration" + e.getMessage());
        }
    }

    public static void executeCartaz(){
        try {
            cartazView.main(new String[0]);
        }catch (Exception e){
         //   logger.error("Erro Executing User Registration" + e.getMessage());
            System.out.println("Erro Executing view Catalogue" + e.getMessage());
        }
    }


    public static void login(){
        try {
            loginView.main(new String[0]);
        }catch (Exception e){
         //   logger.error("Erro Executing User Registration" + e.getMessage());
            System.out.println("Erro Executing view login" + e.getMessage());
        }
    }

}