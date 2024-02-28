import java.util.Scanner;
public class Exercici1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);		
		
		System.out.print("OPCIONS:\n A - WHILE\n B - FOR\n C - DO-WHILE \n> ");
		char num = input.next().charAt(0);
		
		switch(num) 
		{
		case 'A': int a = 0;while(a < 25){System.out.println(a);a++;};break;
		case 'B': for(int b = 0; b < 25; b++){System.out.println(b);};break;
		case 'C': int c = 0;do {System.out.println(c);c++;}while(c < 25);break;
		default: System.out.println("No s'ha utilitzat un caracter valid");break;
		}
	}

}
