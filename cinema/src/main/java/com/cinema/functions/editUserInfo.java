package com.cinema.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import com.cinema.Model.Usuario;
import com.cinema.Model.userSession;

public class editUserInfo {
    
  private static File userTable = new File("D:\\cinema\\cinema\\database\\Usuarios");

    public static void editEmail(userSession session, userSession email ){

        File userFile = new File(userTable, "Usuarios.txt");

        if(userFile.isFile()){
            String newEmail = email.getEmail();
            UUID uuid = session.getUserId();
            String pathToFile = userFile.toString();
            String id = uuid.toString();



            editUserEmail(id, newEmail, pathToFile);
        }

    }


    public static void editUserEmail(String id, String newEmail, String path){
       File userInfo = new File(path);
       File storage = new File(userInfo.getParentFile(),"Storage.txt");

       try(BufferedReader reader = new BufferedReader(new FileReader(userInfo));
       BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){

        String curretLine;
        boolean found = false;

        while ((curretLine = reader.readLine()) != null) {
            if (curretLine.contains(id)) {
                String updatedLine = curretLine.replaceAll("email=[^,]*", "email=" + newEmail);
                writer.write(updatedLine);
                found = true;
            } else {
                writer.write(curretLine);
            }

            writer.newLine();
            if (!found) {
                System.out.println("File not founded");
            }
        }

    } catch(IOException e) {
        System.out.println("Erro editing file");
    }

    try {
        if (!userInfo.delete()) {
            System.out.println("Could not delete the original file.");
        }

        if (!storage.renameTo(userInfo)) {
            System.out.println("Could not rename the temporary file to the original file name.");
        }
    } catch (Exception e) {
        System.out.println("Error replacing the original file: " + e.getMessage());
    }

    }


    public static void editPassword(userSession session, Usuario newPassword ){
        File userFile = new File(userTable, "Usuarios.txt");

        if(userFile.isFile()){
            String newPass = newPassword.getSenha();
            UUID uuid = session.getUserId();
            String pathToFile = userFile.toString();
            String id = uuid.toString();

            System.out.println("password in file: " + newPass);

            editUserPassword(id, newPass, pathToFile);
        }
    }


    public static void editUserPassword(String id, String newSenha, String path){
        File userInfo = new File(path);
        File storage = new File(userInfo.getParentFile(),"Storage.txt");
 
        try(BufferedReader reader = new BufferedReader(new FileReader(userInfo));
        BufferedWriter writer = new BufferedWriter(new FileWriter(storage))){
 
         String curretLine;
         boolean found = false;
 
         while ((curretLine = reader.readLine()) != null) {
             if (curretLine.contains(id)) {
                 String updatedLine = curretLine.replaceAll("senha=[^,]*", "senha=" + newSenha + ";");
                 writer.write(updatedLine);
                 found = true;
             } else {
                 writer.write(curretLine);
             }
 
             writer.newLine();
             if (!found) {
                 System.out.println("File not founded");
             }
         }
 
     } catch(IOException e) {
         System.out.println("Erro editing file");
     }
 
     try {
         if (!userInfo.delete()) {
             System.out.println("Could not delete the original file.");
         }
 
         if (!storage.renameTo(userInfo)) {
            System.out.println("Could not rename the temporary file to the original file name.");
         }
     } catch (Exception e) {
        System.out.println("Error replacing the original file: " + e.getMessage());
    }
 
     }
}
