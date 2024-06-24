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
        if (session != null) {
            logger.info("User session validated");
            CreateFoodTickets foodSalesWriter = new CreateFoodTickets();
            foodSalesWriter.createFoodSalesTicket(session, food, quantity);
        } else {
            logger.error("Error validating user, not logged in");
        }
    }

    // Validação da sessão do usuário
    public static void validateUserInSession(String email) {
        logger.info("Validating user session in buy food method");
        if (SessionManager.isUserLoggedIn(email)) {
            logger.info("User is logged in");
            userSession userSession = SessionManager.getUserSession(email);
            id = userSession.getUserId();
        }
    }

    // Deleção de tickets de alimentos
    public static void deleteFoodTicket(Food food) {
        logger.info("Calling method to delete food ticket");
        userSession session = SessionManager.getUserDataFromSession(id);
        if (session != null) {
            logger.info("User session validated");
            DeleteFoodTicket.deleteUserFoodTicket(session, food);
        } else {
            logger.error("Error validating user, not logged in");
        }
    }
}
