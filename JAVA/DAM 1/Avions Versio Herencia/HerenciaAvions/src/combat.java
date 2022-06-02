import java.util.Iterator;
import java.util.Scanner;

public class combat extends avio {
	private boolean [] misils; 
	private int [] objectiu; // {x , y};
	private boolean encriptat;
	Scanner e = new Scanner(System.in);
	public combat(String matricula, String marca, String model, String origen, String desti, Coordenada coordenades, int tripulants,int objectiu[],boolean[] misils,boolean encript) {
		super(matricula, marca, model, origen, desti, coordenades, tripulants);
		this.setMisils(misils);
		this.encriptat = encript;
	}

	public boolean[] getMisils() {
		return misils;
	}

	public void setMisils(boolean[] misils) {
		this.misils = misils;
	}

	public int[] getObjectiu() {
		return objectiu;
	}
	
	public int comptarMisils() {
		int contador = 0;
		boolean misils[] = getMisils();
		for(int i = 0; i< misils.length;i++) {
			if(misils[i] == false) {contador++;}
		}return contador;
	}
	
	public void setObjectiu(int[] objectiu) {
		this.objectiu = objectiu;
	}
	
	public int[] disparara() {
		System.out.println("COORDENADES A DISPARAR:");
		this.setObjectiu(new int[] {nextNum(e, "X"),nextNum(e, "Y")});
		System.out.println("\n [ Llençant misil A la posicio X: "+getObjectiu()[0]+" Y: "+getObjectiu()[1]+" ] \n".toUpperCase());
		return getObjectiu();
	}
	
	int nextNum(Scanner e, String ms) {
		System.out.print(ms+": ");
		return e.nextInt();
	}
	
	int contMisil(){
		int i = 0;
		boolean misils [] = this.getMisils();
		for(int x = 0; x < misils.length; x++) {if(misils[x]==false) {i+=1;}}
		return i;
	}
	
	public boolean isEncriptat() {
		return encriptat;
	}

	public void setEncriptat(boolean encriptat) {
		this.encriptat = encriptat;
	}

	public void info() {
		System.out.println("-======================= AVIO DE COMBAT =======================-");
		super.info();
		System.out.println("-==============================================================-");
		
	}
	@Override
	boolean askcombat() {return true;}
}
