package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
