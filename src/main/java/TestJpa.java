package main.java;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("base");
		EntityManager em = entityManagerFactory.createEntityManager();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		// Extrait un livre en fonction de son Id
		Livre l1 = em.find(Livre.class,1);
		if (l1 != null) {
			System.out.println(l1.getId());
		}
		
		// Trouve un livre en fonction de son titre
		TypedQuery<Livre> query = em.createQuery("select livre from Livre livre where titre='Germinal'", Livre.class);
		Livre livre = query.getResultList().get(0);
		System.out.println("Titre du livre : " + livre.getTitre() + "\nAuteur : " + livre.getAuteur());
		
		// Extrait les emprunts et tous ses livres associés
		TypedQuery<Emprunt> query2 = em.createQuery("select emprunt from Emprunt emprunt", Emprunt.class);
		List<Emprunt> emprunt = query2.getResultList();
		System.out.println("*******************************************************");
		System.out.println("**********************LIVRES***************************");
		for(Emprunt e: emprunt){
			System.out.println("****************************************************");
			List<Livre> livres = e.getLivre();
			for(Livre l:livres){
				System.out.println("Le livre \"" + l.getTitre() + "\" a été emprunter le "+ e.getDate_debut().format(formatter));
			}		
		}
		
		
		//Extrait tous les emprunts des clients.	
		TypedQuery<Client> query3 = em.createQuery("select client from Client client", Client.class);
		List<Client> client = query3.getResultList();
		System.out.println("*******************************************************");
		System.out.println("*********************CLIENTS***************************");
		for(Client c:client){
			System.out.println("*******************************************************");
			List<Emprunt> emprunt2 = c.getListEmprunts();
			for(Emprunt e:emprunt2){
				System.out.println("Le client " + c.getNom() +" "+ c.getPrenom() + " a emprunté des livres le " + e.getDate_debut().format(formatter));
			}
		}
				
		
		
	}
	
	

}

