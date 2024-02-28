
import java.util.Scanner;
public class Exercici6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double m,n,i,tempM,result;
		Scanner input = new Scanner(System.in);
		System.out.print("Numero Dades: ");
		n = input.nextInt();
		i=1;
		tempM = 0;
		while ( i <= n ) {
			System.out.print("Element "+(int)i+"> ");
			m = input.nextInt();
			if (m >=0 && m <= 10) {
				tempM = tempM + m;
				System.out.println(tempM);
				i++;
			}
			else {
				System.out.println("El Valor ha d'estar entre el 0 i el 10.");
			}
		}
		result = (tempM / n);
		if (tempM == 0) {
			System.out.println("NO es pot DIVIDIR entre ZERO o NEGATIUS");	
		}
		else{
			System.out.println("Mitjana Aritmetica: "+result);
		}
	}

}
