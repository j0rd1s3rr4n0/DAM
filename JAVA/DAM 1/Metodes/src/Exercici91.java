import java.util.Scanner;

public class Exercici91 {
	/*
		• String llegirString();
		• int comptarA(String paraula);
	*/
	public String llegirString() {
		Scanner e = new Scanner(System.in);
		String text = e.next();
		return text;
	}
	
	public int comptarA () {
		int ContadorA = 0;
		System.out.println("TEXT:");
		String a [] = llegirString().split("");
		for (String string : a) {
			if(string == "a" || string == "A") {
				ContadorA+=1;
			}
		}
		return ContadorA;
	}
	
	public static void main(String[] args) {
		Exercici91 p = new Exercici91();
		System.out.println(p.comptarA());
	}

}
