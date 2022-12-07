import java.util.Scanner;

public class joc_de_la_vida {
  public static void Sleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {}
  }

  public int VivaReconeixement(int [][] t) {
	  int n_veins;
	  for (int x = 0; x < t.length; x++) {
	      for (int i = 0; i < t.length; i++) {
	    	  n_veins =  t[i-1][x-1] + t[i-1][x] + t[i-1][x+1] + t[i+1][x-1] + t[i][x-1] + t[i][x+1] + t[i+1][x] + t[i+1][x+1];
    		  //
	    	  }
	    	  
	      }
	  return 1;
  }
  
  public void VisualitzarTauler(int[][] t) {
	  int modo = 1;
	  if(modo == 1) {
	    for (int x = 0, d = 0; x < t.length; x++, d++) {
	      for (int i = 0; i < t.length; i++) {
	    	char g = '0';
	        if (x == 0) {
	          //g = '#';
	          Sleep(1);
	          //System.err.print(g + " ");
	          System.err.print(t[x][i] + " ");
	          Sleep(1);
	        } else if (i == 0) {
	          //g = '#';
	          Sleep(1);
	          //System.err.print(g + " ");
	          System.err.print(t[x][i] + " ");
	          Sleep(1);
	        } else if (i == t.length - 1) {
	          //g = '#';
	          Sleep(1);
	          //System.err.print(g + " ");
	          System.err.print(t[x][i] + " ");
	          Sleep(1);
	        } else if (x == t.length - 1) {
	          //g = '#';
	          Sleep(1);
	          //System.err.print(g + " ");
	          System.err.print(t[x][i] + " ");
	          Sleep(1);
	        } else {
	        		if(t[x][i] == 1){
	        			Sleep(1);
	                	System.err.print(t[x][i]+" ");
	                	Sleep(1);
	        		}else {
	        			System.out.print(t[x][i] + " ");
	        		}
	        }
	      }
	        System.out.print((d) + "\n");
	
	    }
	  }
	  else {
		  for (int x = 0, d = 0; x < t.length; x++, d++) {
		      for (int i = 0; i < t.length; i++) {
		    	char g = '0';
		      char o;
		        if (x == 0) {
		          g = '#';
		          Sleep(1);
		          System.err.print(g + " ");
		          // System.err.print(t[x][i] + " ");
		          Sleep(1);
		        } else if (i == 0) {
		          g = '#';
		          Sleep(1);
		          System.err.print(g + " ");
		          // System.err.print(t[x][i] + " ");
		          Sleep(1);
		        } else if (i == t.length - 1) {
		          g = '#';
		          Sleep(1);
		          System.err.print(g + " ");
		          // System.err.print(t[x][i] + " ");
		          Sleep(1);
		        } else if (x == t.length - 1) {
		          g = '#';
		          Sleep(1);
		          System.err.print(g + " ");
		          // System.err.print(t[x][i] + " ");
		          Sleep(1);
		        } else {
		        		if(t[x][i] == 1){
		        			Sleep(1);
		              o='■';
		              System.err.print(o+" ");
		              Sleep(1);
		        		}else {
		        			System.out.print(" "+" ");
		        		}
		        }
		      }
		        System.out.print((d) + "\n");

		    }
	  }
	 // IMPRIMEIX GUIA NUMEROS
    for (int y = 0,x = 0; x < t.length; x++) {
      if (x == 10) {
    	  y = 0;
      }     
      System.out.print(y + " ");
      y++;

    }
    System.out.println();
    /*
    char o;
    for ( int x = 0; x < t.length-1;x++) {
    	for ( int i = 0; i < t.length-1;i++) {
    		if(t[x][i] == 1) {
    			o='■';
    		}
    		else {
    			o = '#';
    		}
    		System.out.print(o+" ");
    	}
    	System.out.println();
    }
    */
  }

  public void CrearCelules(int[] c, int t[][]) {
    t[c[0]][c[1]] = 1;
  }

  public void BorrarCelules(int[] c, int t[][]) {
    t[c[0]][c[1]] = 0;
  }

  public int[] DemanaCoordenadesCelula(int[][] t) {
    Scanner e = new Scanner(System.in);
    char[] coordenades_Escrita = new char[2];
    int[] coordenades_INT = new int[2];
    boolean error = false;
    int l = t.length;
    int p = l-2;
    do {
    	if(error == true) {
    		Sleep(1);
    		System.err.println("El tauler de joc es de "+(t[0].length-2)+" x "+(t.length-2));
    		error = false;
    	}
      System.out.print("Eix X: ");
      coordenades_Escrita[1] = e.next().toUpperCase().charAt(0);
      if (coordenades_Escrita[1] == 'A' || coordenades_Escrita[1] == 'B') {
        if (coordenades_Escrita[1] == 'A') {
          coordenades_INT[1] = 10;
        } else {
          coordenades_INT[1] = 11;
        }
      } else {
        coordenades_INT[1] = Character.getNumericValue(coordenades_Escrita[1]);
      }
      
      //System.err.println("Valor: " + coordenades_INT[1]);

      System.out.print("Eix Y: ");
      coordenades_Escrita[0] = e.next().toUpperCase().charAt(0);
      if (coordenades_Escrita[0] == 'A' || coordenades_Escrita[0] == 'B') {
        if (coordenades_Escrita[0] == 'A') {
          coordenades_INT[0] = 10;
        } else {
          coordenades_INT[0] = 11;
        }
      } else {
        coordenades_INT[0] = Character.getNumericValue(coordenades_Escrita[0]);
      }
      
      //System.err.println("Valor: " + coordenades_INT[0]);
      error = true;
    } while (!((coordenades_INT[0] > 0) && (coordenades_INT[0] <= p) 
    		&& (coordenades_INT[1] > 0 && coordenades_INT[1] <= p)));

    return coordenades_INT;

  }
  public void CrearMapa(int[][] t) {
	  Scanner e = new Scanner(System.in);
	  // Y X
	  int MAX = 100;
	  int MIN = 10;
	  int [] dim = new int [2]; 
	  do {
		  System.out.println("DIMENSIONS DEL MAPA:");
		  System.out.print("X:\n> ");
		  dim[1] = e.nextInt();
		  System.out.print("Y:\n> ");
		  dim[0] = e.nextInt();  
		  
	  }while((dim[0] < MAX && dim[0] >= MIN) && (dim[1] < MAX && dim[1] >= MIN));
	  
	  //TODO CHANGE ARRAY OF TABLE
	  //int [][] t = new int [dim[0]][dim[1]];
	  
  }
  public void CrearCivilitzacio(int[][] t) {
    char x = '-';
    Scanner e = new Scanner(System.in);
    do {
      VisualitzarTauler(t);
      System.out.print("1.- Insertar Cell\n2.- Netejar Casella\n3.- Sortir del Menu\n> ");
      x = e.next().charAt(0);
      if (x == '1') {
        CrearCelules(DemanaCoordenadesCelula(t), t);
      } else if (x == '2') {
        System.out.println("Demana Coordenades");
        System.out.println("Borrar Casella");
        BorrarCelules(DemanaCoordenadesCelula(t), t);
      } else if (x == '-') {
        //TODO
      } else {
        x = '.';
      }

    } while (x != '.');
  }

  public void configuracio() {
    Scanner e = new Scanner(System.in);
    boolean sortir = false;
    while (!sortir) {
      System.out.println("1.- Tamany del Mapa\n2.- Parametres \n0.- Sortir\n> ");
      int sel = e.nextInt();
      switch (sel) {
      case 1:
        //TODO			CrearMapa();
        System.out.println("CREAR MAPA");
        break;
      case 2:
        System.out.println("Parametres de la Partida");
        break;
      case 3:
    	  int selmode;
    	  do {
    		  System.out.println("Mode de Visualització:\n1.- Mode Binari\n2.- Mode Visual\n> ");
        	   selmode =e.nextInt();
    	  }while(selmode != 0 ||  selmode == 1 || selmode == 2);
      case 0:
        sortir = true;
        break;
      default:
      }

    }
  }

  public static void main(String[] args) {
    joc_de_la_vida p = new joc_de_la_vida();
    int table_size = 10 + 2;
    int generacio = 0;
    int[][] TAULER = new int[table_size][table_size];
    boolean sortir = true;
    Scanner e = new Scanner(System.in);

    System.out.println("        &&&       ");
    System.out.println("       &   &      ");
    System.out.println("        &&&       ");
    System.out.println("               &&& ");
    System.out.println("              &   &");
    System.out.println("               &&& \n");
    System.out.println(" &&&    &&&    &&& ");
    System.out.println("&   &  &   &  &   &");
    System.out.println(" &&&    &&&    &&& \n");
    while (sortir) {
      System.out.print("1.- PLAY\n2.- CREAR CELL MANUAL\n3.- CREAR CELL AUTO\n5.- CONFIGURACIO\n0.- Salir\n> ");
      int menu_principal = e.nextInt();
      switch (menu_principal) {
      case 1:
        System.out.println("PLAY");
        break;
      case 2:
        p.CrearCivilitzacio(TAULER);
        break;
      case 3:
        System.out.println("CREAR CELL AUTO");
        break;
      case 5:
        System.out.println("CONFIGURAR");
        p.configuracio();
        break;
      case 0:
        sortir = false;
        break;
      default:
      }

    }

  }

}