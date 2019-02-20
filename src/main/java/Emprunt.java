package main.java;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="EMPRUNT")
public class Emprunt {
	@Id
	private Integer id;
	@Column(name="DATE_DEBUT")
	private Date date_debut;
	@Column(name="DATE_FIN")
	private Date date_fin;
	@Column(name="DELAI")
	private Integer delai;
	@Column(name="ID_CLIENT")
	private Integer id_client;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	public Integer getId_client() {
		return id_client;
	}
	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}
	
	
}
