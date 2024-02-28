import java.util.Scanner;
public class Exercici14 {
	public static void main(String[] args) {
		// Visualitzar un quadrat de N asteriscs, sent N un valor entrat per teclat. Exemple per N= 5
		Scanner e = new Scanner(System.in);
		System.out.print("N= ");int n = e.nextInt();
		int x = n;
		int o = n;
		while (x>=1) {
			while(n>=1) {
				System.out.print("* ");
				if (n<=1) {
					System.out.print("\n");
				}
				n--;
			}
			n=o;
			x--;
		}
		e.close();	
	}
}