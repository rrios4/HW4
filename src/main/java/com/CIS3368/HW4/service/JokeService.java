package com.CIS3368.HW4.service;

import com.CIS3368.HW4.model.Joke;
import com.CIS3368.HW4.model.JokeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JokeService {
    @Autowired
    public JokeRepo jokeRepo;

    public Collection<Joke> listAllJokes(){
        List<Joke> Jokes = new ArrayList<Joke>();
        for(Joke joke : jokeRepo.findAll()){
            Jokes.add(joke);
        }
        return Jokes;
    }
}
