package com.cinema.Controller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.Food;
import com.cinema.Model.userSession;


public class userOrders {
     private static final Logger logger = LogManager.getLogger(Main.class);
     private static Map<userSession, Food> userOrders = new HashMap<>();
     private static  UUID id = null;


         public static Food readOrder(userSession session, String pedido, int quantidade){
            userSession user = SessionManager.getUserDataFromSession(id);

            
            if(user != null){
               Food order = new Food(pedido, quantidade);
               fillArray(session, order);
               return order;
            }else{
               logger.error("User not Loged-in");
            }
           
            return null;
         }



         public static void fillArray(userSession session, Food food){
            logger.info("Filling the array with user orders");
            userOrders.put(session, food);
         }


         public static void clearTickets() {
            logger.info("Clearing catalog array");
            userOrders.clear();
        }

         public static Map<userSession, Food> getOrder(){
            logger.info("Collectiong data of the user");
             return userOrders.entrySet().stream()
                .filter(entry -> entry.getKey().getUserId().equals(id))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
          


         public static void validateUserInSession(String email){
            if(SessionManager.isUserLoggedIn(email)){
                userSession UserSession = SessionManager.getUserSession(email);
                if(UserSession != null){
                    id = UserSession.getUserId();
                    logger.info("Called from read ticker: " + UserSession.getNome() + UserSession.getUserId());
                }
            }
        }

}
