package com.cinema.View;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.SessionManager;
import com.cinema.Controller.buyTicketController;
import com.cinema.Controller.loginController;
import com.cinema.Controller.readUserTickets;
import com.cinema.Model.login;
import com.cinema.Model.userSession;
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
            ValidateUser(email);
            buyTicketController.validateUserInSession(email);
            readUserTickets.validateUserInSession(email);
        }else{
            logger.warn("Credentials no founded user not loged in");
            System.out.println("Usuario nao logado");
        }
    }

    public static void ValidateUser(String email){
        if(SessionManager.isUserLoggedIn(email)){
            userSession UserSession = SessionManager.getUserSession(email);
            System.out.println("user logedin: " + UserSession.getNome());
        }else{
            System.out.println("please log in on the aplication to buy a ticket");
        }
    }
}
