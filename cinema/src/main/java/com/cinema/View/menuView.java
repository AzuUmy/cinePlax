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
            System.out.println("4: comprar ingresso");
            System.out.println("5: mostrar ingressos comprados");
            System.out.println("6: editar ingresso");
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

                case 4: 
                 buy();
                    break;
                case 5:
                viewBougthTickets();
                    break;  
                    
                    case 6:
                    editUserTicket();
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


    public static void buy(){
        try {
            buyTicketsView.main(new String[0]);
        }catch (Exception e){
         //   logger.error("Erro Executing User Registration" + e.getMessage());
            //System.out.println("Erro Executing view login" + e.getMessage());
        }
    }


    public static void viewBougthTickets(){
        try {
            viewUserTicket.main(new String[0]);
        }catch (Exception e){
         //   logger.error("Erro Executing User Registration" + e.getMessage());
            //System.out.println("Erro Executing view login" + e.getMessage());
        }
    }

    public static void editUserTicket(){
        try {
            editTicketView.main(new String[0]);
        }catch (Exception e){
         //   logger.error("Erro Executing User Registration" + e.getMessage());
            //System.out.println("Erro Executing view login" + e.getMessage());
        }
    }

}
