package banque.entite;

import java.time.LocalDate;
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
		
		//Liste de clients
		List<Client> listClient = new ArrayList<Client>();
		//Liste de comptes
		List<Compte> listeCompte = new ArrayList<Compte>();
		
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
		client.setDateNaissance(LocalDate.of(1984, 4, 6));
		//Ajout d'un client dans la liste	
		listClient.add(client);
		
		banque.setClient(listClient);
		
		/****************Sans heritage *********************/
		/*Operation operation = new Operation();
		operation.setMontant(15487.14);
		operation.setMotif("Virement de Mr Dupont");
		operation.setDate(LocalDateTime.now());*/
		
		/*Compte compte = new Compte();
		compte.setClients(listClient);
		compte.setNumero("02598745");
		compte.setSolde(12563.14);*/

		
		/*************** TP 5 avec heritage************/
		LivretA livretA = new LivretA();
		livretA.setTaux(15.2);
		livretA.setClients(listClient);
		livretA.setSolde(587.4);
		livretA.setNumero("25487693");
		
		Virement virement = new Virement();
		virement.setBeneficiare("Jacques");
		virement.setDate(LocalDateTime.now());
		virement.setCompte(livretA);
		virement.setMontant(254.36);
		virement.setMotif("Aide 2");
		
		
		//operation.setCompte(compte);
		
		AssuranceVie assurenceVie = new AssuranceVie();
		assurenceVie.setClients(listClient);
		assurenceVie.setNumero("25487693");
		assurenceVie.setSolde(587.4);
		assurenceVie.setTaux(1.5);
		assurenceVie.setDateFin(LocalDate.now());
		
		listeCompte.add(assurenceVie);
		listeCompte.add(livretA);
		
		client.setComptes(listeCompte);
		
		//Persitence des entités
		em.persist(banque);
		//em.persist(operation);
		//em.persist(compte);
		em.persist(client);
		em.persist(livretA);
		em.persist(virement);
		em.persist(assurenceVie);
		
		et.commit();
	}

}
