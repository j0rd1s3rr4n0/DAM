//import java.util.Arrays;
import java.util.Random;

public class Exercici90 {
	
	public static void Sleep(int time) {try {Thread.sleep(time);} catch (InterruptedException e) {}}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int [] carreta = new int [10]; // VERTICAL		
		int carro = 0; // HORIZONTAL
		
		int l = 100;
		
		int [] maxim = new int [10];
		int [] minim = new int [10];
		
		int [][] taula = new int [10][10];

		for (int x = 0; x<taula.length;x++) {
			for (int y = 0; y<taula.length;y++) {
				taula[x][y] = rand.nextInt(10);
			}
			System.out.println();
		}
		for(int ñ = 0; ñ < maxim.length; ñ++) {
			minim[ñ]=taula[ñ][0];
			maxim[ñ]=taula[ñ][0];
		}
		
		for (int x = 0; x<taula.length;x++) {
			
			for (int y = 0; y<taula.length;y++) {
				int valor = taula[x][y];
				System.out.print("0"+valor+"  ");
				
				if (valor > maxim[y] ) {
					maxim[y]=valor;
					//System.out.print("Maxim: "+maxim[y]+" \\ ");
				}
				else if (valor < minim[y]){
					minim[y]=valor;
					//System.out.print("Minim: "+minim[y]+" \\ ");
					
				}
				
				
			}
			Sleep(l);
			//System.out.println(minim[x]+" "+maxim[x]);
			
			Sleep(l);
			
			
			carro = 0;
			System.out.println("\n");
		
		}
		Sleep(1);
		System.err.print("FILA X = [MAX/MIN]\n");
		for(int fila = 0; fila < maxim.length; fila++) {
			System.out.printf("FILA %d = [%d/%d]\n",(fila+1),maxim[fila],minim[fila]);
		}
	}
}


