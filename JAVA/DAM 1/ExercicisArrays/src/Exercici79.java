import java.util.Scanner;
// 79.Introduir una frase caràcter a caràcter en una taula. Posteriorment caldrà mostrar-la per a->e->i->o->u->a
public class Exercici79 {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		char g; int x;
		int charmax = 255;
		//while(true) {}
		char c;int longitud;
		String Text;
		while(true) {
			System.out.print("Text Original > ");
			Text = e.nextLine();
			//System.out.printf("%d\n",x);\\
			if (Text == "" || Text.length() > 255) {
				if (Text.length() > 255) {System.err.println("El text supera els 255 caracters.");}
				else if ( Text == "") {System.err.println("No es permet introduir text buit");}
			}
			else {Text = Text.toLowerCase();break;}
		}
		longitud = Text.length();
		char [] cadena = new char [longitud];
		for(int i =0;i<longitud;i++) {
			cadena[i] = Text.charAt(i);
			if (cadena[i] == 'a') {cadena[i] = 'e';}
			else if (cadena[i] == 'e') {cadena[i] = 'i';}
			else if (cadena[i] == 'i') {cadena[i] = 'o';}
			else if (cadena[i] == 'o') {cadena[i] = 'u';}
			else if (cadena[i] == 'u') {cadena[i] = 'a';}
		}
		System.out.print("Text Processat: ");	
		for(int i =0;i<longitud;i++) {
			System.out.print(cadena[i]);
		}
	}
}