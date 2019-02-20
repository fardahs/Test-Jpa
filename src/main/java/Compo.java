package main.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="COMPO")
public class Compo {
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="ID_LIV")
	private Integer id_livre;
	
	@Column(name="ID_EMP")
	private Integer id_emp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_livre() {
		return id_livre;
	}
	public void setId_livre(Integer id_livre) {
		this.id_livre = id_livre;
	}
	public Integer getId_emp() {
		return id_emp;
	}
	public void setId_emp(Integer id_emp) {
		this.id_emp = id_emp;
	}
	
	
}
