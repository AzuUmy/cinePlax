package com.cinema.Controller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.login;

public class loginController {
        private static final Logger logger = LogManager.getLogger(Main.class);
       
        private static Map<UUID, login> loginInto = new HashMap<>();

        public static login loginUsuario(String email, String senha, UUID id){

            logger.info("login in on the aplication");


            UUID userId =  id;
            login logInUser = new login(email, senha);


            fillUsersArray(userId, logInUser);

            return logInUser;

        }


        private static void fillUsersArray(UUID userId, login logInUser){
            logger.info("Filling login array with user");
            loginInto.put(userId, logInUser);
        }


        public static Map<UUID, login> getUser(){
            logger.info("Retriving user");
            return loginInto;
        }


        public static boolean validateUserCredetials(String email, String Senha){
            logger.info("Validating user credentials");
            for (login user : loginInto.values()) {
                if(user.getEmail().equals(email) && user.getSenha().equals(Senha)){
                    return true;
                }
            }
            return false;
        }
}
