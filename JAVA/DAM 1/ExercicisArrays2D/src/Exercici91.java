import java.util.Random;
public class Exercici91 {
	
	public static void Sleep(int time) {try {Thread.sleep(time);} catch (InterruptedException e) {}}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		int [][] taula = new int [10][10];
		int [][] matriu = new int [10][10];

		Sleep(1);
		System.err.println("Taula:");
		Sleep(1);
		for (int y = 0; y<taula.length;y++) {
			for (int x = 0; x<taula.length;x++) {
				taula[x][y] = rand.nextInt(10);
				System.out.print(taula[x][y]+" ");
			}
			System.out.println();
		}
		
		
		for (int y = 0; y < taula.length;y++) {
			for( int x = 0; x < taula.length; x++) {
				matriu[y][x] = taula[x][y];
			}
		}
		
		System.out.println("\nMatriu:");
		
		for (int y = 0; y<taula.length;y++) {
			for (int x = 0; x<taula.length;x++) {
				Sleep(1);
				System.err.print(matriu[x][y]+" ");
				Sleep(1);
			}
			System.out.println();
		}
		

	}

}
