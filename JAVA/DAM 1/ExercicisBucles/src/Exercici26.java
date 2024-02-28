import java.util.Scanner;

public class Exercici26 {

	//66. Escriure els divisors d’un número enter llegit per teclat.
	public static void main(String[] args) {
		Scanner ewg = new Scanner(System.in);
		System.out.print("Numero > ");
		int numero = ewg.nextInt(); 
	    System.out.print("Divisors >");
		for(int i = 1 ; i <=numero ; i++){
	        if(numero%i==0){
	            System.out.printf(" %d",i);
	        }
	    }
		ewg.close();
	}

}
