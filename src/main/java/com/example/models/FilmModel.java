package com.example.models;

import java.util.List;
import java.util.stream.Collectors;

import com.example.entities.Film;

public class FilmModel {

	private Long id;
	private String titre;
	private String description;
	private List<ActeurModel> acteurs;

	public FilmModel(Film film) {
		this.id = film.getId();
		this.titre = film.getTitre();
		this.description = film.getDescription();
		this.acteurs = film.getActeurs()
				.stream()
				.map(acteur -> new ActeurModel(acteur))
				.collect(Collectors.toList());
	}
	
	public FilmModel() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ActeurModel> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<ActeurModel> acteurs) {
		this.acteurs = acteurs;
	}
}
