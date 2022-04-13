package com.example.entities;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.util.CollectionUtils;

import com.example.models.FilmModel;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flm_id")
	private Long id;
	@Column(name = "flm_titre")
	private String titre;
	@Column(name = "flm_description")
	private String description;
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	private List<Acteur> acteurs;
	
	public Film(FilmModel filmModel) {
		this.id = filmModel.getId();
		this.titre = filmModel.getTitre();
		this.description = filmModel.getDescription();
		if(!CollectionUtils.isEmpty(filmModel.getActeurs())) {
			this.acteurs = filmModel.getActeurs()
					.stream()
					.map(acteurModel -> new Acteur(acteurModel, this))
					.collect(Collectors.toList());
		}
	}
	
	public Film() {}

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

	public void setDescriptions(String description) {
		this.description = description;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}
}
