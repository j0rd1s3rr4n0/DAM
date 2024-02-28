import java.util.Scanner;
public class Exercici24 {

	public static void main(String[] args) {
		// 64.Comptar el nombre d’enters negatius d’una sèrie d’enters que anem llegint i que finalitza amb el número zero.
		Scanner e = new Scanner(System.in);
		int num,neg;neg = 0;
		
		while(true) {
			System.out.print("NUM>");num = e.nextInt();
			if (num == 0) {System.out.println("Num Negatius: "+neg);break;}
			if ( num<0) {neg+=1;}
		}
	}
}
