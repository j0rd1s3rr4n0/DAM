package upisoft_Jordi_Serrano;

public class Orc extends Races{
 private int tenacitat;

 
public Orc(boolean isAlliance,String name,int attacPower, int nWeapons,int tenacitat) {
	super(isAlliance,name,attacPower, nWeapons);
	this.setTenacitat(tenacitat);
}

public int getTenacitat() {
	return tenacitat;
}

public void setTenacitat(int tenacitat) {
	this.tenacitat = tenacitat;
}

@Override
public int calcAverage() {
	// TODO Auto-generated method stub
	return 0;
}
 
 
 
}
