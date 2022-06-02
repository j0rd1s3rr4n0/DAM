import java.util.Scanner;

public class joc_de_la_vida {
  public static void Sleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {}
  }

  public void Jugar(int[][] t, int[][] new_t, int[] parametres, int g) {
    Scanner e = new Scanner(System.in);
    if(parametres[3]>4) {
    	String nextgen;

        do {
          nextgen = "";
          System.out.println("GENERACIO: " + g);
          Sleep(1);
          VisualitzarTauler(t, parametres);
          Sleep(1);
          for (int x = 1; x < parametres[1] - 1; x++) {
            for (int y = 1; y < parametres[2] - 1; y++) {
              VivaReconeixement(t, new_t, x, y, parametres);
            }
          }

          // t = new_t; => enlace
          for (int x = 0; x < parametres[1]; x++) {
            for (int y = 0; y < parametres[2]; y++) {
              t[x][y] = new_t[x][y];
            }
          }

          new_t = new int[parametres[1]][parametres[2]];
          System.out.print("PRESIONA ENTER PER PASAR DE GENERACIÓ\nESCRIU CUALSEVOL COSA PER A FINALITZAR LA SIMULACIO > ");
          nextgen = e.nextLine();
          if (nextgen.length() == 0) {
            Sleep(1);
            System.err.println("NextGen()");
            Sleep(1);
          } else {
            Sleep(1);
            System.err.println("TORNANT A MENU, RESTABLINT GENERACIONS A 0");
            Sleep(1);
          }
          g += 1;

          //System.out.println(nextgen.length());  
        }
        while (nextgen.length() == 0);
    }else {
    	Sleep(2);
    	System.err.println("Necesites tindre almenys 5 cel·lules vives!");
    	Sleep(5);
    }

  }
  public void VivaReconeixement(int[][] t, int[][] new_t, int x, int i, int[] parametres) {
    // tauler[][],nou_tauler[][],posicio_x,posicio_y
    int n_veins;

    n_veins = t[i - 1][x - 1] + t[i - 1][x] + t[i - 1][x + 1] + t[i + 1][x - 1] + t[i][x - 1] + t[i][x + 1] + t[i + 1][x] + t[i + 1][x + 1];
    String reglas = "";
    String min = "";
    String max = "";
    reglas += parametres[5];
    min += reglas.charAt(0);
    max += reglas.charAt(1);
    int vida_min = Integer.parseInt(min);
    int vida_max = Integer.parseInt(max);

    switch (t[i][x]) {
    case 1:
      if (n_veins == (vida_min) || n_veins == vida_max) {
        new_t[i][x] = 1;
      } else {
        new_t[i][x] = 0;
      }
      break;

    case 0:
      if (n_veins == parametres[6]) {
        new_t[i][x] = 1;
      }
      break;
    }
  }

  public void VisualitzarTauler(int[][] t, int[] parametres) {
    if (parametres[0] == 0) {
      for (int x = 0, d = 0; x < parametres[1]; x++, d++) {
        for (int i = 0; i < parametres[2]; i++) {
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
          } else if (x == parametres[1] - 1) {
            //g = '#';
            Sleep(1);
            //System.err.print(g + " ");
            System.err.print(t[x][i] + " ");
            Sleep(1);
          } else {
            if (t[x][i] == 1) {
              Sleep(1);
              System.err.print(t[x][i] + " ");
              Sleep(1);
            } else {
              System.out.print(t[x][i] + " ");
            }
          }
        }
        if (d == 10) {
          d = 0;
        }
        System.out.print((d) + "\n");

      }
    } else if (parametres[0] == 1) {
      for (int x = 0, d = 0; x < parametres[1]; x++, d++) {
        for (int i = 0; i < parametres[2]; i++) {
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
          } else if (i == parametres[1] - 1) {
            g = '#';
            Sleep(1);
            System.err.print(g + " ");
            // System.err.print(t[x][i] + " ");
            Sleep(1);
          } else if (x == parametres[2] - 1) {
            g = '#';
            Sleep(1);
            System.err.print(g + " ");
            // System.err.print(t[x][i] + " ");
            Sleep(1);
          } else {
            if (t[x][i] == 1) {
              Sleep(1);
              o = '■';
              System.err.print(o + " ");
              Sleep(1);
            } else {
              System.out.print(" " + " ");
            }
          }
        }
        if (d == 10) {
          d = 0;
        }
        System.out.print((d) + "\n");

      }
    } else {
      System.out.println("ABCD");
    }
    // IMPRIMEIX GUIA NUMEROS
    for (int y = 0, x = 0; x < parametres[1]; x++) {
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

  public void CrearCelulesManual(int[] c, int t[][], int[]parametres) {
	
    t[c[0]][c[1]] = 1;
    parametres[3]+=1;
  }

  public void CrearCelulaAuto(int[][] taula, int[]parametres) {
	  Scanner e = new Scanner(System.in);
	  System.out.print("\nQuantes colonies vols generar?\n >");
		int colonies = e.nextInt();
		int correcte = 0;
		while(correcte < colonies) {
			int x = (int) ((Math.random()) * (taula[0].length-1) + 1);
			int y = (int) ((Math.random()) * (taula.length-1) + 1);
			if((x > 0 && y > 0) && (x < parametres[2]-1 && y < parametres[1])) {
				taula[y][x] = 1;
				correcte+=1;
			}
			for(int q = 0; q < parametres[1]-1; q++) {
				for(int w = 0; w < parametres[2]-1;w++) {
					if(taula[q][w] == 1) {
						for(int i = -1; i < 2;i++) {
							int c = 0;
							for(int b = -1; b < 2 && c == 0; b++) {
								if((x+i) == parametres[2] || (y+b) == parametres[1]) {
								}else {
									if(!(i==0 && b == 0)) {
										if(!(taula[q+i][w+b] == 1)) {
												taula[q+i][w+b] = 2; 
												parametres[3]+=1;
										}
									}else {
										
										if(0.5 >= (Math.random() * (1 - 0) + 0)) {
											taula[q+i][w+b] = 2; 
											parametres[3]+=1;
										 }else {
											 taula[q+i][w+b] = 0;
										 } 
									}
								}
							}
						}			
					}
				}
			}
		}
		for(int h=0;h<=parametres[1]-1;h++) {
			for(int k=0;k<=parametres[2]-1;k++) {
				if(taula[h][k] == 2) {
					taula[h][k] = 1;
				}
			}
		}

  }
  public void BorrarCelules(int[] c, int t[][],int [] parametres) {
    t[c[0]][c[1]] = 0;
    parametres[3]-=1;
  }

  public int[] DemanaCoordenadesCelula(int[][] t) {
    Scanner e = new Scanner(System.in);
    String[] coordenades_Escrita = new String[2];
    int[] coordenades_INT = new int[2];
    boolean error = false;
    int l = t.length;
    int p = l - 1;
    do {
      if (error == true) {
        Sleep(1);
        System.err.println("El tauler de joc es de " + (t[0].length - 2) + " x " + (t.length - 2));
        error = false;
      }
      System.out.print("Eix X: ");
      coordenades_Escrita[1] = e.next().toUpperCase();
      coordenades_INT[1] = Integer.parseInt(coordenades_Escrita[1]);

      //System.err.println("Valor: " + coordenades_INT[1]);

      System.out.print("Eix Y: ");
      coordenades_Escrita[0] = e.next().toUpperCase();
      coordenades_INT[0] = Integer.parseInt(coordenades_Escrita[0]);

      //System.err.println("Valor: " + coordenades_INT[0]);
      error = true;
    } while (!((coordenades_INT[0] > 0) && (coordenades_INT[0] <= p) &&
        (coordenades_INT[1] > 0 && coordenades_INT[1] <= p)));

    return coordenades_INT;

  }
  public void CrearMapa(int[][] t) {
    Scanner e = new Scanner(System.in);
    // Y X
    int MAX = 100;
    int MIN = 10;
    int[] dim = new int[2];
    do {
      System.out.println("\nDIMENSIONS DEL MAPA:");
      System.out.print("X:\n> ");
      dim[1] = e.nextInt();
      System.out.print("Y:\n> ");
      dim[0] = e.nextInt();

    } while ((dim[0] < MAX && dim[0] >= MIN) && (dim[1] < MAX && dim[1] >= MIN));

    //TODO CHANGE ARRAY OF TABLE
    //int [][] t = new int [dim[0]][dim[1]];

  }
  public void CrearCivilitzacio(int[][] t, int[] parametres) {
    char x = '-';
    Scanner e = new Scanner(System.in);
    do {
      VisualitzarTauler(t, parametres);
      System.out.print("1.- Insertar Cell\n2.- Netejar Casella\n3.- Borrar Tauler\n4.- Sortir del Menu\n> ");
      x = e.next().charAt(0);
      if (x == '1') {
        CrearCelulesManual(DemanaCoordenadesCelula(t), t,parametres);
      } else if (x == '2') {
        BorrarCelules(DemanaCoordenadesCelula(t), t,parametres);
      } else if (x == '3') {
        for (int j = 0; j < t.length; j++) {
          for (int i = 0; i < t.length; i++) {
            t[j][i] = 0;
          }
        }parametres[3]=0;
      } else if (x == '4') {
        x = '.';
      } else {
        System.out.println("ERROR - OPCION NO VALIDA");
      }
    } while (x != '.');
  }
  public int[][] NovaTaula(int[][] t) {
    int x = 0;
    int y = 0;
    Scanner e = new Scanner(System.in);
    do {
      System.out.println("NOVES DIMENSIONS DE LA TAULA\nX > ");
      y = e.nextInt();
    } while (x < 5);
    do {
      System.out.println("Y > ");
      y = e.nextInt();

    } while (y < 5);
    if (x + y > 100) { // SUMA 
      System.err.println("LES DIMENSIONS DE LA TAULA HAN DE SER SUPERIOR A 5x5 I INFERIORS A 50x50");
    }

    int[][] Tauleta = new int[x][y];
    return Tauleta;
  }
  public int[][] retornarray(int nova_y, int nova_x, int[][] taula) {
    int nova_taula[][] = new int[nova_y][nova_x]; // AQUI CREO EL CLON DE LA TABLA
    int x_minima = Math.min(nova_x, taula[0].length);
    int y_minima = Math.min(nova_y, taula.length);
    for (int i = 0; i < y_minima; i++) { // Y
      for (int j = 0; j < x_minima; j++) { // X
        nova_taula[i][j] = taula[i][j];
      }
    }
    taula = new int[nova_taula.length][nova_taula[0].length];
    for (int i = 0; i < taula.length; i++) {
      for (int b = 0; b < taula[0].length; b++) {
        taula[i][b] = nova_taula[i][b];
      }
    }
    return taula;
  }
  public void MirarCelules(int []parametres,int [][] taula) {
	  parametres[3]=0;
	    for(int y = 0; y < parametres[1];y++) {
	    	for(int x = 0; x < parametres[2];x++) {
	    		if(taula[y][x] == 1) {
	    			parametres[3]+=1;
	    		}
	    	}
	    }
  }
  public void configuracio(int[] parametres, String[] titleParametres, int[][] taula) {
    Scanner e = new Scanner(System.in);
    MirarCelules(parametres,taula);
    boolean sortir = false;
    while (!sortir) {
      System.out.print("\n1.- Visualitzar Parametres\n2.- Tamany del Mapa\n3.- Mode Visual\n4.- Modificar Reglas\n0.- Sortir\n> ");
      int sel = e.nextInt();
      switch (sel) {
      case 2:
        System.out.println("\nMODIFICAR MAPA");
        //System.out.println("Aquesta fase esta en desenvolupament");
        /**/
        int nova_y = 0;
        int nova_x = 0;
        do {
          System.out.print("Y > "); // PIDO Y > 4
          nova_y = e.nextInt();
        } while (nova_y < 5);
        do {
          System.out.print("X > "); // PIDO X > 4
          nova_x = e.nextInt();
        } while (nova_x < 5);
        parametres[1] = nova_y + 2;
        parametres[2] = nova_x + 2;
        /**/
        break;
      case 1:
        System.out.println("\nPARAMETRES DE LA PARTIDA");
        // [ INT | STRING | BOOLEAN ]
        for (int x = 0; x < parametres.length; x++) {
          String r = "";
          if (x == 0) {
            if (parametres[x] == 0) {
              r = "Uns i Zeros";
            } else {
              r = "Espais y Quadrats";
            }
          } else if (x == 1 || x == 2) {
            r += (parametres[x] - 2);
          } else {
            r += parametres[x];
          }
          System.out.println(titleParametres[x] + " : " + r);
        }
        break;
      case 3:
        do {
          System.out.println("Mode de Visualització:\n1.- Mode Binari\n2.- Mode Visual\n0.- Cancelar\n> ");
          parametres[0] = e.nextInt();
        } while (!(parametres[0] != 1 || parametres[0] != 2 || parametres[0] != 0));
        switch (parametres[0]) {
        case 1:
          parametres[0] = 0;
          break;

        case 2:
          parametres[0] = 1;
          break;
        }
        sortir = true;
        break;
      case 4:
        System.out.println("Noves Regles: (default: 23/3");
        String regles ="";
        String renaix ="";
        boolean[] ok = new boolean[3];
        for (boolean b: ok) {
          b = true;
        }
          try {
            System.out.print("Minim Vivencia: ");
            String r1 = e.next();
            System.out.print("Maxim Vivencia: ");
            String r2 = e.next();
            ok[0] = true;
            regles = r1 + r2;
            try {
              System.out.print("Cel·lules per Renaixement: ");
              String r3 = e.next();
              ok[1] = true;
              renaix += r3;
            } catch (Exception g) {
              ok[0] = false;
              System.err.println("Nomes parametres numerics!");
            }
          } catch (Exception g) {
            ok[0] = false;
            System.err.println("Nomes parametres numerics!");
          }
          System.out.print("Les regles noves seran "+regles+"/"+renaix+". Vols Continuar? S/n \n> ");
          char validar = e.next().toLowerCase().charAt(0);
          if(validar == 's') {
        	  parametres[5] = Integer.parseInt(regles);
        	  parametres[6] = Integer.parseInt(renaix);
        	  break;
          }else {
        	  Sleep(1);
        	  System.err.println("Cancel·lant canvis.");
        	  Sleep(1);
          }
      case 0:
        sortir = true;
        break;

      }

    }
  }

  public static void main(String[] args) {
    joc_de_la_vida p = new joc_de_la_vida();
    int table_size_y = 10 + 2;
    int table_size_x = 10 + 2;
    String[] TitleParametres = {
      "Mode Visual",
      "Altura del Mapa",
      "Grosor del Mapa",
      "Celulas Creadas",
      "Generacions",
      "Condicions de Supervivencia",
      "Condicions Renaixement"
    };
    int[] parametres = new int[7]; // Modo, Altura , Anchura, creades, generacions, Condicions Convivencia , Condicions Reencarnació
    parametres[0] = 1; //Modo
    parametres[1] = table_size_y; // Altura
    parametres[2] = table_size_x; // Anchura
    parametres[3] = 0; // Celules Creades
    parametres[4] = 0; // Generacions
    parametres[5] = 23; // Condicions de Vivencia this.charAt(0) | this.charAt(1)
    parametres[6] = 3; // Condicions Reencarnacio

    int generacio = 0;
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
    /*
    System.out.print("CREACIO DE MAPA:\nVols Editar el Mapa? (Default: 10x10)\n 1.-Si\n 2.-No \n> ");
    char editar = e.next().charAt(0);
	int salir = 0;
    while(salir == 0) {
    
    	switch(editar){
	    	case '1': 
	    		do {
	    			System.out.print("Y > "); 
	    			table_size_y = e.nextInt();
	    		}while(!(table_size_y > 4 && table_size_y < 50));
	    		do {
	    			System.out.print("X > "); 
	    			table_size_x = e.nextInt();
	    		}while(!(table_size_x > 4 && table_size_x < 50));
	    		parametres[1]=table_size_y;
	    		parametres[2]=table_size_x;
	    		salir = 1;
	    		break;
	    	case '2': salir = 1;break;
	    	default: System.out.println("Seleciona un Valor Valid!");
	    }
    }*/

    int[][] TAULER = new int[table_size_y][table_size_x];
    int[][] nou_tauler = new int[table_size_y][table_size_x];

    while (sortir) {
      TAULER = p.retornarray(parametres[1], parametres[2], TAULER); // AQUESTA PART L'UTILITZO PER CREAR UN 
      p.VisualitzarTauler(TAULER, parametres);
      System.out.print("1.- PLAY\n2.- CREAR CELL MANUAL\n3.- CREAR CELL AUTO\n5.- CONFIGURACIO\n0.- SALIR\n> ");
      int menu_principal = e.nextInt();
      switch (menu_principal) {
      case 1:
        System.out.println();
        p.MirarCelules(parametres,TAULER);
        p.Jugar(TAULER, nou_tauler, parametres, generacio);
        System.out.println();
        break;
      case 2:
        p.CrearCivilitzacio(TAULER, parametres);
        break;
      case 3:
    	  p.CrearCelulaAuto(TAULER, parametres);
        System.out.println("\nCREAR CELL AUTO"); // DIVIDIR EN 9 QUDRANTS I DEFINIR ALEATORIAMENT 0 o 1 anar fent un for, no pasa res si es solapai
        break;
      case 5:
        System.out.print("\nCONFIGURAR");
        p.configuracio(parametres, TitleParametres, TAULER);
        break;
      case 0:
        sortir = false;
        e.close();
        break;
      default:
      }

    }

  }

}