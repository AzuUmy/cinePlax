package com.cinema.View;
import java.util.List;
import com.cinema.Controller.readUserTickets;
import com.cinema.Model.movieTicket;

public class viewUserTicket {
    

    public static void main(String[] args) throws Exception  {


    
    List<movieTicket> userMovieTikckest = readUserTickets.getUserTickets();

    for (movieTicket movieTicket : userMovieTikckest) {
        System.out.println("=======================================================");
        System.out.println("Nome: " + movieTicket.getNome());
        System.out.println("-------------------------------------------------------");
        System.out.println("Classificacao: " + movieTicket.getClassificacao());
        System.out.println("-------------------------------------------------------");
        System.out.println("duracao: " + movieTicket.getHora() + " e " + movieTicket.getMinuto() + "h");
        System.out.println("-------------------------------------------------------");
        System.out.println("Genero: " + String.join(" . ",movieTicket.getGenero()));
        System.out.println("-------------------------------------------------------");
        System.out.println("Data: " + movieTicket.getData());
        System.out.println("-------------------------------------------------------");
        System.out.println("Horario: " + movieTicket.getHorario());
        System.out.println("-------------------------------------------------------");
        System.out.println("Assentos: " + String.join(" . ",  movieTicket.getSeat()));
        System.out.println("-------------------------------------------------------");
        System.out.println("Quantidade: " + movieTicket.getQuantidade());
        System.out.println("=======================================================");
        
        System.out.println();
    }

    }

}
