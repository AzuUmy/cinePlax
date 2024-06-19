package com.cinema.functions;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Model.BuyTickets;
import com.cinema.Model.userSession;
import com.cinema.exception.ErroReadingFiles;

public class creatTicketsTable {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private File ticketsDir = new File("D:\\cinema\\cinema\\database\\tickets");


    public void cretUserTicket(userSession session, BuyTickets tickets) throws ErroReadingFiles{
        System.out.println("Function called");
        File ticketsTable = new File(ticketsDir, session.getUserId() + 
         "-" + session.getNome() + "-"  + tickets.getNome() + "-" + ".txt");

         if(!ticketsTable.exists()){
            try{
                boolean tableCreated = ticketsTable.createNewFile();

                if(tableCreated){
                    System.out.println("table created");
                }else{
                    System.out.println("failled to creat table");
                }
                
                writeTicket(session, tickets);
            }catch(IOException e){
                throw new ErroReadingFiles(ErroReadingFiles.standadartMessage(e));
            }            
         }
    }

    public void writeTicket(userSession session, BuyTickets tickets) throws IOException {
        File movieTicket = new File(ticketsDir, session.getUserId() + 
        "-" + session.getNome() + "-"  + tickets.getNome() + "-" + ".txt");


       // if (movieTicket.exists()) {
       //     System.out.println("File found: " + movieTicket.getAbsolutePath());
      //  } else {
       //     System.out.println("File not found: " + movieTicket.getAbsolutePath());
       // }

        FileWriter table = new FileWriter(movieTicket, true);
        PrintWriter write = new PrintWriter(table);

        List<BuyTickets> ticket = new ArrayList<>();
        ticket.add(tickets);

        for (BuyTickets buyTickets : ticket) {
            write.println("Nome: " + buyTickets.getNome()
            + "," + " " + "Classificacao: " + buyTickets.getClassificacao() + "," + " " 
            + "Genero: " + String.join(" . ", buyTickets.getGenero()) + "," + " " +
            "Duracao: " + buyTickets.getHora() + "h" + " e " +
            buyTickets.getMinuto() + "m" + ";");
        }

       // for (BuyTickets filleTicket : ticket) {
         //   write.println("Nome: " + filleTicket.getNome());
          //  write.println("Gênero: " + String.join(", ", filleTicket.getGenero()));
          //  write.println("Classificação: " + filleTicket.getClassificacao());
          //  write.println("Duração: " + filleTicket.getHora() + "h " + filleTicket.getMinuto() + "min");
         //   write.println("Data: " + filleTicket.getData());
          //  write.println("Horário de Reserva: " + filleTicket.getHorarioReserva());
          //  write.println("Minuto de Reserva: " + filleTicket.getMinutoReserva());
      //  }


        write.flush();
        write.close();

        System.out.println("Finished writing to the file");
    }
}
