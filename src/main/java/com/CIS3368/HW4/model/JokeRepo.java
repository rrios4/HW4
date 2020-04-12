package com.CIS3368.HW4.model;

import org.springframework.data.repository.CrudRepository;

public interface JokeRepo extends CrudRepository<Joke, String> {
}
