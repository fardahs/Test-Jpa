package main.java;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name="livre") 
public class Livre{
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="TITRE")
	private String titre;
	
	@Column(name="AUTEUR")
	private String auteur;
	
	// Relation livre - emprunts
	@ManyToMany(mappedBy="livre")
	private List<Emprunt> emprunts;
	
	// Getters et Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

}
