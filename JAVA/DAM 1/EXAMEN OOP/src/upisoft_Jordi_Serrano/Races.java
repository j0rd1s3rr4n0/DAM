package upisoft_Jordi_Serrano;

public class Races extends Personatge {
	private int AttacPower;
	private int nWeapons;
	
	
	
	public Races(boolean isAlliance,String name,int attacPower, int nWeapons) {
		super(isAlliance, name);
		this.setAttacPower(attacPower);
		this.setnWeapons(nWeapons);
	}


	public int getAttacPower() {
		return AttacPower;
	}


	public void setAttacPower(int attacPower) {
		AttacPower = attacPower;
	}


	public int getnWeapons() {
		return nWeapons;
	}


	public void setnWeapons(int nWeapons) {
		this.nWeapons = nWeapons;
	}

	
}
