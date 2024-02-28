import java.util.Scanner;
public class Exercici71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int posicio;
		int dimensioArray = 0;
		int acumulat=0;
		double mitjana;
		int [] llistaNombres;

		Scanner e = new Scanner(System.in);
		System.out.print("Tamany de taula: ");
		dimensioArray = e.nextInt();
		llistaNombres = new int [dimensioArray];
		
		//Omplim array amb valors		
		for (posicio = 0; posicio <= (dimensioArray-1);posicio++) {
			System.out.printf("Valor de [%d] > ",posicio+1);
			llistaNombres[posicio] = e.nextInt();
			acumulat+=llistaNombres[posicio];
		}
		mitjana = acumulat/dimensioArray;
		System.out.printf("Mitjana: %.2f",mitjana);
	}

}
