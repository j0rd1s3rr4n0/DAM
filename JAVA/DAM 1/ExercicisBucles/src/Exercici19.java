import java.util.Scanner;
public class Exercici19 {

	public static void main(String[] args) {
		// Fer un programa per entrar (caràcter a caràcter) un text (no buit) del que hem de dir el número de A’s que hi
		// ha. El text s’ acaba quan s’entri un intro.
		
		String a;
		int i = 0;
		Scanner e = new Scanner(System.in);
		System.out.println("Text:");
		while(true) {
			a = e.nextLine();
			if (a ==""){
				System.out.printf("S'ha repetit 'A' i/o 'a' %d vegades",i);
				break;
			}
			else {
				char s = a.charAt(0);
				if (s=='a' || s=='A') {
					i++;
				}
			}
		}
	}
}
