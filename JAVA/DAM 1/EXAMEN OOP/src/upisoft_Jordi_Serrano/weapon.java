package upisoft_Jordi_Serrano;

public class weapon {
	private String nom;
	private int power;
	
	public weapon(String nom, int power) {
		this.setNom(nom);
		this.setPower(power);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	
}
