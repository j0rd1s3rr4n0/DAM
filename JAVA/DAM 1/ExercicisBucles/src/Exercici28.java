import java.util.Scanner;
public class Exercici28 {

	public static void main(String[] args) {
		/*
			69. Fer un programa per entrar (caràcter a caràcter) un text (no buit) acabat pel caràcter ‘/’. El caràcter ‘*’
			significa final de línia. Entre les diferents paraules podrà haver-hi més d’ una espai en blanc o bé un asterisc. El
			programa haurà d’ escriure el número de línies, el número de paraules i el de caràcters diferents de ‘ ‘, ‘*’, ‘/’
			que hi ha en el text.
			Exemple: LA CASA ESTAVA* MOLT MACA* PERÒ AVUI JA*NO TANT *//*
			Caràcters 36 Paraules 10 Línies 4
		*/
		Scanner e = new Scanner(System.in);
		int caracters = 0;
		int paraules = 0;
		int linea = 0;
		char simbols = ' ';
		
		
		while(simbols!='/') {
			
			System.out.print("Caracter > ");String Text = e.nextLine();
			if (Text == "") {
				System.err.println("No es permet introduir text buit");
				System.out.print("Caracter > ");
				Text = e.nextLine();
			}
			simbols = Text.charAt(0);
			
			
			if ( simbols ==' ') {
				paraules++;
			}
			else if ( simbols =='*') {
				linea++;
				paraules++;
			}
			else if (simbols !='/') {
				caracters ++;
			}
		}
		System.out.printf("INFORMACIO DELS PARAMETRES INTRODUITS:\nCARACTERS: %d\nLINIES:%d\nPARAULES: %d",caracters,linea,paraules);
	}
}
