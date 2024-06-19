package com.cinema.View;
import java.util.List;
import java.util.Scanner;
import com.cinema.Controller.buyTicketController;
import com.cinema.Controller.catalogueController;
import com.cinema.Model.BuyTickets;
import com.cinema.Model.Catalogue;
import com.cinema.functions.readMovieTable;




public class buyTicketsView {
      final static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) throws Exception  {
     

    readMovieTable.readMovieCalatologue();
    List<Catalogue> catalogList = catalogueController.getCartaz();


    int counter = 0;
    for (Catalogue catalog : catalogList) {
        System.out.println("Opcao" + " " + counter + " " + "Nome " + catalog.getNome());
        String[] generos = catalog.getGenero();
        for (int i = 0; i < generos.length; i++) {
            System.out.print(generos[i]);
            if (i < generos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Classificacao: " + catalog.getClassificacao());
        System.out.println("Duracao: " + catalog.getHora() + "h " + catalog.getMinuto() + "min");
        System.out.println("----------------------");
        counter++;
    }



     System.out.println("Selecione o filme que deseja assitir");
     int index = scanner.nextInt();

     //metodo para escrever o nome do filme no nome do arquivo
     if (index >= 0 && index < catalogList.size()) {
        Catalogue selectedMovie = catalogList.get(index);
        BuyTickets pickedTicket = new BuyTickets(
            selectedMovie.getNome(),
            selectedMovie.getGenero(),
            selectedMovie.getClassificacao(),
            selectedMovie.getHora(),
            selectedMovie.getMinuto(),
            "2024-06-19", // example date
            "19:00", // example reservation hour
            "00" // example reservation minute
        );
        
        buyTicketController.buyMovieTickets(pickedTicket);


   

     }
     
    }


 
}

