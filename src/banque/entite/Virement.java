package banque.entite;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation{

	private String beneficiare;
	
	public String getBeneficiare() {
		return beneficiare;
	}
	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
	}
	
}
