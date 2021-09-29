package exemple_suma;
// Li diem al nostre programet que farem servir una classe anomenada Scanner
// que no existeix en el conjunt basic inicial d'instuccions i per aixo cal fer
// el import. Sino el posem, quan definim Scanner el trabara a faltar! i donarà error.
import java.util.Scanner;

public class exempleENtradaSortida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		int valor1,valor2,resultat; // Podem definir diferents variables del mateix tipus en una sola linea
		String nouUsuari;
		
		System.out.print("Insereixi el seu Nom: ");
		nouUsuari=entrada.next();
		
		System.out.println("Benvingut "+nouUsuari+"!");
		
		System.out.print("Insereixi el primer valor: ");
		valor1 = entrada.nextInt();
		
		System.out.print("Insereixi el segon valor: ");
		valor2=entrada.nextInt();
		
		resultat=valor1+valor2;
		System.out.println("Resultat es: "+resultat);
		entrada.close();
		
	}

}
