import java.util.Scanner;
public class Exercici9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double m,n;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Valor 1: ");		m = input.nextInt();
		System.out.print("Valor 2: ");		n = input.nextInt();
		
		if ( ( n / 10 == ( int ) n / 10 ) && ( m / 10 == ( int ) m / 10 ) ) {
			System.out.println(Math.max((int)n,(int)m));
		}
		else {
			System.out.println("ERROR - ALGUN DELS NOMBRES INTRODUITS NO ACABA AMB ZERO");
		}
	}

}
