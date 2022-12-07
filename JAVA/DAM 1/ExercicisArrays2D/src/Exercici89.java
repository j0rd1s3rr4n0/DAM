//import java.util.Arrays;
import java.util.Random;

public class Exercici89 {
	
	public static void main(String[] args) {
		Random rand = new Random();
		int [] carreta = new int [10]; // VERTICAL		
		int carro = 0; // HORIZONTAL
		int l = 100;
		int [][] taula = new int [10][10];

		for (int x = 0; x<taula.length;x++) {
			for (int y = 0; y<taula.length;y++) {
				taula[x][y] = rand.nextInt(10);
			}
			System.out.println();
		}
		
		
		for (int x = 0; x<taula.length;x++) {
			
			for (int y = 0; y<taula.length;y++) {
				
				System.out.print("0"+taula[x][y]+"  ");
				
				carreta[y] +=  taula[x][y];
				carro+=taula[x][y];
			}
			try {
				Thread.sleep(l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.print(carro);
			try {
				Thread.sleep(l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			carro = 0;
			System.out.println("\n");
		
		}
		for (int k = 0; k<carreta.length;k++) {
			try {
				Thread.sleep(l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.print(carreta[k]+"  ");
			try {
				Thread.sleep(l);
			} catch (InterruptedException e) {
				
		}
		
		}
		System.out.print("XX");
		
	}
}
