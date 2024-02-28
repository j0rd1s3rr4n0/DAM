import java.util.Scanner;
public class Exercici1 {

	public static void main(String[] args) {

		//VARIABLES
		Scanner input = new Scanner(System.in);
		final double Pi = 3.1415;
		double costat,Radi,AreaQuadrat,PerimQuadrat,AreaCercle,PerimCercle;
		
		// INPUT USUARI
		System.out.print("Costat d'un quadrat: ");costat = input.nextDouble();
		System.out.print("Radi d'un cercle: ");Radi = input.nextDouble();
		
		//CALCULS
		AreaQuadrat = Math.pow(costat,2);
		PerimQuadrat = 4 * costat;
		AreaCercle = Pi * Math.pow(Radi, 2);
		PerimCercle = 2 * Pi * Radi;
		
		//OUTPUT RESULTATS
		System.out.println("QUADRAT\n_______\nÀrea del quadrat: "+AreaQuadrat+"\nPerímetre del quadrat: "+PerimQuadrat);
		System.out.println("CERCLE\n______\nÀrea del cercle: "+AreaQuadrat+"\nPerímetre dek cercle: "+PerimQuadrat);
		
	}

}
