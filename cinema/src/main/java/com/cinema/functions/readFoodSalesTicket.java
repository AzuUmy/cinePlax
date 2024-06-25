package com.cinema.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class readFoodSalesTicket {
    private static final Logger logger = LogManager.getLogger(readFoodSalesTicket.class);

    public static ArrayList<String> readFoodFile(String foodName) {
        ArrayList<String> listaArquivo = new ArrayList<>();
        try {
            File salesDir = new File("/Users/gabriel_lourenco/Documents/Codigos/cinePlax/cinema/database/foodSales/"+foodName+".txt");
            Scanner leitorArquivo = new Scanner(salesDir);

            while (leitorArquivo.hasNextLine()) {
                String linha = leitorArquivo.nextLine();
                listaArquivo.add(linha);
            }
            leitorArquivo.close();
        } catch (IOException e) {
            logger.error("Erro ao ler arquivo " + e.getMessage());
        }
            return listaArquivo;
    }
}
