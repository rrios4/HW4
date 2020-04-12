package com.CIS3368.HW4.model;
import javax.persistence.*;

@Entity
@Table(name = "joke_table")
public class Joke {
    @Id
    @Column(name ="id")
    private String id;
    @Column(name = "jokes")
    private String jokeStatement;

    public Joke()
    {

    }

    public Joke(String id, String jokeStatement){
        this.id = id;
        this.jokeStatement = jokeStatement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return jokeStatement;
    }

    public void setJoke(String jokeStatement) {
        this.jokeStatement = jokeStatement;
    }
}
