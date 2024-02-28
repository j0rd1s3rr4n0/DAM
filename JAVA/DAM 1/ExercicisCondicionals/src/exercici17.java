import java.util.Scanner;
import java.util.Random;

public class exercici17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 	Determinar la quantitat de diners que rebrà un treballador per concepte de les hores
			extres treballades en una empresa, 
			sabent que quan les hores de treball excedeixende 40,
				
			es paguen al doble d'una hora normal
			quan no excedeixen de 8; 
			
			si les hores extres excedeixen de 8 es paguen les primeres 8 al doble del que paguen les hores normals i 
			else{
			}
			la resta al triple.
		 */
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		int quantitat,hores_treball,valor_hora;
		
		int valor1,valor2,valor3,suma_total;
		
		valor1 = 0;
		valor2 = 0;
		valor3 = 0;
		System.out.print("Hores Totals: ");
		quantitat = input.nextInt(); //hores
		
		hores_treball = 40; //jornadalaboral normal
		valor_hora = 10; // Preu/hora
		
		valor1 = valor_hora * 40;
		
		if ( quantitat > 40 ) {
			quantitat = quantitat - 40 ;

			valor2 = ( ( ( quantitat ) - ( quantitat - 8 ) )  * ( valor_hora * 2 ) ) ; // hora normal x 2
			quantitat = quantitat - 8; 

			if(quantitat > 0 ){
				valor3 = (quantitat * (valor_hora * 3));
			}
			
		}
		suma_total = valor1 + valor2 + valor3;
		
		System.out.printf("Cobrarás : %d €",suma_total);
		}
		
	}


