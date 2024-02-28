import java.util.Scanner;
public class Exercici3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Demanar un número enter que signifiqui una quantitat d’euros i digui la descomposició en bitllets
		//de 5,10,20,50 i 100.
		
		double euro,valor,conversion,restante;
		//DEFINIR VARIABLES
		Scanner input = new Scanner(System.in);
		System.out.print("Valor a Calcular Euro: ");euro = input.nextInt();
		restante = 1;
		int i = 0;
		while(restante>0) {
			/*System.out.print("Valor del billet > "); valor = input.nextInt();*/
			if (i==0) {
				valor = 5;
			}
			else if (i==1) {
				valor = 10;
			}
			else if (i==2) {
				valor = 20;
			}
			else if (i==3) {
				valor = 50;
			}
			else if (i==4) {
				valor = 100;
			}
			else {
				break;
			}
			conversion = Math.round((euro/valor)-0.5);
			restante = euro/valor - conversion;
			System.out.println((int)conversion+" Billetes de "+(int)valor+"€ | Restante: "+(int)Math.round(restante*valor-0.5)+" euro");
			i++;
		}
		
		input.close();
	}

}
