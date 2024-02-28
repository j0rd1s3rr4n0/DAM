import java.util.Scanner;

public class Exercici23 {

	public static void main(String[] args) {
		/*  63. Compteu el número de vegades que surten els dos primers caràcters consecutivament, la introducció de lletra
			finalitza amb el punt ‘.’, per exemple, si la frase comença amb HOLA QUE ASE, caldrà comptar HO */
				Scanner e = new Scanner(System.in);
				String Texto = "";
				int n = 0;
				int beforeChar = 0;
				int i = 0;
				char g;
				System.out.println("==========================================\n                 T E X T\n==========================================\n");
				while(true) {
					Texto += Texto+e.nextLine();
					if(Texto.charAt(Texto.length()-1) == '.') {
						Texto = Texto.replace("\n", "");
						break;
					}
				}
				char firstChar = Texto.charAt(0);
				char SecondChar = Texto.charAt(1);
				
				while(true) { 
					g = Texto.charAt(n);
					
					//System.out.println("BEFCHAR: "+beforeChar);
					//System.out.println("CHAR: "+g);
					if (( beforeChar == firstChar)&&(g == SecondChar)) {
						i++;
					}
					//EOW
					if (n == Texto.length()-1) {
						break;
					}
					beforeChar = g;
					n++;
				}
				System.out.printf("\n==========================================\n%s%s = %d",firstChar,SecondChar,i);
				}}