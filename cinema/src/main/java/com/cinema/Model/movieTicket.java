package com.cinema.Model;

public class movieTicket extends Catalogue{

    private String data;
    private String horario;
    private int quantidade;
    public movieTicket(){}

  
    
    public movieTicket(String nome, String[] genero, String classificacao, int hora, int minuto, String[] seat,
        String data, String horario, int quantidade) {
        super(nome, genero, classificacao, hora, minuto, seat);
        this.data = data;
        this.horario = horario;
        this.quantidade = quantidade;
    }



    //Getters
    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    
}
