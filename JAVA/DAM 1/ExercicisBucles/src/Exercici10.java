import java.util.Scanner;
public class Exercici10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m,i;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Taula del : ");m = input.nextInt();
		i = 0;
		while(11!=i){
			System.out.println(i+" x "+m+" = "+(m*i));
			i++;
		}
		
		
	}

}
