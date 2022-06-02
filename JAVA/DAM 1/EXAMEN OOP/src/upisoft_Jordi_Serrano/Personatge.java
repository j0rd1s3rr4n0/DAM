package upisoft_Jordi_Serrano;

public abstract class Personatge {
	private boolean isAlliance;
	private String name;
	private Races race;
	
	public Personatge(boolean isAlliance, String name) {
		this.setAlliance(isAlliance);
		this.setName(name);
	}
		

	public boolean isAlliance() {
		return isAlliance;
	}
	public void setAlliance(boolean isAlliance) {
		this.isAlliance = isAlliance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Races getRace() {
		return race;
	}


	public void setRace(Races race) {
		this.race = race;
	}


	public abstract int calcAverage();
	
}
