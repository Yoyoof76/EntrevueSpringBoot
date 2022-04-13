package com.example.services;

import com.example.models.FilmModel;

public interface IFilmService {

	public FilmModel findById(Long id);
	public FilmModel save(FilmModel film);
}
