import java.util.Scanner;
public class Exercici13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A partir d’un valor X , calcular el valor d’ aquest polinomi X^3+ 3X^2+ 7	X+7
		double x,resultat;
		Scanner e = new Scanner(System.in);
		System.out.print("Resultat d' x^3+x^2+7x+7 = ? \n Si x = ");
		x = e.nextDouble();
		resultat = (Math.pow(x,3))+(3 * Math.pow(x,2))+(7 * x) + 7;
		System.out.println("Valor si x="+x+" es : "+resultat);
		e.close();
	}

}
