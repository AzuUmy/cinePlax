package com.cinema.Controller;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.Food;
import com.cinema.Model.userSession;
import com.cinema.exception.ErroReadingFiles;
import com.cinema.functions.CreateFoodTickets;
import com.cinema.functions.DeleteFoodTicket;

public class SaleFoodController {
    private static final Logger logger = LogManager.getLogger(Main.class);


    private static UUID id = null;

    // Compra de tickets de alimentos
    public static void buyFood(Food food, int quantity) throws ErroReadingFiles {
        logger.info("Calling method to buy food");

        userSession session = SessionManager.getUserDataFromSession(id);

        if(session != null){
            CreateFoodTickets foodSalesWriter = new CreateFoodTickets();
            foodSalesWriter.createFoodSalesTicket(session, food, quantity);
        }else{
            logger.info("User not Loged in"); 
        }
 
    }


    public static void deletOder(Food food){
        userSession session = SessionManager.getUserDataFromSession(id);
       if(session != null){
           
        System.out.println(food.getName());
            DeleteFoodTicket.deleteFoodTicket(session, food);
        }else{
            logger.info("User not Loged in"); 
        }
    }



 public static void validateUserInSession(String email){
        logger.info("validating user session in buy ticket method");
        if(SessionManager.isUserLoggedIn(email)){
            logger.info("user is logedin");
            userSession UserSession = SessionManager.getUserSession(email);
            id = UserSession.getUserId();
        }
    }
}
