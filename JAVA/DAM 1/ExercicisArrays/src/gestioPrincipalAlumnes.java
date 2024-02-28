import java.util.Scanner;

public class gestioPrincipalAlumnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner e = new Scanner(System.in);
		String[] llistaAlumnes=null;
		char opcioMenu=' ';
		int capacitatAula=0;
		int punterPosLliure=0;
		String matriculaAlumne="";
		
		
		do {
			System.out.println("z.- Inicialitzar Llista Classe");
			System.out.println("a.- Afegir alumne");
			System.out.println("b.- Llistar alumnes");
			System.out.println("c.- Buscar alumne");
			System.out.println("s.- Sortir");
			
			opcioMenu=e.next().charAt(0);
			switch(opcioMenu) {
				case 'z':    
							 if(llistaAlumnes==null) {
								 System.out.println("Quina es la capacitat de aula:");
								 capacitatAula=e.nextInt();
								 llistaAlumnes = new String[capacitatAula];
								 }
							 else {
								 System.out.println("Ja está inicialitzat");
							 }
							 break;
							 
				case 'a':   
							if(punterPosLliure<capacitatAula) {
								System.out.println("Entra Matricula del nou alumne:");
								matriculaAlumne=e.next();
								//Hauriem de mirar si existeix l'alumne
								llistaAlumnes[punterPosLliure]=matriculaAlumne;
								punterPosLliure++;
							}
							else
							{
								System.out.println("No hi ha més lloc");
							}
							
							break;
							
				case 'b': for(int pos=0; pos<llistaAlumnes.length;pos++) {
								System.out.println(llistaAlumnes[pos]);
							}
							break;
				case 'c': System.out.println("Entra la matricula de alumne a buscar:");
						  matriculaAlumne=e.next();
						  int pos=0;
						  boolean trobat=false;
						  while (trobat==false && pos<llistaAlumnes.length) {
							  if(llistaAlumnes[pos].equalsIgnoreCase(matriculaAlumne)) {
								  trobat=true;
								  System.out.println("Alumne trobat a la posició: " + pos);
								  
							  }
							  else {
								  pos++;
							  }
						  }
						  if(trobat==false) {
							  System.out.println("Alumne no existeix");
						  }
			
			}
			
		}while (opcioMenu!='s');
		
		
		
	}

}