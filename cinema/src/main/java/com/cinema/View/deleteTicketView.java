package com.cinema.View;
import java.util.List;
import java.util.Scanner;

import com.cinema.Controller.deleteTicket;
import com.cinema.Controller.readUserTickets;
import com.cinema.Model.Catalogue;
import com.cinema.Model.movieTicket;

public class deleteTicketView {
        final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception  {

        List<movieTicket> userMovieTikckest = readUserTickets.getUserTickets();

        System.out.println("Ingresso disponiveis para cancelar");

        for (movieTicket movieTicket : userMovieTikckest) {
            System.out.println("------------------------------");
            System.out.println("Nome: " + movieTicket.getNome());
            System.out.println("------------------------------");
         }

         System.out.println("Selecione o ingresso que deseja deletar");

         int index = scanner.nextInt();

         Catalogue selectedTicket = userMovieTikckest.get(index);

         for (movieTicket movieTicket : userMovieTikckest) {
            if(movieTicket.getNome().equals(selectedTicket.getNome())){
                deleteTicket.deleteMovieTicket(movieTicket);
            }
         }



    }

}
