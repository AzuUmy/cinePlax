package com.cinema.Model;
import java.util.UUID;

public class userSession extends Usuario {

    private UUID userId;

    public userSession() {}


    public userSession(UUID userId, String nome) {
        super(nome);
        this.userId = userId;
    }


    public UUID getUserId() {
        return userId;
    }

    

}
