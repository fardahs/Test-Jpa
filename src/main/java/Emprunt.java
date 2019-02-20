package main.java;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="EMPRUNT")
public class Emprunt {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="DATE_DEBUT")
	private LocalDateTime date_debut;
	
	@Column(name="DATE_FIN")
	private LocalDateTime date_fin;
	
	@Column(name="DELAI")
	private Integer delai;
	
	// Relation emprunt - client
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	// Relation emprunt - livre
	@ManyToMany
	@JoinTable(name="COMPO", 
	         joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
		      inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"))
	private List<Livre> livre;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Livre> getLivre() {
		return livre;
	}
	public void setLivre(List<Livre> livre) {
		this.livre = livre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}
	public LocalDateTime getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	
}
