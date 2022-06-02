import java.util.Scanner;

public class Exercici88 {

  public static void main(String[] args) {
    boolean funcionant = true;
    Exercici88 p = new Exercici88();
    while (funcionant) {
      System.out.print("Numero: ");
      int numero = p.LlegirEnter();
      if (numero < 0) {
        System.out.println("Factorial: 0");
      } else if (numero == 0) {
        System.out.println("Fin del Programa!");
        funcionant = false;
      } else {
        System.out.print("Factorial: " + p.factorial(numero) + "\n");
      }
    }

  }

  public float factorial(int numero) {
    float resultat = numero;
    for (int i = 1; i < numero; i++) {
      resultat = resultat * (numero - i);
    }
    return numero;
  }

  public int LlegirEnter() {
    Scanner e = new Scanner(System.in);
    int numero_introduit = e.nextInt();
    return numero_introduit;

  }

}