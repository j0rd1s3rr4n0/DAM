import java.util.Scanner;
// 82.Igual que el 81 però en lloc de dir quants, caldrà mostrar tots els números dient si són més grans o més petits que la mitja

public class Exercici82 {
	public static void main(String[] args) {
		 Scanner e = new Scanner(System.in);
		 System.out.print("Numeros a Analitzar > ");
		 int n = e.nextInt();int [] taula = new int [n];int suma=0;
		 
		 // INSERIR VALORS A TAULA
		 for(int x = 0;x<n;x++) {System.out.printf("Numero %d> ",x+1);taula[x]=e.nextInt();}
		 
		 //CALCULAR MITJANA
		 for(int x=0;x<n;x++) { suma+=taula[x];}
		 System.out.printf("Mitjana: %d\n",(suma/n));
		 
		 //MOSTRAR SI SON MAJORS O MENORS
		 for(int x=0;x<n;x++) {
			 
			 if(taula[x]>(suma/n)) {System.out.printf("Numero %d es MAJOR que %d\n",taula[x],(suma/n));}
			 
			 else if(taula[x]<(suma/n)) {System.out.printf("Numero %d es MENOR que %d\n",taula[x],(suma/n));}
			 
			 else {System.out.printf("Numero %d es IGUAL que %d\n",taula[x],(suma/n));}
			 
		 }
		 
	}
}