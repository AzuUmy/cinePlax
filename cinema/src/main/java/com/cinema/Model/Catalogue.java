package com.cinema.Model;


public class Catalogue {
    
    private String nome;
    private String[] genero;
    private String classificacao;
    private int hora;
    private int minuto;
    private String[] seat;


    public Catalogue(String nome) {
        this.nome = nome;
    }


    public Catalogue() {}


    public Catalogue(String nome, String[] genero, String classificacao, int hora, int minuto, String[] seat) {
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.hora = hora;
        this.minuto = minuto;
        this.seat = seat;
    }


    public Catalogue(String nome, String[] genero, String classificacao, int hora, int minuto) {
            this.nome = nome;
            this.genero = genero;
            this.classificacao = classificacao;
            this.hora = hora;
            this.minuto = minuto;
        }



    //getters
    public String getNome() {
        return nome;
    }



    public String[] getGenero() {
        return genero;
    }



    public String getClassificacao() {
        return classificacao;
    }



    public int getHora() {
        return hora;
    }



    public int getMinuto() {
        return minuto;
    }


    public String[] getSeat() {
        return seat;
    }

   


}
