//import java.util.Arrays;
import java.util.Random;

public class Exercici88 {
	
	public static void main(String[] args) {
		Random rand = new Random();	
		int suma = 0; 
		int [][] taula = new int [10][10];

		for (int x = 0; x<taula.length;x++) {
			for (int y = 0; y<taula.length;y++) {
				taula[x][y] = rand.nextInt(10);
			}
			System.out.println();
		}
		
		
		for (int x = 0; x<taula.length;x++) {
			
			for (int y = 0; y<taula.length;y++) {
				
				System.out.print(taula[x][y]+" ");
				
				suma+=taula[x][y];
			}
			System.out.println("");
		}
		System.out.println("RESULTAT = "+suma);
			
		
		}
	}
