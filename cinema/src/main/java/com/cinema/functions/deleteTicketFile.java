package com.cinema.functions;
import java.io.File;
import com.cinema.Model.Catalogue;
import com.cinema.Model.userSession;

public class deleteTicketFile {
    

      private static File ticketsTable = new File("D:\\cinema\\cinema\\database\\tickets");



      public static void deleteUserTicket(userSession session, Catalogue deleteUserTicket){
        File TicketFile = new File(ticketsTable, session.getUserId() + 
        "-" + session.getNome() + "-"  + deleteUserTicket.getNome() + "-" + ".txt");


        if(TicketFile.isFile()){
            System.out.println("path" + TicketFile.getAbsolutePath());
            
            if (TicketFile.delete()) {
              System.out.println("File deleted successfully.");
          } else {
              System.out.println("Failed to delete the file.");
          }
            
        }

      }
}
