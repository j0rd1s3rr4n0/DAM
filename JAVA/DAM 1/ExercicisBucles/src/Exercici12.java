import java.util.Scanner;
public class Exercici12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Visualitzar els N primers nombres imparells positius, sent N un valor entrat per teclat
		int n,g;
		Scanner input = new Scanner(System.in);
		System.out.print("N: ");n=(input.nextInt());
		g =1;
		while(n!=0) {
			System.out.println("NUM "+((n+1)-n)+" :"+g);
			n--;g+=2;
		}
			
	}

}
