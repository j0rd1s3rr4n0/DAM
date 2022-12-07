import java.util.Scanner;

public class Exercici92 {
  /*
  	• String llegirString();
  	• int comptarLletra(String paraula, char lletra); ‘ retorna el número de vegades lletra dins de
  	paraula
  */
  public String llegirString() {
    Scanner e = new Scanner(System.in);
    System.out.println("PARAULA:");
    String text = e.next();
    return text;
  }

  public int comptarLletra(String[] lletres, char lletra) {
    int[] ContadorVocals = new int[6];
    ContadorVocals[5] = -1;
    int v = 0;
    switch (lletra) {
    case 'a':
      v = 0;
      break;
    case 'e':
      v = 1;
      break;
    case 'i':
      v = 2;
      break;
    case 'o':
      v = 3;
      break;
    case 'u':
      v = 4;
      break;
    default:
      v = 5;
      break;
    }
    int vocal;
    for (String string: lletres) {
      switch (lletra) {
      case 'a':
        vocal = 0;
        if (string.equals("A")) {
          ContadorVocals[vocal] += 1;
        }
        break;

      case 'e':
        vocal = 1;
        if (string.equals("E")) {
          ContadorVocals[vocal] += 1;
        }
        break;

      case 'i':
        vocal = 2;
        if (string.equals("I")) {
          ContadorVocals[vocal] += 1;
        }
        break;

      case 'o':
        vocal = 3;
        if (string.equals("O")) {
          ContadorVocals[vocal] += 1;
        }
        break;

      case 'u':
        vocal = 4;
        if (string.equals("U")) {
          ContadorVocals[vocal] += 1;
        }
        break;

      }
    }
    return ContadorVocals[v];
  }

  public static void main(String[] args) {
    Exercici92 p = new Exercici92();

    while (true) {
      String lletres[] = p.llegirString().toUpperCase().replace(" ", ".").split("");
      Scanner e = new Scanner(System.in);
      
      char [] letraaa = {'a','e','i','o','u'};
      
      for(int ñ = 0;ñ < 5;ñ++) {
    	  System.out.println(letraaa[ñ]+" : "+p.comptarLletra(lletres, letraaa[ñ]));
      }
	}
  }
}