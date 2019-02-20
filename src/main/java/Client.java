package main.java;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="CLIENT")
public class Client {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;

	@OneToMany(mappedBy="client")
	private List<Emprunt> listEmprunts;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<Emprunt> getListEmprunts() {
		return listEmprunts;
	}

	public void setListEmprunts(List<Emprunt> listEmprunts) {
		this.listEmprunts = listEmprunts;
	}

}
