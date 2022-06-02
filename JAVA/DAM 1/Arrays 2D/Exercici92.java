import java.util.Random;
public class Exercici92 {
	
	public static void Sleep(int time) {try {Thread.sleep(time);} catch (InterruptedException e) {}}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		int [][] taula = new int [10][10];
		int [][] matriu = new int [10][10];
		int [][] suma = new int [10][10];

		Sleep(1);
		System.err.println("Taula:");
		Sleep(1);
		for (int y = 0; y<taula.length;y++) {
			for (int x = 0; x<taula.length;x++) {
				taula[x][y] = rand.nextInt(10);
				System.out.print("0"+taula[x][y]+"  ");
			}
			System.out.println("\n");
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
				System.err.print("0"+matriu[x][y]+"  ");
				Sleep(1);
			}
			System.out.println("\n");
		}
		
		System.out.println("\nSUMA: ");
		for (int y = 0; y<taula.length;y++) {
			for (int x = 0; x<taula.length;x++) {
				suma[x][y] = (taula[x][y]+matriu[x][y]);
				
				Sleep(1);
				if (suma[x][y] > 9) {
					System.out.print(suma[x][y]+"  ");
				}
				else {
					System.out.print("0"+suma[x][y]+"  ");
				}
				Sleep(1);
			}
			System.out.println("\n");
		}
		

	}

}
