package com.cinema.functions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.Model.Food;
import com.cinema.Model.userSession;

public class DeleteFoodTicket {
    private static final Logger logger = LogManager.getLogger(DeleteFoodTicket.class);
    private static final File orderTable = new File("D:\\cinema\\cinema\\database\\foodSales");

    public static void deleteFoodTicket(userSession session, Food food) {
        logger.info("Deleting food ticket file");
        
        File orderFile = new File(orderTable, "orders.txt");

        if(orderFile.isFile()){
            logger.info("Orders File Founded");
            UUID uuid = session.getUserId();
            String order = food.getName();
            String pathOfile = orderFile.toString();
            String id = uuid.toString();
            deletFoodOrder(id, order, pathOfile);
        }else{
            logger.info("Orders file not founded");
        }

    }



    public static void deletFoodOrder(String id, String order, String path){
         logger.info("deleting order in file");
         File file = new File(path);
         File storage = new File(file.getParentFile(), "Storage.txt");
 
         try(BufferedReader reader = new BufferedReader(new FileReader(file));
         BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){
 
             String curretLine;
             boolean found = false;
 
             while ((curretLine = reader.readLine()) != null) {
                 if(curretLine.contains(id) && curretLine.contains(order)){
                     found = true;
                     continue; 
                 }else{
                     writer.write(curretLine);
                 }
 
                 writer.newLine();
                 if (!found) {
                     logger.info("File not founded");
                 }
             }
 
         } catch(IOException e){
             logger.error("Failled to edit File");
         }

         try {
           if (!file.delete()) {
                logger.info("Could not delete the original file.");
             }
     
             if (!storage.renameTo(file)) {
                logger.info("Could not rename the temporary file to the original file name.");
            }
           } catch (Exception e) {
                logger.error("Error replacing the original file: " + e.getMessage());
            }
 
     }
 
 }
 