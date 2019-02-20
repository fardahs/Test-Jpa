package main.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("base");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// Extrait un livre en fonction de son Id
		Livre l1 = em.find(Livre.class,1);
		if (l1 != null) {
			System.out.println(l1.getId());
		}
		
		// Trouve un livre en fonction de son titre
		TypedQuery<Livre> query = em.createQuery("select livre from Livre livre where livre.titre='Germinal'", Livre.class);
		Livre livre = query.getResultList().get(0);
		System.out.println("Titre du livre : "+livre.getTitre() +"\nAuteur : " +livre.getAuteur());

			
	}
	
	

}

