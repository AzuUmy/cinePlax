package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;
import com.cinema.Model.BuyTickets;

public class seatsController {
    private static List<BuyTickets> seatsList = new ArrayList<>();


    public static void seatsList(List<Integer> seatNumber ){

        BuyTickets ticketsSeat = new BuyTickets(seatNumber);


        fillArrayOfseats(ticketsSeat);


    }


    private static void fillArrayOfseats(BuyTickets seats){
        seatsList.add(seats);
    }

    public static List<BuyTickets> getMovieSeats(){
        return seatsList;
    }
}

