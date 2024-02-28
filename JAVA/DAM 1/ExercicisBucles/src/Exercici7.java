import java.util.Scanner;
public class Exercici7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double valor1,valor2;
		Scanner input = new Scanner(System.in);
		System.out.print("VALOR 1: ");valor1 = input.nextDouble();
		System.out.print("VALOR 2: ");valor2 = input.nextDouble();
		valor1 /=10;
		valor2 /=10;
		if ( valor1/10== (int)valor1/10)
		{	
			System.out.println("RESULTAT de "+((int)valor1*10)+" + "+((int)valor2*10)+" = "+((int)valor1*10+(int)valor2*10));
		}
		else {
			System.out.println("El valor no acaba amb zero");	
		}
	}

}
