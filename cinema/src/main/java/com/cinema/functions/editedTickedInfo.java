package com.cinema.functions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.cinema.Model.movieTicket;
import com.cinema.Model.userSession;

public class editedTickedInfo {
    
    private static File ticketsTable = new File("D:\\cinema\\cinema\\database\\tickets");


    public static void editedTicketDate(userSession session, movieTicket movieDate){      
       
    File TicketFile = new File(ticketsTable, session.getUserId() + 
    "-" + session.getNome() + "-"  + movieDate.getNome() + "-" + ".txt");

    
        if(TicketFile.isFile()){
            String pathOfFile = TicketFile.toString();
            editDateOnFile(movieDate.getData(), pathOfFile);
        }else {
            System.out.println("File not founded");
        }

    }

    public static void editDateOnFile(String date, String path){
       File file = new File(path);
       File storage = new File(file.getParentFile(), "Storage.txt");

       try(BufferedReader reader = new BufferedReader(new FileReader(file));
       BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){

        String curretLine;
        boolean found = false;

        while ((curretLine = reader.readLine()) != null) {
            if(curretLine.contains("Data:")){

                String updatedLine = curretLine.replaceAll("Data: \\d{2}/\\d{2}/\\d{4}", "Data: " + date);
                writer.write(updatedLine);
                found = true;
            }else{
                writer.write(curretLine);
            }

            if (!found) {
                System.out.println("File not founded");
            }


            writer.close();
            reader.close();


            if(!file.delete()){
                System.out.println("Could not delete the file");
            }

            if (!storage.renameTo(file)) {
                System.out.println("Could not rename to storage");
            }
        }
        
       } catch (IOException e){
        System.out.println("Failed to edit file");
       }
       
    }


    public static void editSession(userSession session, movieTicket movieTime){
        File TicketFile = new File(ticketsTable, session.getUserId() + 
        "-" + session.getNome() + "-"  + movieTime.getNome() + "-" + ".txt");

        if(TicketFile.isFile()){
            String pathOfFile = TicketFile.toString();
          
            editeMovieSession(movieTime.getHora(), movieTime.getMinuto(), pathOfFile);
        }else {
            System.out.println("File not founded");
        }
    
    }


    public static void editeMovieSession(int hora, int minuto, String path){
        File file = new File(path);
        File storage = new File(file.getParentFile(), "Storage.txt");

        try(BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){

            String curretLine;
            boolean found = false;

            while ((curretLine = reader.readLine()) != null) {
                if(curretLine.contains("Reserva:")){

                    String horaStr = String.format("%02d", hora);
                    String minutoStr = String.format("%02d", minuto);
                    String newTime = horaStr + ":" + minutoStr;

                    String updatedLine = curretLine.replaceAll("Reserva: \\d{2}:\\d{2}", "Reserva: " + newTime);
                    writer.write(updatedLine);
                    found = true;
                }else{
                    writer.write(curretLine);
                }


                if (!found) {
                    System.out.println("File not founded");
                }
    
                writer.close();
                reader.close();
    
    
              if(!file.delete()){
                  System.out.println("Could not delete the file");
               }
    
                if (!storage.renameTo(file)) {
                    System.out.println("Could not rename to storage");
               }
            }

        } catch(IOException e){
            System.out.println("File not founded");
        }

    }


    public static void editSets(userSession session, movieTicket movieSeats){
        File TicketFile = new File(ticketsTable, session.getUserId() + 
        "-" + session.getNome() + "-"  + movieSeats.getNome() + "-" + ".txt");

        if(TicketFile.isFile()){
            String pathOfFile = TicketFile.toString();
          
            editeMovieSeats(movieSeats.getSeat(), pathOfFile);
        }else {
            System.out.println("File not founded on edit sets");
        }
    
    }

    public static void editeMovieSeats(String[] seats, String path) {
        File file = new File(path);
        File storage = new File(file.getParentFile(), "Storage.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(storage))) {

            String currentLine;
            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains("Assentos:")) {
                
                    String prefix = "Assentos: ";
                    String suffix = ",";
                    int startIndex = currentLine.indexOf(prefix) + prefix.length();
                    int endIndex = currentLine.indexOf(suffix, startIndex);

                    if (startIndex != -1 && endIndex != -1) {
                        String existingSeats = currentLine.substring(startIndex, endIndex);
                        String updatedSeats = String.join(".", seats);
    
                        String updatedLine = currentLine.replaceFirst(prefix + existingSeats + suffix, prefix + updatedSeats + suffix);
                        writer.write(updatedLine);
                        found = true;
                    }

                } else {
                    writer.write(currentLine);
                }

                writer.close();
                reader.close();

                if(!file.delete()){
                    System.out.println("Could not delete the file");
                 }
      
                  if (!storage.renameTo(file)) {
                      System.out.println("Could not rename to storage");
                 }

            }

            if (!found) {
                System.out.println("No line containing 'Assentos:' found in the file.");
            }

        } catch (IOException e) {
            System.out.println("Error editing file: " + e.getMessage());
        }

    }

}
