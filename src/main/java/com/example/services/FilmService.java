package com.example.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Film;
import com.example.models.FilmModel;
import com.example.repositories.FilmRepository;

@Service
@Transactional
public class FilmService implements IFilmService {
	
	@Autowired
	private FilmRepository filmRepository;

	@Override
	public FilmModel findById(Long id) {
		Optional<Film> optFilm = filmRepository.findById(id);
		if(optFilm.isPresent()) {
			return new FilmModel(optFilm.get());
		}
		return new FilmModel();
	}

	@Override
	public FilmModel save(FilmModel film) {
		Film entityFilm = new Film(film);
		try {
			entityFilm = filmRepository.save(entityFilm);
			film = new FilmModel(entityFilm);
		} catch(IllegalArgumentException e) {
			return null;
		}
		return film;
	}

}
