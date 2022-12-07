import java.util.Scanner;

public class Exercici95 {
	
	public static void Sleep(int time) {try {Thread.sleep(time);} catch (InterruptedException e) {}}
	
	public static void main(String[] args) {
		
		Scanner e = new Scanner(System.in);
		boolean valid_alum = false,valid_assig=false;
		int n_alum=0,n_assig=0;
		
		
		// ALUMNES
		while(!valid_alum) {
			System.out.print("Nº Alumnes [max. 30] > ");
			n_alum = e.nextInt();
			if(n_alum >= 1 && n_alum <= 30) {valid_alum = true;}
		}
		
		// ASSIGNATURES
		while(!valid_assig){
			System.out.print("Nº Assignatures [Només: 5] > "); // System.out.print("Nº Assignatures [min. 5] > ");
			n_assig = e.nextInt();
			if(n_assig == 5) {valid_assig = true;} // >= 5 SUPERIOR A 5 ASIGNATURAS
		}
		
		
		n_alum+=1;
		n_assig+=1;
		
		String [] alumnos = new String [n_alum];
		boolean repetido = true;
		for(int a = 0; a < alumnos.length-1;a++) {
			System.out.printf("CODI DE l'ALUMNE %d > ",a+1);
			String F =e.next();
			for(int count = 0; count < alumnos.length;count++) {
				if ( F.equals(alumnos[count])){repetido = true;System.err.println("EL CODI ESTA REPETIT!");break;}
				repetido = false;
			}
			if(repetido ==false) {alumnos[a] = F;}
			if(repetido == true) {a-=1;}
		}
	
		System.out.println("\n=======================================\nTAULA ALUMNES ASIGNATURES \n=======================================");
		String [] Nom_Assignatura = new String [n_assig];
		int [] asignaturas = new int [n_assig];
		System.out.print("Assignatura_N | ");
		for(int ass = 0; ass < n_alum-1;ass++) {
			Sleep(1);
			System.err.print("A_"+(ass+1)+" | ");
			Sleep(1);
		}
		System.out.println();
		Sleep(1);
		System.err.print("---------------");
		Sleep(1);
		for(int ass = 0; ass < n_alum-1;ass++) {
			Sleep(1);
			System.err.print("------");
			Sleep(1);
		}
		System.out.println();
		
		
		
		for(int ass = 0; ass < asignaturas.length-1;ass++) {
			Nom_Assignatura[ass]="Assignatura_"+(ass+1);
		}
		
		double [][] TABLA = new double [n_assig][n_alum];
		/* ASSIGNATURA */
		double [] suma = new double [n_assig-1];
		double [] min = new double [n_assig-1];
		double [] max = new double [n_assig-1];
		double [] cursando = new double [n_assig-1]; 
		// PER COMPTAR MITJANA = SUM/cursado (cursado es sumatori de alumnes pero si resultat -1 llavors no suma )
		
		/* ALUMNE */
		double [] suma_al = new double [n_alum-1];
		double [] suspens = new double [n_alum-1];
		double [] aprovats = new double [n_alum-1];
		double [] cursando_al = new double [n_alum-1];
		
		
		for(int filas = 0; filas < TABLA.length-1; filas++) {
			Sleep(1);
			System.err.printf("%s | ",Nom_Assignatura[filas]);
			Sleep(1);
			for(int columnas = 0;columnas < n_alum-1; columnas ++) {
				System.out.print(TABLA[filas][columnas]+" | ");
			}
			System.out.println();
		}
		
		for(int filas = 0; filas < TABLA.length-1; filas++) {
			System.out.printf("\nAssignatura %d: ",filas+1);
			for(int columnas = 0;columnas < n_alum-1;columnas++) {
				System.out.printf("\nAlumne %s: ",alumnos[columnas]);				
				double F = e.nextDouble();
				
				TABLA[filas][columnas] = F;
				/* CALCULAR MEDIA DE MATERIAS*/
				if (columnas == 0){min[filas] = TABLA[filas][columnas];}
				if (F >= max[filas]) {max[filas] = F;}
				if (F <= min[filas]) {min[filas] = F;}
				
				suma[filas]+=F;
								
			}
			//System.out.println("\nMax: "+max[filas]+",\nMin: "+min[filas]+",\nSuma: "+suma[filas]);
		}
		double [] mitjana = new double [n_alum];
		int columnas;
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		for(int filas = 0; filas < TABLA.length-1 ; filas++) {
			for(columnas = 0;columnas < n_alum-1;columnas++) {
				double F = TABLA[filas][columnas];
				
				TABLA[filas][columnas] = F;
				
				/* CALCULAR MEDIA DE ALUMNOS*/
				if (F >= aprovats[columnas]) {aprovats[columnas] += 1;}
				if (F < 5) {suspens[columnas] += 1;}
				suma_al[columnas]+=F;
				
				//System.out.println("\nMax: "+aprovats[columnas]+",\nMin: "+suspens[columnas]+",\nSuma: "+suma_al[columnas]);
			}
			mitjana[columnas]= (suma_al[columnas]/5.0);
		}
		/******************************************************************************/
		System.out.println("\n=======================================\nTAULA ALUMNES ASIGNATURES \n=======================================");
		System.out.print("Assignatura_N | ");for(int ass = 0; ass < n_alum-1;ass++) {
			if (ass < 9) {
				Sleep(1);System.err.print("A_"+(ass+1)+" | ");Sleep(1);
			}else {
				Sleep(1);System.err.print("A_0"+(ass+1)+" | ");Sleep(1);
			}
		}
		System.out.println();Sleep(1);System.err.print("---------------");Sleep(1);
		for(int ass = 0; ass < n_alum-1;ass++) {
			Sleep(1);System.err.print("-------");Sleep(1);
		}System.out.println();
		for(int ass = 0; ass < asignaturas.length-1;ass++) {
			Nom_Assignatura[ass]="Assignatura_"+(ass+1);
		}
		for(int filas = 0; filas < TABLA.length-1; filas++) {
			Sleep(1);System.err.printf("%s | ",Nom_Assignatura[filas]);Sleep(1);
			for(int columnas_1 = 0;columnas_1 < n_alum-1; columnas_1 ++) {
				if (TABLA[filas][columnas_1] < 10.0 && TABLA[filas][columnas_1] > 0) {
					System.out.print("0"+TABLA[filas][columnas_1]);Sleep(1);System.err.print(" | ");Sleep(1);
				}else if ((TABLA[filas][columnas_1] == -1)) {
					Sleep(1);System.err.print(" N.P");Sleep(1);Sleep(1);System.err.print(" | ");Sleep(1);
					cursando[filas]-=1;
					suma[filas]+=1;
				}else {
					System.out.print(TABLA[filas][columnas_1]);Sleep(1);System.err.print(" | ");Sleep(1);
				}
				cursando[filas]+=1;
			}System.out.println();
		}
	
		
		
		/******************************************************************************/
		System.out.println("ESTADISTICAS ASSIGNATURA");
		for(int ctt = 0 ; ctt < n_assig-1 ; ctt++) {
		System.out.print(Nom_Assignatura[ctt]+": ");
		System.out.println("Max: "+max[ctt]+", Min: "+min[ctt]+", Suma: "+suma[ctt]+" | Mitja: "+(suma[ctt]/cursando[ctt]));
		}
		
		System.out.println("ESTADISTICAS ALUMNE");
		for(int ctt = 0 ; ctt < n_alum-1 ; ctt++) {
			System.out.print(alumnos[ctt]+": ");
			System.out.println("Max: "+aprovats[ctt]+", Min: "+suspens[ctt]+", Suma: "+suma_al[ctt]+" | Mitja: "+(suma_al[ctt]/(n_assig-1)));
		}
		
	}
}
