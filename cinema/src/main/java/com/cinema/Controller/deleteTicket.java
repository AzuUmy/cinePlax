package com.cinema.Controller;
import java.util.UUID;
import com.cinema.Model.Catalogue;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;
import com.cinema.functions.deleteTicketFile;

public class deleteTicket {
    
    private static  UUID id = null;


    public static movieTicket deleteMovieTicket(movieTicket deleteTicket){

        userSession session = SessionManager.getUserDataFromSession(id);

        if(session != null) {

            String movieName = deleteTicket.getNome();


            Catalogue deleteUserTicket = new movieTicket(movieName);

            
            deleteTicketFile.deleteUserTicket(session, deleteUserTicket);



        }else{
            System.out.println("User not logein");
        }

        return null;
    }

     public static void validateUserInSession(String email){
        if(SessionManager.isUserLoggedIn(email)){
            userSession UserSession = SessionManager.getUserSession(email);
            if(UserSession != null){
                id = UserSession.getUserId();
                System.out.println("Called from read ticker: " + UserSession.getNome() + UserSession.getUserId());
            }
        }
    }


}

