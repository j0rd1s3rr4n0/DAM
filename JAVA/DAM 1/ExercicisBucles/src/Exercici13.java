import java.util.Scanner;
public class Exercici13 {

	public static void main(String[] args) {
		// Calcular el factorial d’ un nombre demanat per teclat. Exemple: 5! = 5*4*3*2*1
		Scanner e = new Scanner(System.in);
		System.out.print("> ");
		int x = e.nextInt();
		String Cadena = "";
		double temp = 1;
		e.close();
		String s=String.valueOf(x);
		System.out.print(s+"! = ");
		for(int i=x; i>0;i--){
			temp = temp * i;
			if (i >=2) {
				Cadena=String.valueOf(i);
				Cadena = Cadena+" · ";
				System.out.print(Cadena);	
			}
			else{
				Cadena=String.valueOf(i);
				Cadena = Cadena+" = ";
				System.out.print(Cadena);	
			}
		}
		System.out.println(temp); // CALCULOS
	}

}
