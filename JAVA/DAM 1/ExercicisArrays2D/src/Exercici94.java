import java.util.Scanner;

public class Exercici94 {
	public static void Sleep(int time) {try {Thread.sleep(time);} catch (InterruptedException e) {}}
	
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int [][] Taula = new int [10][10];

		
		// CREA LA TAULA AMB '_'
		for(int x = 0,i=0;x<Taula.length;x++) {
			for(int y = 0; y < Taula.length;y++) {
				if(i == 10) {
				}
				Taula[y][x] = i;
				i++;
			}
		}
		
		while(true) {
				
			// MOSTRA JA LA MATRIU
				for(int y = 0,i=0;y<Taula.length;y++) {
					for(int x = 0; x < Taula.length;x++) {
						if(Taula[x][y]<1) {
							Sleep(1);
							System.err.print("0"+Taula[x][y]+" ");
							Sleep(1);
						}
						else if (Taula[x][y]<10) {
							System.out.print("0"+Taula[x][y]+" ");
						}
						else {
							System.out.print(Taula[x][y]+" ");
						}
					i++;
				}
				System.out.println("");
			}
			Sleep(1);
			System.err.println("\n_\n");
			Sleep(1);
			
			/**********************************************************/
			System.out.print("ELIMINAR\nY: ");
			int del_y = e.nextInt();
			System.out.print("X: ");
			int del_x = e.nextInt();
			if (del_y > 10) {del_y = 9;}else if (del_y < 1) {del_y=0;}
			if (del_x > 10) {del_x = 9;}else if (del_x < 1) {del_x=0;}
			System.out.println("S'ha seleccionat la casella X=["+del_x+"],Y=["+del_y+"]");
			if(del_y == 0 && del_x == 0) {break;}
			del_y--;
			del_x--;
			Taula[del_x][del_y] = -1;
			System.out.println("");
			
			/**********************************************************/
			
		
		
			// PROCES DE DESPLAÇARA A L'ESQUERRA
			if(del_x< 10) {
				for(int x = del_x;x<Taula.length-1;x++) {
					Taula[x][del_y] = Taula[x+1][del_y];
				}
				Taula[Taula.length-1][del_y] = 0;
				
			}
			
			
			
			/*
		94.Introduir números en una matriu de 10x10 de enters. Després l’usuari anirà indicant fila i
		columna i el que s’haurà de fer es eliminar el contingut de la casella indicada però
		arrossegant cap a l’esquerra totes les caselles següents. Finalitzarem quan l’usuari indiqui la
		coordenada 0,0 i mostrarem el contingut de la matriu al finalitzar l’algoritme
			 */
			
		
		}
	}	
}
	