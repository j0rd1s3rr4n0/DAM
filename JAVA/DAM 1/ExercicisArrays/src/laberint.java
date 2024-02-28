import java.util.Scanner;

public class laberint {
	
	char[][] laberintO ={{' ','#',' ',' ',' ',' ','#',' ',' ',' '},
						 {' ','#',' ',' ',' ',' ',' ',' ',' ',' '},
						 {' ','#',' ',' ',' ',' ','#',' ',' ',' '},
						 {' ',' ',' ',' ',' ',' ','#',' ',' ',' '},
						 {' ','#',' ',' ',' ',' ','#',' ',' ',' '},
						 {' ','#',' ',' ',' ',' ','#',' ',' ',' '},
						 {' ','#',' ',' ',' ',' ','#',' ',' ',' '},
						 {' ','#',' ',' ',' ',' ','#',' ',' ',' '},
						 {' ',' ',' ',' ',' ',' ','#',' ',' ',' '},
						 {' ','#',' ',' ',' ',' ','#',' ',' ','s'}};
	char[][] laberintD;
	final static int MAXF=10;
	final static int MAXC=10;
	//Posici� del Personatge
	int posF, posC;
	//Posici� futura del personatge
	int posF2, posC2;
	
	Scanner e = new Scanner(System.in);
	//Guardem el moviment 'a','s',d,w
	char mov;
	boolean play;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		laberint l= new laberint();
		l.principal();
	}
	
	public void principal()
	{
		//El nostre equivalent al main ser� aquest m�tode principal(). Ho fem per no arrossegar l'STATIC
		// per tot el codi.
		
		//Si play est� a true llavors hem de seguir jugant. Quant arribem a la sortida llavors play caldr� posar-lo a false
		play=true; 
		
		//inicialitzaLaberintOrigen();
		laberintD= new char[MAXF][MAXC];
		situarPersonatgeInicial();
		imprimirLaberintD();
		while(play==true)
		{
			//Mentre no final partida jugar!
			System.out.print("Entra un moviment!: ");
			mov=e.next().charAt(0);
			boolean ok=verificaMoviment();
			if(ok==true) {
				ferMoviment();
				imprimirLaberintD();
			}
			else
			{  System.out.println("No podem fer aquest moviment");
			}
			
		}
		System.out.println("Has sortit del laberint!!");
	}
	
	
	public void ferMoviment() {
		
		//Analitzem el mov...
		switch(mov) {
		
		case 'a':
		case 'A': posC2=posC-1; posF2=posF;  break;
		case 'd':
		case 'D': posC2=posC+1; posF2=posF;  break;
		case 'w':
		case 'W': posC2=posC; posF2=posF-1;  break;
		case 's':
		case 'S': posC2=posC; posF2=posF+1;  break;
			
		
		}
		
		if ((posC2<0) || (posC2>MAXC) ||(posF2<0) ||(posF2>MAXF))
		{  //Fora de marges
			System.out.println("No ens podem moure fora dels marges!!");
		}
		else
		{    //Ens movem!
			//Hauriem de comparar la posici� futura amb el que hi hagi a LaberintO.
			switch(laberintO[posF2][posC2])
			{
			case ' ': laberintD[posF][posC]='+';
					  posF=posF2;
					  posC=posC2;
					  break;
					  
			case '#': laberintD[posF2][posC2]='#';  
					  System.out.println("Hi ha un mur, no podem passar!");
					  break;
			case 's': laberintD[posF][posC]='+';
			  		  posF=posF2;
			  		  posC=posC2;
			  		  play=false;
			  		  break;
			}		
		}

		
		
	}
	
	
	public boolean verificaMoviment() {
		boolean correcte=false;
		if(mov=='a' || mov=='A' || mov=='w' || mov=='W' || mov=='s' || mov=='S'|| mov=='d' || mov=='D') 
		{correcte=true;}
		
		return correcte;
	}
	
	public void situarPersonatgeInicial() {
		//Posicio personatge ve marcada per posF i posC
		do {
			posF=(int)Math.random()*(MAXF-1);
			posC=(int)Math.random()*(MAXC-1);
			
		}while (laberintO[posF][posC]!=' ');
		
		
	}
	
	
	public void inicialitzaLaberintOrigen() {
		laberintO= new char[MAXF][MAXC];
		for(int f=0; f<MAXF; f++)
		{
			if(f!=MAXF-2) {laberintO[f][1]='#';}
		}
	}
	
	public void imprimirLaberintO()
	{
		for(int f=0; f<MAXF; f++)
		{
			for(int c=0; c<MAXC; c++)
			{
			    if(f==posF && c==posC) {
			    	System.out.print('P');
			    }
			    else
			    {
			    	System.out.print(laberintO[f][c]);
			    }
			}
			System.out.println();
		}
	}
	
	public void imprimirLaberintD()
	{
		for(int f=0; f<MAXF; f++)
		{
			for(int c=0; c<MAXC; c++)
			{
			    if(f==posF && c==posC) {
			    	System.out.print('P');
			    }
			    else
			    {
			    	System.out.print(laberintD[f][c]);
			    }
			}
			System.out.println();
		}
	}
	

}