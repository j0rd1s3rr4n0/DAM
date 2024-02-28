import java.util.Scanner;
public class Exercici14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner e = new Scanner(System.in);
		
		char a;
		System.out.print("Caracter: ");
		a = e.next().charAt(0);
		
		int ascii=a;
		
		System.out.println(ascii);
		
		if ( 64 < a && a < 91 ) {
			System.out.println("Caracter: "+a+" Esta en Mayusculas.");
		}
		else if ( 96 < a && a < 123 ) {
			System.out.println("Caracter: "+a+" Esta en Minusculas.");
		}
		else {
			System.out.println("ERROR. No se inserto ningun caracter A-z\nValor insertado: "+a);
		}
		e.close();
	}
	
}
