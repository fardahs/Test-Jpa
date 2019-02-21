package banque.entite;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Adresse adresse = new Adresse();
		adresse.setCodePostal(35000);
		adresse.setNumero(15);
		adresse.setRue("Marécharl Dupont");
		adresse.setVille("Rennes");
		
		Banque banque = new Banque();
		banque.setNom("BNP");
			
		Client client = new Client();
		client.setNom("Jean");
		client.setPrenom("Pierre");
		client.setBanque(banque);
		client.setAdresse(adresse);
		
		List<Client> listClient = new ArrayList<Client>();
		listClient.add(client);
		
		banque.setClient(listClient);
		
		Operation operation = new Operation();
		operation.setMontant(15487.14);
		operation.setMotif("Virement de Mr Dupont");
		operation.setDate(LocalDateTime.now());
		
		Compte compte = new Compte();
		compte.setClients(listClient);
		compte.setNumero("02598745");
		compte.setSolde(12563.14);
		
		operation.setCompte(compte);
		
		em.persist(banque);
		em.persist(operation);
		em.persist(compte);
		em.persist(client);
		
		et.commit();
	}

}
