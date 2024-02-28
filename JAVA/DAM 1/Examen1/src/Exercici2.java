import java.util.Scanner;
public class Exercici2 {

	public static void main(String[] args) {
		//VARIABLES
		double numU,numDos,numTres,minim,maxim,dif;
		Scanner input = new Scanner(System.in);
		
		//INPUT USUARI
		System.out.print("Num 1:");numU = input.nextDouble();
		System.out.print("Num 2:");numDos = input.nextDouble();
		System.out.print("Num 3:");numTres = input.nextDouble();
		
		// CALCULS
		if (numU != numDos && numDos != numTres && numU != numTres) {
			if(numU > numDos && numU > numTres) {
				if (numDos > numTres) {
					minim = numTres;	
				}
				else {
					minim = numDos;
				}
				maxim = numU;
			}
			else if(numU < numDos && numDos > numTres) {
				if (numU > numTres) {
					minim = numTres;	
				}
				else {
					minim = numU;
				}
				maxim = numDos;
			}
			else {
				if (numU > numDos) {
					minim = numDos;
				}
				else {
					minim = numU;
				}
				maxim = numTres;
			}
		}
		
		else {
			maxim = numU;
			minim = numU;	
		}
		
		// INPUT MENU USUARI + OUTPUT
		System.out.println("m.- Només mostrar el més gran\nt.- Mostrar el més gran i el més petit\nx.- Mostrar el més gran, el més petit i la diferència entre ells");
		char opcio = input.next().charAt(0);
		switch(opcio) {
			case 'M':;
			case 'm':System.out.println("El més gran: " + (int)maxim);break;
			case 'T':;
			case 't':System.out.println("El més gran: " + (int)maxim+"\nEl més petit: " + (int)minim);break;
			case 'X':;
			case 'x':dif=maxim-minim;System.out.println("El més gran: " + (int)maxim+"\nEl més petit: " + (int)minim+"\nDiferencia és " + (int)dif+" ("+(int)maxim+"+"+(int)minim+")");break;
		}		
	}
}
