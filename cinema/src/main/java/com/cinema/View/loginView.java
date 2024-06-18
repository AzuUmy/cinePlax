package com.cinema.View;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.loginController;
import com.cinema.Model.login;
import com.cinema.functions.readUserDatabase;

public class loginView {
     private static final Logger logger = LogManager.getLogger(Main.class);
 private static final Scanner scanner = new Scanner(System.in);
     public static void main(String[] args){

        readUserDatabase.readUser();

        Map<UUID, login> logedUser = loginController.getUser();

        logInAplication(logedUser);

     }


     public static void logInAplication(Map<UUID, login> logedUser){
        logger.info("Login in on the aplication");
        System.out.println("informe o email do usuario");
        String email = scanner.nextLine();
        System.out.println("Informe a senha do usuario");
        String senha = scanner.nextLine();

        boolean isValid = loginController.validateUserCredetials(email, senha);

        if(isValid){
            logger.info("Credential Valide user loged in");
            System.out.println("Usuario logado com sucesso");
        }else{
            logger.warn("Credentials no founded user not loged in");
            System.out.println("Usuario nao logado");
        }


    }
}
