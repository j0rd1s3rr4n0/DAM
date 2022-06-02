package upisoft_Jordi_Serrano;

public class Human extends Races{
	private boolean inteligenica;
	
	public Human(boolean isAlliance,String name,int attacPower, int nWeapons,boolean inteligenica) {
		super(isAlliance,name,attacPower, nWeapons);
		this.setInteligenica(inteligenica);
	}
	
	public boolean isInteligenica() {
		return inteligenica;
	}

	public void setInteligenica(boolean inteligenica) {
		this.inteligenica = inteligenica;
	}


	@Override
	public int calcAverage() {
		// Humans:
		//En cas de tenir intel·ligencia:
		for(int x = 0; x < weapon.size();x++) {
			int mAttacPowerGeneral = weapon.get(x);
		}
		
		if(this.isInteligenica() == true) {
			int average = (mAttack * 1,33) + (mAttackPowerGeneral) / weapon.size();
		}else {
			int average = mAttack + ( mAttackPowerGeneral / weapon.size());
		}
		return average;
	}
	 
	

}
