import java.util.Scanner;

public class Exercici11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Introduir dos número n i m i fer la taula del 1 al n del número m
		int m,i,n;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Taula del numero: ");	m = input.nextInt();
		System.out.print("Fins el numero :"); 	n = input.nextInt();
		
		i = 0;
		while(n+1!=i){
			System.out.println(i+" x "+n+" = "+(m*i));
			i++;
		}
		
		
	}

}
