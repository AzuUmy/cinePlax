package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;
import com.cinema.functions.readTicketsTable;

public class readUserTickets {

   private static  UUID id = null;
   public static List<movieTicket> userTickets = new ArrayList<>();
   

    public static movieTicket readUserTicket(String nome, String classificacao, String[] genero, int hour,  int minuto
    ,String[] seats, String data, String horario, int quantidade){


        
        try{
                   
                    movieTicket userTicket = new movieTicket(nome,genero, classificacao,hour, minuto,seats,data,horario,quantidade);
                    fillUserTicketArray(userTicket);

                 
                   

                    
        }catch (NullPointerException e){
            System.out.println("session is null");
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

    public static void fillUserTicketArray(movieTicket userTicket){
        userTickets.add(userTicket);
    }

    

    public static List<movieTicket> getUserTickets(){
       
        try{
            userSession session = SessionManager.getUserDataFromSession(id);
            if (session != null) {
                System.out.println("User loged in");
                readTicketsTable.readTicketTable(session);
            }else{
                System.out.println("User not loged in");
            }
            
        }catch(NullPointerException e){
            System.out.println("Session is null");
        }
     
        return userTickets;
    }
}
