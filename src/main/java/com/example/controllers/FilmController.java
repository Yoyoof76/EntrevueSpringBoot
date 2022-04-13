package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.FilmModel;
import com.example.services.IFilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {
	
	@Autowired
	private IFilmService filmService;
	
	@GetMapping("/{id}")
	public ResponseEntity<FilmModel> getById(@PathVariable("id") Long id) {
		FilmModel film = filmService.findById(id);
		HttpStatus status = film.getId() == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<FilmModel>(film, status);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FilmModel> create(@RequestBody FilmModel film) {
		film = filmService.save(film);
		HttpStatus status = film == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED;
		return new ResponseEntity<FilmModel>(film, status);
	}
}
