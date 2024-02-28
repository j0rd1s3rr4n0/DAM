import java.util.Scanner;
public class Exercici3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// B –Introduir un import en euros real i indicar el número mínim de bitllets i monedes que li correspon.
		//Bitllets i monedes : 500, 200, 100, 50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.01.
		//de 5,10,20,50 i 100.
		
		double euro,valor,conversion,restante;
		//DEFINIR VARIABLES
		Scanner input = new Scanner(System.in);
		System.out.print("Valor a Calcular Euro: ");euro = input.nextDouble();
		restante = 1;
		euro = (int)(euro*100);
		int i = 0;
		while(restante>0) {
			/*System.out.print("Valor del billet > "); valor = input.nextInt();*/
			if (i==0) {
				valor = 10000;
			}
			else if (i==1) {
				valor = 5000;
			}
			else if (i==2) {
				valor = 2000;
			}
			else if (i==3) {
				valor = 1000;
			}
			else if (i==4) {
				valor = 500;
			}
			else if (i==5) {
				valor = 100;
			}
			else if (i==6) {
				valor = 50;
			}
			else if (i==7) {
				valor = 20;
			}
			else if (i==8) {
				valor = 10;
			}
			else if (i==9) {
				valor = 5;
			}
			else if (i==10) {
				valor = 1;
			}
			else {
				break;
			}
			conversion = Math.round((euro/valor)-0.5);
			restante = euro/valor - conversion;
			if (i >= 6) {
				System.out.println((int)conversion+" Monedes de "+(int)(valor)+" cts d'€");
			}
			else if (i == 5) {
			System.out.println((int)conversion+" Monedas de "+(int)((valor)/100)+" €");
			}
			else if (i <= 4) {
				System.out.println((int)conversion+" Billetes de "+(int)valor/100+" €");	
			}
			euro = euro - ((double)((int)(Math.round(conversion*valor)*100))/100);
			i++;
		}
		
		input.close();
	}

}
