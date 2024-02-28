import java.util.Scanner;
public class Exercici3 {

	public static void main(String[] args) {
		// VARIABLES
		int numU,numDos,NumTres,numQuatre,ResultatSuperior;
		Scanner q = new Scanner(System.in);
		String ResultatEqual, plurCon;
		boolean Plural = false;
		
		ResultatEqual = "";
		ResultatSuperior = 0;
		System.out.print("Num 1: ");numU = q.nextInt();
		System.out.print("Num 2: ");numDos = q.nextInt();
		System.out.print("Num 3: ");NumTres = q.nextInt();
		System.out.print("Num 4: ");numQuatre = q.nextInt();
		plurCon = " i ";
		
		
		//VALORS IGUALS
		if (numDos == numU) {
			if (ResultatEqual.length()!=0) {ResultatEqual = ResultatEqual+plurCon+"Segon";Plural = true;}
			else {ResultatEqual = "Segon";}	
		}
		if (NumTres == numU) {
			if (ResultatEqual.length()!=0) {ResultatEqual = ResultatEqual+plurCon+"Tercer";Plural = true;}
			else {ResultatEqual = "Tercer";}
		}
		if (numQuatre == numU) {
			if (ResultatEqual.length()!=0) {ResultatEqual = ResultatEqual+plurCon+"Quart";Plural = true;}
			else {ResultatEqual = "Quart";}
		}
		
		if (ResultatEqual.length() == 0) {System.out.println("NO ES REPETEIX");}
		else if (ResultatEqual.length() > 0) {
			if (Plural == true) {System.out.println("El "+ResultatEqual+" son iguals al primer.");}
			else {System.out.println("El "+ResultatEqual+" és igual al primer.");}
		}
		// VALORS MES GRANS
		if (numDos > numU) {
			ResultatSuperior +=1;	
		}
		if (NumTres > numU) {
			ResultatSuperior +=1;
		}
		if (numQuatre > numU) {
			ResultatSuperior +=1;
		}
		if (ResultatSuperior>=2) {Plural = true;}
		if (ResultatSuperior == 0) {System.out.println("NO HI HA CAP MES GRAN");}
		else if (ResultatSuperior > 0) {
			if (Plural == true) {System.out.println("Hi ha "+ResultatSuperior+" més grans que el primer.");}
			else {System.out.println("Hi ha "+ResultatSuperior+" més gran que el primer.");}
		}
		

	}

}
