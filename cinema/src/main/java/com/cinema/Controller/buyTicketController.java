package com.cinema.Controller;
import java.util.UUID;
import com.cinema.Model.BuyTickets;
import com.cinema.Model.userSession;
import com.cinema.exception.ErroReadingFiles;
import com.cinema.functions.creatTicketsTable;

public class buyTicketController {

    private static  UUID id = null;

    public static BuyTickets buyMovieTickets(BuyTickets tickets, int quantity) throws ErroReadingFiles{
            userSession session = SessionManager.getUserDataFromSession(id);
            if(session != null){
                creatTicketsTable creaUserTicket = new creatTicketsTable();
                creaUserTicket.cretUserTicket(session, tickets, quantity);
            }else{
                System.out.println("Usuario nao logado");
            }

            return null;
    }

    public static void validateUserInSession(String email){
        if(SessionManager.isUserLoggedIn(email)){
            userSession UserSession = SessionManager.getUserSession(email);
            id = UserSession.getUserId();
        }
    }
}
