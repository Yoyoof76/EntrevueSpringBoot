package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.models.ActeurModel;

@Entity
public class Acteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_id")
	private Long id;
	@Column(name = "act_nom")
	private String nom;
	@Column(name = "act_prenom")
	private String prenom;
	@ManyToOne
	@JoinColumn(name = "flm_id", nullable = false)
	private Film film;

	public Acteur(ActeurModel acteur, Film film) {
		this.id = acteur.getId();
		this.nom = acteur.getNom();
		this.prenom = acteur.getPrenom();
		this.film = film;
	}
	
	public Acteur() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
}
