import java.util.Scanner;
public class Exercici09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Fer un algorisme que serveixi tant per calcular l��rea d�un rectangle com el per�metre d�un
		 * rectangle. Se li demanar� a l�usuari el valor dels dos costats i quina operaci� vol realitzar
		 * (A�rea i P-per�metre) mostrant el resultat segons l�opci� indicada per l�usuari.
		 */
		char opc;
		String entrada;
		double b,h,area,perim;
		Scanner write = new Scanner(System.in);
		System.out.print("Que vol calcular?\n[A]- Area o [P]- per�metre)\n > ");
		entrada = write.next();
		if (entrada.length()==1) {
			opc = entrada.charAt(0);
			
			System.out.print("Base: ");
			b = write.nextDouble();
			System.out.print("Altura: ");
			h = write.nextDouble();
			
			if(opc == 'a' || opc == 'A') {
				// area = b * h;
				area = b * h;
				System.out.println("Area = "+area);
			}
			else if(opc == 'p' || opc == 'P') {
				// perim = b*2 + h*2;
				perim = b*2 + h*2;
				System.out.println("Perimetre = "+perim);
			}
			else {
				System.out.println("No s\'ha sel�lecionat cap opci�.");
			}
		}
		
	}

}
