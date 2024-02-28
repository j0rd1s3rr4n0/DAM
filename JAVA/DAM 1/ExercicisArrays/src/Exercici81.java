import java.util.Scanner;
// 81.Introduir un conjunt de N números pel teclat i guardar-los en una taula. Després caldrà calcular
// la mitja i dir quants números son més grans que la mitja i quants son més petits.

public class Exercici81 {
	public static void main(String[] args) {
		 Scanner e = new Scanner(System.in);
		 System.out.print("Numeros a Analitzar > ");
		 int n = e.nextInt();int [] taula = new int [n];int suma=0;
		 
		 // INSERIR VALORS A TAULA
		 for(int x = 0;x<n;x++) {System.out.printf("Numero %d> ",x+1);taula[x]=e.nextInt();}
		 
		 //CALCULAR MITJANA
		 for(int x=0;x<n;x++) {suma+=taula[x];}
		 System.out.printf("Mitjana: %d\n",(suma/n));
		 
		 //MES GRANS A LA MITJA 
		 int [] mayor = new int [n];
		 for(int x=0;x<n;x++) {if(taula[x]>(suma/n)){mayor[x] = taula[x];}}
		 System.out.print("Num més grans: ");
		 for(int x=0;x<n;x++) {if(mayor[x]!=0) {System.out.printf("%d,",mayor[x]);}}
		 System.out.print("\n");
		 //MES PETITS A LA MITJA 
		 int [] petit = new int [n];
		 for(int x=0;x<n;x++) {if(taula[x]<(suma/n)){petit[x] = taula[x];}}
		 System.out.print("Num més petits: ");
		 for(int x=0;x<n;x++) {if(petit[x]!=0) {System.out.printf("%d,",petit[x]);}}
		 System.out.print("\n");
	}

}
