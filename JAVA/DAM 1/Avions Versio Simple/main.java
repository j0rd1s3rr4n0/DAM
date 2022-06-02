import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
/*
 Falten les Validacions de que no es pugui sortir del mapa
 ( condicionals de si estan a la ultima
 casella negui o si estan a la primera, si estan al terra i
 ve del cel s'estrella i es destrueix l'avio.)
 
 
 */
public class main {
        public int randInt(int min, int max) {
                Random rand = new Random();
                int random_num = min + rand.nextInt((max - min) + 1);
                return random_num;
        }
        public void mostrarAvioRandom(String[] a) {
                int random = randInt(0, 2);
                try {
                        System.out.println(a[random]);
                } catch (Exception e) {
                        random = (int) Math.round(Math.random());
                        System.out.println(a[random]);
                }
        }
        public void buildMap(avio avions[], int[][] mapa) {
                for (int i = mapa.length - 1; i >= 0; i--) {
                        for (int h = 0; h < mapa[0].length; h++) {
                                System.out.print(mapa[i][h] + " ");
                        }
                        System.out.println();
                }
                System.out.println("Llegenda\n 1 ) Avio 1\n 5 ) Avio 2\n 7 ) Avio 3\n");
        }
        
        public void crearAvio(int [][] mapa, avio [] avions,String[]m_id,int [] pts) {
                Scanner e = new Scanner(System.in);
                String [] info = comptarAvions(mapa,pts).split(",");
                //System.out.println(info[3]);
                int a = Integer.valueOf(info[3]);
                switch(a){
                case 0:
                	mapa[0][0] += pts[0];
                	
                	break;
                case 1:
                	mapa[0][0] += pts[1];
                	break;
                case 2:
                	mapa[0][0] += pts[2];
                	break;
                case 3:
                	System.out.println("Es necesari Aterrar o Derribar un Avio");
                	break;
                }
                if(a < 3 && a >= 0) {
                	boolean un_uso = false;
                    for (int i = 0; i < (m_id.length) && un_uso == false ; i++) {
                    	if(m_id[i].equals("undefined")){
                    		String mat = genMatricula();
                    		avions[i].setMatricula(mat);
                    		m_id[i] = avions[i].getMatricula();
                    		un_uso = true;
                    	}
    				}
                }
                
        }
        
        
        
        public String comptarAvions(int[][] TAULER,int[]pts) {
                int contador = 0;
                String parseinfo = "x,y,z,c"; 
                for (int i = 0; i < TAULER.length; i++) {
                        for (int x = 0; x < TAULER[0].length; x++) {
                                if (TAULER[i][x] != 0) {
                                        switch (TAULER[i][x]) {
                                        case 1:
                                                parseinfo = parseinfo.replace('x', '1');
                                        break;
                                        case 5:
                                        		parseinfo = parseinfo.replace('y', '1');
                                        break;
                                        case 7:
                                                parseinfo = parseinfo.replace('z', '1');
                                        break;
                                        case 6:
                                        	 	parseinfo = parseinfo.replace('x', '1');
                                        	 	parseinfo = parseinfo.replace('y', '1');
                                	 	break;
                                        case 8: 
                                        		parseinfo = parseinfo.replace('x', '1');
                                        		parseinfo = parseinfo.replace('z', '1');
                                		break;
                                        case 12: 
                                        		parseinfo = parseinfo.replace('y', '1');
                                        		parseinfo = parseinfo.replace('z', '1');
                                		break;
                                        case 13:
                                        	 parseinfo = parseinfo.replace('x', '1');
                                             parseinfo = parseinfo.replace('y', '1');
                                             parseinfo = parseinfo.replace('z', '1');
                                        break;
                                        }
                                }
                        }
                }
                int a,b,c = 0;
                String [] temp = parseinfo.split(",");
                try {
        			a = Integer.valueOf(temp[0]);
        		}catch (Exception e) {a = 0;}
        		
        		try {
        			b = Integer.valueOf(temp[1]);	
        		}catch (Exception e) {b = 0;}
        		
        		try {
        			c = Integer.valueOf(temp[2]);	
        		}catch (Exception e) {c = 0;}
        		
                contador = a+b+c;
                String f = String.valueOf(contador);
                parseinfo = parseinfo.replace('c', f.charAt(0));
                //System.out.println(parseinfo);

                return parseinfo;

        }
        public void rescatarAvio(int x) {
                int rescate = (int) Math.round(Math.random());
                String op = "";
                if (rescate == 0) {
                        op = "rescata tots els passatgers";
                } else {
                        op = "no hi han supervivents";
                }
                System.out.printf("L'equip de rescat va a al km %d, i %s.\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n", x, op);
        }
        public String genMatricula() {
                String matricula = "";
                String[] letras = "abcdefghijklmnopqrstuvwxyz".toUpperCase().split("");
                // GENERA 4 NUMEROS
                for (int n = 0; n < 4; n++) {
                        matricula += String.valueOf(randInt(0, 9));
                }
                // GENERA 3 LETRAS 
                for (int l = 0; l < 3; l++) {
                        matricula += String.valueOf(letras[randInt(0, 25)]);
                }
                return matricula;
        }
        public void manejoPos(avio [] avions,int []pts,int [][] mapa, int id_avio) {
        	Scanner e = new Scanner(System.in);	
    		System.out.print("\nMODIFICAR POSICIO\n 1 ) Avançar\n 2 ) Retrocedir\n 3 ) Sortir\n [> ");
    		int temp = e.nextInt();
    		if(temp == 1) {
				mapa[avions[id_avio].getAlçada()][avions[id_avio].getPosicio_X()] -= pts[id_avio];
				avions[id_avio].modificarPos(0); // Visualment com he modificat l'adal i el abaix ...
				mapa[avions[id_avio].getAlçada()][avions[id_avio].getPosicio_X()] += pts[id_avio];
			}else if( temp == 2) {
				mapa[avions[id_avio].getAlçada()][avions[id_avio].getPosicio_X()] -= pts[id_avio];
				avions[id_avio].modificarPos(1); //
				mapa[avions[id_avio].getAlçada()][avions[id_avio].getPosicio_X()] += pts[id_avio];
			}
        	// 1 delante // 0 atras
        }
    	public void manejoAlt(avio [] avions,int[] pts,int [][] mapa, int id_avio) {
            Scanner e = new Scanner(System.in);	
            System.out.print("\nMODIFICAR ALÇADA\n 1 ) Adal\n 2 ) Avaix\n 3 ) Sortir\n [> ");
    		int temp = e.nextInt();
			if(temp == 1) {
				mapa[avions[id_avio].getAlçada()][avions[id_avio].getPosicio_X()] -= pts[id_avio];
				avions[id_avio].modificarAlt(true);
				mapa[avions[id_avio].getAlçada()][avions[id_avio].getPosicio_X()] += pts[id_avio];
			}else if( temp == 2) {
				mapa[avions[id_avio].getAlçada()][avions[id_avio].getPosicio_X()] -= pts[id_avio];
				avions[id_avio].modificarAlt(false);
				mapa[avions[id_avio].getAlçada()][avions[id_avio].getPosicio_X()] += pts[id_avio];
			}
    		// false abajo // true arriba
        }
        public static void main(String[] args) {
                int contadorAvions = 0;
                boolean jugando = true;
                Scanner e = new Scanner(System.in);
                main p = new main();
                int[][] mapa = new int[10][10];
                /*for(int i = 0; i < mapa.length; i++){
                	for( int h = 0; h < mapa[0].length; h++) {
                	mapa[i][h] = 9;	
                	}
                }*/
                String [] m_id = new String [3];
                int [] pts = {1,5,7};
                for(int i = 0; i < m_id.length;i++) {m_id[i] = "undefined";}
                int n_avions = 3;
                avio[] avions = new avio[n_avions];  
                for (int i = 0; i < 3; i++) {
	                //(String matricula,String Autonomia,String Alçada,String Capacitat_de_carrega,String Posicio_X)
	                //String mat = p.genMatricula();
	                avions[i] = new avio("undefined", 100, 0, 20, 0);
        		}

                // Aqui funciona
                /*
                avions[0].setMatricula("aswd");
                m_id[0]  = avions[0].getMatricula();
                System.out.println(avions[0].getMatricula());
                */
                
                /*
                for (int i = 0; i < 3; i++) {
                //(String matricula,String Autonomia,String Alçada,String Capacitat_de_carrega,String Posicio_X)
                String mat = p.genMatricula();
                avions[i] = new Avions(mat, 100, 0, 20, 0);
        }
        */
        
        /*
        boolean un_uso = false;
        for (int i = 0; i < m_id.length || un_uso == true ; i++) {
        	if(m_id == null){
        		String mat = p.genMatricula();
                avions[i] = new Avions(mat, 100, 0, 20, 0);
        		 m_id[i] = avions[i].getMatricula();
        		 un_uso = true;
        	}
		}
		*/
                String[] AvionsAscii = {
                        "            ______\n            _\\ _~-\\___\n    =  = ==(____AA____D\n                \\_____\\___________________,-~~~~~~~`-.._\n                /     o O o o o o O O o o o o o o O o  |\\_\n                `~-.__        ___..----..                  )\n                      `---~~\\___________/------------`````\n                      =  ===(_________D\n",
                        "\n  ______\n  L,.   ',\n   \\      ',_\n    \\   @   ',\n     \\ ^~^    ',\n      \\    NR   ',\n       \\___'98fw  ',_                          _..----.._\n       [______       \"'==.I\\_____________..--\"<__\\\\_n@___4\\,_\n     ,..-=T         __   ____________          \\/  \"'\" O<==  \"\"-+.._\n     I____|_____    }_>=========I>=**\"\"''==-------------==-   \" |   \"'-.,___\n     [_____,.--'\"             _______         \"\"--=<\"\"-----=====+==--''\"\"\n     \"\"'-=+..,,__,-----,_____|       |         -=* |\n                 |__   /     |---,--'\"---+------+-'\"\n                    \"\"\"     d\"b=\"        '-----+t\n                            q_p                '@",
                        "\n                           ------\n                           | | # \\                                      |\n                           | ____ \\_________|----^\"|\"\"\"\"\"|\"\\___________ |\n                            \\___\\   FO + 94 >>    `\"\"\"\"\"\"\"\"     =====  \"|D\n                                  ^^-------____--\"\"\"\"\"\"\"\"\"\"+\"\"--_  __--\"|\n                                              `\"\"|\"-->####)+---|`\"\"     |\n                                                            \\  \\\n                                                           <- O -)\n                                                             `\"'"
                };
                System.out.println("\n           _      _____                         _____                      \n     /\\   (_)    / ____|                       / ____|                     \n    /  \\   _ _ _| (___  _ __   __ _  ___ ___  | |  __  __ _ _ __ ___   ___ \n   / /\\ \\ | | '__\\___ \\| '_ \\ / _` |/ __/ _ \\ | | |_ |/ _` | '_ ` _ \\ / _ \\\n  / ____ \\| | |  ____) | |_) | (_| | (_|  __/ | |__| | (_| | | | | | |  __/\n /_/    \\_\\_|_| |_____/| .__/ \\__,_|\\___\\___|  \\_____|\\__,_|_| |_| |_|\\___|\n                       | |                                                 \n                       |_|                                                 ");
                do {
                        p.buildMap(avions, mapa);
                        System.out.print("\n( 0 ) Crear Avio\n( 1 ) Controlar Avio\n( 2 ) Eliminar Avio\n( 3 ) Rescate\n( 4 ) Previsio del Cel\n( 5 ) Finalitzar Servei\n[> ");
                        int a = e.nextInt();
                        switch (a) {
                        case 0:
                                System.out.println("\n                                               _\n                 ___                          (_)\n               _/XXX\\\n_             /XXXXXX\\_                                    __\nX\\__    __   /X XXXX XX\\                          _       /XX\\__      ___\n    \\__/  \\_/__       \\ \\                       _/X\\__   /XX XXX\\____/XXX\\\n  \\  ___   \\/  \\_      \\ \\               __   _/      \\_/  _/  -   __  -  \\\n ___/   \\__/   \\ \\__     \\\\__           /  \\_//  _ _ \\  \\     __  /  \\____/\n/  __    \\  /     \\ \\_   _//_\\___    __/    //           \\___/  \\/     __/\n__/_______\\________\\__\\_/________\\__/_/____/_____________/_______\\____/____\n                                  ___\n                                 /L|0\\\n                                /  |  \\\n                               /       \\\n                              /    |    \\\n                             /           \\\n                            /  __  | __   \\\n                           /  __/    \\__   \\\n                          /  /__   |  __\\   \\\n                         /___________________\\\n                         /          |         \\\n                              /   _|_   \\\n                      /      ____/___\\____     \\\n                      ___________[o0o]___________\n                               O   O    O");
                                p.crearAvio(mapa,avions,m_id,pts);
                                break;
                        case 1:
                                String [] T = p.comptarAvions(mapa, pts).split(",");
                                if(Integer.valueOf(T[3])!=0) {
                                	p.mostrarAvioRandom(AvionsAscii);
                                	
                                	String[] info = p.comptarAvions(mapa,pts).split(",");
                                	int count_avions = Integer.valueOf(info[3]);
                                	if (count_avions == 1) {
                                		 int id = 0;
                                		 for (int j = 0; j < 3; j++) {
                                             try {
                                                int temp = Integer.valueOf(info[j]);
                                                id = j;
                                                j = 4;
                                             } catch (Exception e1) {}
                                		 }
                                		 System.out.printf("Quin Avio voleu controlar:\n 1) %s\n 4) Cancelar\n[> ", m_id[id]);
                                	} else if (count_avions == 2) {
                                        int [] id = new int[2];
                                        for (int j = 0; j < info.length - 2 || id[1]==0; j++) {
                                        	try {
                                        		if(id[0]!=0) {
                                        			int temp = Integer.valueOf(info[j]);
                                        			id[0] = j;
                                        		}else {
                                        			int temp = Integer.valueOf(info[j]);
                                        			id[1] = j;
                                        		}
                                        	} catch (Exception e1) {}
                                        }
                                        System.out.printf("Quin Avio voleu controlar:\n 1) %s\n 2) %s\n 4) Cancelar\n[> ",m_id[id[0]],m_id[id[1]]);
                                	} else if (count_avions == 3) {
                                		System.out.printf("Quin Avio voleu controlar:\n 1) %s\n 2) %s\n 3) %s\n 4) Cancelar\n[> ",avions[0].getMatricula(),avions[1].getMatricula(),avions[2].getMatricula());
                                	} else {
                                		System.out.println("Necesitas Crear Un Avio Abans De controlar-lo");
                                	}
                                	int ctl_avio = 4;
									if(count_avions != 0) {
									        int opt = 0;
									        switch(count_avions) {
									                case 1:
									                        do{
									                                opt = e.nextInt();
									                        }while(!(opt==1 || opt == 4));
									                        if(opt == 1) {
									                        	int n_avio = 2;
									                        	if(info[0].equals("1")) {n_avio = 0;}
									                        	else if(info[1].equals("1")) {n_avio = 1;}
									                        	ctl_avio = n_avio+1;
									                        }else {
									                        	ctl_avio = 4;
									                        }
									                break;
									                case 2:
									                        int [] ordenado = new int [2]; // { 1-3 } ;
									                        do{opt = e.nextInt();
									                        }while(!((opt>0 && opt<3) || opt == 4));
															if(opt != 4) {
										                        switch(info[0]) {case "1": ordenado[0] = 1;break;}                                       
										                        if(ordenado[0]==0) {                                                                     
										                                switch(info[1]) {case "1": ordenado[0] = 2;ordenado[1] = 3;break;}               
										                        }else {                                                                                  
										                                switch(info[1]) {case "1": ordenado[1] = 2;break;default: ordenado[1] = 3;break;}
										                        }
										                        ctl_avio = ordenado[(opt-1)];
															}else {
									                        	ctl_avio = 4;
									                        }
									                break;
									                case 3:
									                        do{
									                                opt = e.nextInt();
									                        }while(!(opt>0 && opt<5));
									                        if(opt!=4) {
									                        	ctl_avio = opt;
									                        }else {
									                        	ctl_avio = 4;
									                        }
									                        
									                break;
									            }
									}

                                	
                                	if(ctl_avio > 0 && ctl_avio < 4) {
                                		ctl_avio-=1;
                                		p.mostrarAvioRandom(AvionsAscii);
                                        int option = 0;
                                        do {
                                            System.out.printf("\n============================================================================\n       			    CONTROL DEL AVIO %s\n============================================================================\n   ( 1 ) Variar Posicio\n   ( 2 ) Variar Alçada\n\n   ( 4 ) Sortir\n============================================================================\n[>",avions[ctl_avio].getMatricula().toUpperCase()); 
                                            option = e.nextInt();
                                        }while(!((option == 1)||(option == 2)||(option == 4)));
                                        if(option==1) {
                                        	p.manejoPos(avions, pts,mapa,ctl_avio);
                                        	// manejo pos	
                                        }else if(option == 2) {
                                            p.manejoAlt(avions, pts,mapa,ctl_avio);
                                        	// manejo alt                                	
                                        }
                                	}else {
                                		System.out.println("Sortint ...");
                                	}
                                	
                                }
                                else {
                                	System.out.println("Necesitas Crear Un Avio Per Controlar-lo");
                                }
                                break;
                        case 2:
                                String[] info = p.comptarAvions(mapa,pts).split(",");
                                /*
                                 * for (int i = 0; i < info.length; i++) {
                                        System.out.print(i + " " + info[i] + " | ");
                                }*/
                                int inf = Integer.valueOf(info[3]);
                                if (inf == 1) {
                                        int id = 0;
                                        for (int j = 0; j < 3; j++) {
                                                try {
                                                   int temp = Integer.valueOf(info[j]);
                                                   id = j;
                                                   j = 4;
                                                } catch (Exception e1) {}
                                        }
                                        System.out.printf("Quin Avio voleu eliminar:\n 1) %s\n 4) Cancelar\n[> ", m_id[id]);
                                } else if (inf == 2) {
                                		int [] id = new int[2];
                                		for (int j = 0; j < info.length - 2 || id[1]==0; j++) {
                                            try {
                                            	if(id[0]!=0) {
                                            		 int temp = Integer.valueOf(info[j]);
                                            		 id[0] = j;
                                            	}else {
                                            		int temp = Integer.valueOf(info[j]);
                                            		id[1] = j;
                                            	}
                                            } catch (Exception e1) {}
                                		}
                                        System.out.printf("Quin Avio voleu eliminar:\n 1) %s\n 2) %s\n 4) Cancelar\n[> ",m_id[id[0]],m_id[id[1]]);
                                } else if (inf == 3) {
                                        System.out.printf("Quin Avio voleu eliminar:\n 1) %s\n 2) %s\n 3) %s\n 4) Cancelar\n[> ",avions[0].getMatricula(),avions[1].getMatricula(),avions[2].getMatricula());
                                } else {
                                        System.out.println("Necesitas Crear Un Avio Abans De Eliminar-lo");
                                }
                                if( inf != 0) {
                                	int opt = 0;
	                                switch(inf) {
		                                case 1:
		                                	do{
		                                		opt = e.nextInt();
		                                	}while(!(opt==1 || opt == 4));
		                                	if(opt!=4) {
		                                		//int ident = opt-pts[0];
			                                	/*switch(ident) {
			                                	case 
			                                	}*/
			                                	int n_avio = 2;
			                                	if(info[0].equals("1")) {
			                                		n_avio = 0;
			                                	}else if(info[1].equals("1")) {
			                                		n_avio = 1;
			                                	}
			                                	avions[n_avio].setMatricula("undefined");
			                                	mapa[avions[n_avio].getAlçada()][avions[opt-1].getPosicio_X()] -= pts[n_avio];
			                                	//avions[ident].setMatricula("undefined");
		                                	}
		                                	
		                            	break;
		                                case 2:
		                                	int [] ordenado = new int [2]; // { 1-3 } ;
		                                	do{
		                                		opt = e.nextInt();
	                                		}while(!((opt>0 && opt<3) || opt == 4));
		                                	if(opt!=4) {
		                                		switch(info[0]) {case "1": ordenado[0] = 1;break;}
			                                	if(ordenado[0]==0) {
			                                		switch(info[1]) {case "1": ordenado[0] = 2;ordenado[1] = 3;break;}
			                                	}else {
			                                		switch(info[1]) {case "1": ordenado[1] = 2;break;default: ordenado[1] = 3;break;}
			                                	}
			                                	avions[opt-1].setMatricula("undefined");
			                                	mapa[avions[opt-1].getAlçada()][avions[opt-1].getPosicio_X()] -= pts[ordenado[(opt-1)]-1];
		                                	}
		                                	
		                            	break;
		                                case 3:
		                                	do{
		                                		opt = e.nextInt();
	                                		}while(!(opt>0 && opt<5));
		                                	if(opt!=4) {
		                                		switch(opt) {
			                                		case 1:case 2:case 3:
			                                		//System.out.printf("Alçada: %d , Pos: %d, Pts: %d",avions[opt-1].getAlçada(),avions[opt-1].getPosicio_X(),pts[opt-1]); /* y / x */
			                                		mapa[avions[opt-1].getAlçada()][avions[opt-1].getPosicio_X()] -= pts[opt-1];
			                                		avions[opt-1].setMatricula("undefined");
			                                		break;default:break;
			                                	}
		                                	}

		                            	break;
		                                
		                            }
	                                System.out.println("\n                             ____\n                     __,-~~/~    `---.\n                   _/_,---(      ,    )\n               __ /        <    /   )  \\___\n- ------===;;;'====------------------===;;;===----- -  -\n                  \\/  ~\"~\"~\"~\"~\"~\\~\"~)~\"/\n                  (_ (   \\  (     >    \\)\n                   \\_( _ <         >_>'\n                      ~ `-i' ::>|--\"\n                          I;|.|.|\n                         <|i::|i|`.\n                        (` ^'\"`-' \")");
	                                
                                }
                                //System.out.printf("Quin Avio voleu eliminar:\n 1) %s\n 2) %s\n 3) %s\n[> ");

                                break;
                        case 3:
                                System.out.println("\n       ___                                                                               \n      ]\\  \\                                                                              \n      ] \\  \\                                                                             \n      ]__\\  ' .,_____                                                                    \n      >_             '-,        )                                                        \n        `' .,           \\_    (                                                          \n             `' .,_     | \\    )                      _                                  \n                   |    \\ .\\   ( (       ..:::[=--.  /o\\             _                   \n                    \\.  `\\  , )    )   .:::''      \\ (\")\\           ,==_a=_========()===\n                  _ _\\\\   \\_\\  (  (,`):::,(.        `/:\\           ·  /|_|_|       ||    \n                 )_(  \\\\    \\ )   ) (. )' ('         |:|`\\       ,'  | |`|`|______[__]_  \n                      .\\(   #'~,_(,)' ). (' ),)     _/^|_  -.__.'    '-(O)-------(O)(O)' \n~~~~~~~~~~~~~~~~~~~~~~~~~~~#~~#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n|                                INFORME DEL ACCIDENTE                                  |\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                p.rescatarAvio(5);
                                break;
                        case 4:
                                System.out.println("\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░\n▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒░░▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒░░▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒░░▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒░░  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒░░░░▒▒▒▒░░▒▒░░▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒░░▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒░░▒▒░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒░░░░  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒░░░░  ░░░░░░░░░░                          ░░  ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒\n░░░░░░░░▒▒▒▒▒▒░░                    ░░░░░░░░░░░░░░░░        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒░░░░▒▒░░░░▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒░░▒▒░░▒▒▒▒▒▒▒▒\n▒▒▒▒▓▓▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒░░▒▒▒▒▒▒░░▒▒░░░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒░░░░▒▒░░▒▒▒▒░░░░▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▓▓▓▓▓▓████▓▓▓▓▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░░░░░░░▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░▒▒▒▒░░░░▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▓▓\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓████████▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒██▓▓▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒░░▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░  ░░░░░░▒▒▒▒░░░░▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░    ▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒██▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒░░░░    ▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒░░░░░░░░░░░░░░  ░░░░░░░░░░░░▒▒▒▒░░░░░░░░░░▒▒▒▒░░░░    ▒▒▓▓\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░▒▒░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░░░░░▒▒░░░░▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░▒▒▒▒░░░░░░░░\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒░░░░░░░░░░░░░░      ░░            ░░    ░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒░░░░▒▒░░▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░                          ░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░      ░░            ░░    ░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒░░▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░    ░░░░░░░░░░░░░░░░░░░░  ░░░░▓▓▓▓████▓▓██▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▓▓██▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░          ░░    ░░  ░░░░░░░░░░▓▓████▓▓▒▒██▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░                      ░░░░  ░░▓▓▓▓██▓▓▓▓██▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░░░░░░░\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n▒▒▓▓▓▓▓▓▒▒▓▓▒▒▓▓▒▒▓▓▒▒▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░      ░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒▒▒░░░░░░░░░░░░░░\n▓▓██▓▓██▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▓▓██▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▒▒▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒░░░░▒▒▒▒░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒\n██████████▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓████▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▓▓▒▒░░░░▓▓▓▓░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░\n██████████████▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓██████████▓▓▓▓▓▓▓▓██▓▓▓▓████▓▓██▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░\n▓▓▓▓████████▓▓██████████████████▓▓██████████████▓▓████▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▓▓▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒░░░░░░░░▒▒░░░░▒▒\n▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓████████████████████████████▓▓▓▓▓▓▓▓████████▓▓▓▓██▓▓██▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▓▓▓▓▒▒▓▓▒▒          ▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▓▓▒▒▒▒▓▓░░▒▒░░░░░░░░░░░░░░░░▒▒▒▒░░░░░░░░░░\n████████████▓▓▓▓▓▓████████▓▓▓▓▓▓▓▓████████▓▓████▓▓▓▓██████████████████▓▓▓▓▓▓██▓▓▒▒▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓██▒▒▒▒▒▒▒▒      ░░▓▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒░░░░░░░░░░░░░░░░▒▒▓▓░░░░\n██████████████████████████████▓▓▓▓██▓▓██▓▓▓▓██████████████▓▓██████▓▓████▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▒▒▒▒▓▓▒▒▓▓        ▓▓▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒▓▓▒▒▓▓▒▒▒▒▓▓▒▒▒▒░░▒▒░░░░░░░░░░░░░░\n▓▓▓▓▓▓▓▓▓▓████▓▓██████▓▓██▓▓▓▓██████▓▓████████▓▓██████████▓▓████████████▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▒▒██▒▒▒▒▓▓        ▒▒▒▒▓▓░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒░░▒▒░░░░▒▒▓▓▒▒▓▓▒▒▒▒▒▒▒▒▓▓░░░░▒▒░░░░░░░░\n██▓▓██████████████▓▓██▓▓▓▓██▓▓██████▓▓██████▓▓▓▓██████████████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▒▒▒▒▓▓▓▓▓▓▒▒▓▓░░░░▓▓        ░░░░░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░▓▓░░▓▓▒▒░░▒▒▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▓▓░░░░▒▒░░\n██▒▒████████████████████████████████▓▓████████▓▓▓▓▓▓██████▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒░░▒▒    ▒▒      ░░░░░░░░▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓░░▓▓▒▒░░▒▒▒▒▒▒▓▓▓▓▒▒▓▓▓▓▒▒▓▓▒▒░░▓▓▒▒\n████████████▓▓██▓▓████████████████████████████████████████▓▓██████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▒▒░░▒▒▒▒▒▒▓▓░░░░  ░░▒▒        ░░░░░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░▓▓▓▓░░░░▓▓░░▒▒▒▒▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓██\n██████████████▓▓▓▓▓▓██████████▓▓████████████████████████▓▓██████████▓▓▒▒▒▒▓▓▓▓▒▒▒▒▒▒████░░░░░░▒▒██░░░░  ░░░░        ░░░░░░░░░░▒▒░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░▓▓▒▒░░░░▓▓░░▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▒▒\n████████████████▓▓██▓▓██████▓▓██████▓▓▒▒▒▒██████▓▓▓▓██▓▓██████████████▓▓▓▓▓▓▓▓▓▓▒▒▒▒██▒▒░░░░░░▒▒██░░░░░░░░░░░░    ░░  ░░░░░░░░████░░░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░░░▓▓░░░░░░▒▒▒▒▒▒▒▒██▓▓▓▓██▓▓\n██████████████████████████▓▓▒▒▓▓██▓▓████▓▓████▓▓▓▓██████▓▓▓▓▒▒▓▓▓▓▒▒██▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓░░░░░░░░▒▒▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓▒▒████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▒▒░░░░▒▒▒▒▒▒▒▒▓▓▓▓▓▓██▓▓\n██████████████████████▓▓▓▓██▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓██▓▓██████▓▓██▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓░░░░░░░░██▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒░░▒▒░░▒▒▒▒░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░▒▒▒▒▒▒▒▒▒▒▓▓▓▓████\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒▓▓▓▓██\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░▒▒░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████████████▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒\n▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓██████████████▓▓▓▓▓▓▒▒▒▒▒▒▒▒░░░░░░░░▓▓██░░░░▒▒░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░▒▒░░░░▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓████████████▓▓▓▓▓▓▒▒▒▒▒▒▒▒░░░░░░░░████░░░░▒▒▒▒▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒░░░░░░░░████▒▒░░▒▒██▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░░░▒▒▒▒░░▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒██▓▓▒▒░░░░██▓▓░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▓▓░░░░░░░░██▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░▒▒░░░░▒▒▒▒░░▒▒▒▒\n▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░██▒▒░░░░░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒░░░░░░░░▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                                p.previsioCel(mapa,avions);
                                break;
                        case 5:
                                System.out.println("Finalitzant Servei ...");
                                jugando = false;
                                break;
                        }
                } while (jugando == true);
        }
		private void previsioCel(int[][] mapa, avio[] avions) {
			boolean good = true;
			for(int i = 0; i < mapa.length;i++) {
				for(int c = 0; c < mapa[0].length;c++) {
					if(!(i == 0 && c == 0)) {
						switch(mapa[i][c]) {
							case 6:System.out.printf("\nPrevisio de Xoc : Avio 1 i Avio 5 en el mateix quadrant!\n Alçada: %d\n Posicio: %d\n",i,c);good=false;break;
							case 8:System.out.printf("\nPrevisio de Xoc : Avio 1 i Avio 7 en el mateix quadrant!\n Alçada: %d\n Posicio: %d\n",i,c);good=false;break;
							case 12:System.out.printf("\nPrevisio de Xoc : Avio 5 i Avio 7 en el mateix quadrant! Alçada: %d\n Posicio: %d\n",i,c);good=false;break;
							case 13:System.out.printf("\nPrevisio de Xoc : Avio 1 , Avio 5 i Avio 7 en el mateix quadrant!\n Alçada: %d\n Posicio: %d\n",i,c);good=false;break;
							default:break;
						}
					}
				}
			}
			if(good==true) {
				System.out.println("\nActualment NO hi ha Cap Perill Aeri.\n");
			}
			
		}

}