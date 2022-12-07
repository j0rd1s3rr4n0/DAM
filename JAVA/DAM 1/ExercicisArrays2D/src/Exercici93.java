import java.util.Scanner;

public class Exercici93 {
	
	public static void Sleep(int time) {try {Thread.sleep(time);} catch (InterruptedException e) {}}
	
	public static void main(String[] args) {
		
		Scanner e = new Scanner(System.in);
		boolean bonintent = true;
		int X=0,Y=X;
		char new_valor;
		char [][] Taula = new char [10][10];
		
		while(bonintent == true) {
			for( int y = 0; y < Taula.length; y++) {
				for( int x = 0; x < Taula.length; x++) {
					if(Taula[x][y] == 0) {
						System.out.print("_  ");
					}
					else {
						System.out.print(Taula[x][y]+" ");
					}
				}
				System.out.println("");
			}
			System.out.println("COORDENADAS: ");
			try {
				System.out.print("X: "); X = e.nextInt()-1;
				System.out.print("Y: "); Y = e.nextInt()-1;
				
				if (X > 9) {X = 9;}else if (X < 2) {X=0;}
				if (Y > 9) {Y = 9;}else if (Y < 2) {Y=0;}
				
				if (X < Taula.length && X > -1) {
					if (Y < Taula.length && Y > -1) {
						bonintent = true; 
					}
				}
			} catch(Exception e2){
				//bonintent = false;
				break;
			}		
			
				Sleep(1);
				System.err.print("\n"+Taula[X][Y]+"\n\n");
				Sleep(1);
				System.out.println("Coordenadas seleccionadas: "+(X+1)+" "+(Y+1));
				System.out.print("\nNou Valor: "); new_valor = e.next().charAt(0);
			if(Taula[X][Y]==0) {
				Taula[X][Y] = new_valor;
			}
			else {
				Sleep(1);
				System.err.println("AQUI JA HAS INTRODUIT UN VALOR!!!");
				Sleep(1);
			}
		}
		
		Sleep(1);
		System.err.println("FIN INTRODUCCIO DE DADES!");
		Sleep(1);
		System.err.println("[  V A L O R   T A B L A    | X ]");
		Sleep(1);
		for( int y = 0, suma = 0; y < Taula.length; y++) {
			for( int x = 0; x < Taula.length; x++) {
				if(Taula[x][y] == 0) {
					System.out.print("_  ");
				}
				else {
					suma+=1;
					System.out.print("   ");
				}
			}
			Sleep(1);
			System.err.println(suma);
			suma=0;
			Sleep(1);
		}
		
		
	}

}
