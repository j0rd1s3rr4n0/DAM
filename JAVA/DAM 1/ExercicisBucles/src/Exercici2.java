import java.util.Scanner;
public class Exercici2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i;
		Scanner input = new Scanner(System.in);
		System.out.print("Inserta un valor a n:\n n=");
		n = input.nextInt();
		i = 0;
		while(n>=i) {
			System.out.println(i+" --> "+i*2);
			i++;
		}
	}

}
