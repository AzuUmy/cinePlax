package com.cinema.Controller;

import java.util.UUID;

import com.cinema.Model.Usuario;
import com.cinema.Model.login;
import com.cinema.Model.userSession;
import com.cinema.functions.editUserInfo;

public class editUserData {

    private static  UUID id = null;


    public static Usuario editUserEmail (userSession userEmail){

        userSession session = SessionManager.getUserDataFromSession(id);

        if(session != null){
            
            editUserInfo.editEmail(session, userEmail);

        }else{
            System.out.println("Usuario nao logado");
        }
        

        return userEmail;


    }



    public static  Usuario  editUserPassword(Usuario userPassword){
        userSession session = SessionManager.getUserDataFromSession(id);


        if(session != null){
            
            System.out.println(userPassword);



            editUserInfo.editPassword(session, userPassword);

        }else{
            System.out.println("Usuario nao logado");
        }

            return null;
    }


    
    public static void validateUserInSession(String email){
        if(SessionManager.isUserLoggedIn(email)){
            userSession UserSession = SessionManager.getUserSession(email);
            if(UserSession != null){
                id = UserSession.getUserId();
                System.out.println("Called from edit user info ticker: " + UserSession.getNome() + UserSession.getUserId());
            }
        }
    }

}
