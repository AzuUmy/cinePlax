package com.cinema.Controller;
import java.util.List;
import java.util.UUID;

import com.cinema.Model.BuyTickets;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;
import com.cinema.functions.editedTickedInfo;

public class editTicket {
    private static  UUID id = null;




    public static movieTicket editTicketData(movieTicket editeDate){

        userSession session = SessionManager.getUserDataFromSession(id);

        if(session != null){
            editedTickedInfo.editedTicketDate(session, editeDate);
        }else{
            System.out.println("User not loged in");
        }
       
        return null;
    }


    public static movieTicket editTicketSessionTime(movieTicket editSessionTime){

        userSession session = SessionManager.getUserDataFromSession(id);


        if(session != null){
            editedTickedInfo.editSession(session, editSessionTime);
        }else{
            System.out.println("User is not loged in");
        }

        return null;
    }


    public static movieTicket editSeats(movieTicket edMovieTicket){
        userSession session = SessionManager.getUserDataFromSession(id);


        if(session != null){
       

            editedTickedInfo.editSets(session, edMovieTicket);

        }else{
            System.out.println("User is not loged in");
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
