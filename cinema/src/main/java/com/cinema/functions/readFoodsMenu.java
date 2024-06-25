package com.cinema.functions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cinema.CinePlax.Main;
import com.cinema.Controller.FoodMenuController;
import com.cinema.exception.ErroReadingFiles;

public class readFoodsMenu {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static File foodMenu = new File("D:\\cinema\\cinema\\database\\foodMenu");


    public static void readMenu() throws ErroReadingFiles{
        File menuFile = new File(foodMenu, "menu.txt");


        if(menuFile.exists()){
            logger.info("File founded");
        }else{
            System.out.println("File not Founded");
        }


        if(menuFile.isFile()){
            try(BufferedReader reader = new BufferedReader(new FileReader(menuFile))){

                String line;
                String nome = "";
                String precoString = "";
                Double preco = 0.00;
                String descricacao = "";

                while ((line = reader.readLine()) != null) {

                    if(line.contains("nome:")){
                        int start = line.indexOf("nome:") + "nome:".length();
                        int end = line.indexOf(",", start);

                        nome = line.substring(start, end).trim();

                      //  System.out.println(nome);
                    }

                    if(line.contains("preco:")){
                        int start = line.indexOf("preco:") + "preco:".length();
                        int end = line.indexOf(",", start);

                        precoString = line.substring(start, end).trim();
                        preco = Double.parseDouble(precoString);

                       // System.out.println(preco);
                    }

                    if(line.contains("description:")){
                        int start = line.indexOf("description:") + "description:".length();
                        int end = line.indexOf(";");

                        descricacao = line.substring(start, end).trim();

                    }

                    FoodMenuController.menuFood(nome, preco, descricacao);
                }

            }catch (IOException e){
                logger.error("erro reading file" + e.getMessage());
                throw new ErroReadingFiles(e.toString());
            }
        }

    }


}
