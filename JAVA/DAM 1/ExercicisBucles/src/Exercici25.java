import java.util.Scanner;
public class Exercici25 {
	
	public static void main(String[] args) {
		// 64.Comptar el nombre d’enters negatius d’una sèrie d’enters que anem llegint i que finalitza amb el número zero.
		
		Scanner e = new Scanner(System.in);
		
		int num;
		int sum = 0; 
		int i = 0;
		
		while(true) {
			System.out.printf("NUM %d> ",i+1);num = e.nextInt();
			
			if ( num > 0) {
				sum+=num;
				i++;
			}
		
			if (num == 0) {
				System.out.println("Num: "+sum);
				break;
			}
		}
		System.out.print("Resultat: "+(sum/i));
	}
}