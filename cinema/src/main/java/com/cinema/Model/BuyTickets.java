package com.cinema.Model;

public class BuyTickets extends Catalogue {
    private String data;
    private String horarioReserva;
    private String minutoReserva;
    
    
    public BuyTickets(String nome) {
        super(nome);
    }


    public BuyTickets(String nome, String[] genero, String classificacao, int hora, int minuto, String data,
        String horarioReserva, String minutoReserva) {
        super(nome, genero, classificacao, hora, minuto);
        this.data = data;
        this.horarioReserva = horarioReserva;
        this.minutoReserva = minutoReserva;
    }

  
    //getters
    public String getData() {
        return data;
    }


    public String getHorarioReserva() {
        return horarioReserva;
    }


    public String getMinutoReserva() {
        return minutoReserva;
    }

      //setters

    public void setData(String data) {
        this.data = data;
    }

    public void setHorarioReserva(String horarioReserva) {
        this.horarioReserva = horarioReserva;
    }

    public void setMinutoReserva(String minutoReserva) {
        this.minutoReserva = minutoReserva;
    }


  


    
}
