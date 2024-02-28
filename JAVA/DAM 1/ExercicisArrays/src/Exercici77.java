import java.util.Scanner;
public class Exercici77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner e = new Scanner(System.in);
		int [] temperatures = {10,11,21,23,27,31,40,-1,7,19};
		int n = temperatures.length;
		int mid = 0;int i=0;int tempSupMid=0;
		
		for(int x=0;x<n;x++) {
			mid +=temperatures[x];
			i = x;
		}
		mid = mid/i;
		for(int x=0;x<n;x++) {
			if(temperatures[x]<=mid) {
				tempSupMid+=1;
			}
		}
		System.out.printf("Temperatura Mitjana: %d\nNº Temperatures Superiors o igual a la mitja %d",mid,tempSupMid);
	}

}
