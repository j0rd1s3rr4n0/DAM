package upisoft_Jordi_Serrano;

public class Elf extends Races{
	private double magia;

	
	public Elf(boolean isAlliance,String name,int attacPower, int nWeapons, double magia) {
		super(isAlliance,name,attacPower, nWeapons);
		this.setMagia(magia);
	}

	public double getMagia() {
		return magia;
	}

	public void setMagia(double magia) {
		this.magia = magia;
	}

	@Override
	public int calcAverage() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
