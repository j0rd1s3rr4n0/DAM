import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercici83 {
	public static void main(String[] args) {
	Scanner e = new Scanner(System.in);
	/* 83.Donada una taula de N posicions anar demanant a l‟usuari un conjunt de
	 * números enters. Cada vegada que s‟introdueixi un número el programa haurà
	 * de dir si aquest número ja l‟havia introduït i quantes vegades l‟ha
	 * introduït en total.
	*/
	System.out.print("Numero de Digits diferents> ");
	int n = e.nextInt();
	
	int [] contador = new int[n];
	int [] introduit = new int[n];
			
			
	if (n >= 2) {
		int i = 0;
		int i_Num = 1;
		int num;
		while(i<n) {
			//System.out.println(i); 
			System.out.printf("Introdueix un numero %d : ",i+1);num = e.nextInt();
			introduit[i]=num;
			
			
			for(int x = 0; x<n; x++) {
				
			}
			i++;	
		}
		
	}
	else {System.err.print("¡NO SE REPITE!");}
	}

}