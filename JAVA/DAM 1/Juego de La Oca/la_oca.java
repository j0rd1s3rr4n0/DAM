import java.util.Scanner;
import java.util.Random;

public class la_oca {	
	public static void sleep(double s) { // CREA UN TIMER PARA EL ENFASIS QUE DOY CON EL SYSO.ERR PARA QUE NO HAGA OVERLAPING
		try {
			Thread.sleep((int)(s*1000.0));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner e = new Scanner(System.in);
		Random aleatori = new Random();
		int num_jugadors = 0;
		int torn = 0;
		String ubi;
		
		int [] daus = {0,0};
		boolean guanyador = false;
		int  fraseNum;
		boolean tornarTirar = false;
		int tornactual;
		String [] frase = {
				"Como has caido en una casilla NORMAL, el aburrimiento es total",  					//0
				"De OCA en OCA i tiro perque em toca",							//1
				"De PUENTE a PUENTE y tiro porque me lleva la corriente.", 		 //2
				"De DADO a DADO y tiro porque me ha tocado.",					//3
				"Como la forma del dado no es redonda, caes en la FONDA",		//4
				"Como jugar es un gozo, caes en el POZO",						//5
				"Haciendo lo que querias, en la PRISION acabarias",				//6
				"Del LABERINTO al 30",											//7
				"Como has caido en la MUERTE, vuelves al principio sin suerte"	//8
		};
		String comando = "AAA";
		String [] tauler = {"0","0","0","0","0","Oca","Pont","0","0","Oca","0","0","Pont","0","Oca","0","0","0","Oca","Fonda","0","0","0","Oca","0","0","0","Oca","0","0","0","pou","Oca","0","0","0","Oca","0","0","0","0","Oca","Laberint","0","0","Oca","0","0","0","0","Oca","0","Presó","0","Oca","0","0","0","Mort","Oca","0","0","0","Jardí de la Oca"};
		
		/*
		 *  NUMERO DE JUGADORS
		 */
		while(true) {
			System.out.print("Num de Jugadors:\n(2-4)> ");//OK
			num_jugadors = e.nextInt();
			if (num_jugadors < 2 || num_jugadors > 9) {
				System.err.println("Solo se puede jugar de 2 a 4 personas");
			}
			else {break;}
			
		}
		
		int [] posicio = new int[num_jugadors];
		int [] tirada = new int[num_jugadors];
		int [] tornsAfectat = new int[num_jugadors]; 
		
		int pozo = -1;
		
		//boolean [] efecte = new boolean[num_jugadors];
		String [] nom_jugadors = new String[num_jugadors]; //OK!
		
		/*
		 * NOM DE JUGADORS
		 */
		
		for(int x = 0;x<num_jugadors;x++) {
			System.out.printf("Nom del Jugador %d\n>",x+1);

			nom_jugadors[x] = e.next();
			
			//if(nom_jugadors[x].length()<1) {System.err.println("El nombre debe tener mínimo 1 Letra.");x-=1;}
		}
		/*
		 * MOSTRAR TAULER SENSE JUGADORS * 
		 * System.out.println("Tauler:");for(int x = 0;x<tauler.length;x++) {System.out.print(tauler[x]+",");} *
		*/
		int torngeneral = 0;
		while(!guanyador) {
			/* TIRAR DAUS */
			//sleep(1.0);
			// DAU 1
			
			if(tornsAfectat[torn]>0) {				
			
				tornsAfectat[torn]-=1;
				System.out.printf("Es el torn del jugador %d (%s)\n>> ",(torn+1),nom_jugadors[torn]);
				sleep(1);
				System.err.printf("El Jugador fue penalizado con un EFECTO,turnos de castigo restantes: %d\n\n\n",tornsAfectat[torn]);
				sleep(1);
			}
			else {				
				System.out.println("[========================================================================]\r\n");
				System.out.printf("És el torn del jugador %d, %s.\n\n>> ",(torn+1),nom_jugadors[torn]);
				comando ="tirar";
				//comando = e.next().toLowerCase();
				System.out.print(" tirar ");
				sleep(1.0);
				if(comando.equals("tirar")) {
					daus[0]=aleatori.nextInt(6)+1;
					//	DAU 2
					if (posicio[torn]<60) {
						daus[1]=aleatori.nextInt(6)+1;
					}else {
						daus[1]=0;
					}
					
					posicio[torn] = posicio[torn]+daus[0]+daus[1];
					
					if (posicio[torn] > 63) {
						posicio[torn] = 63 - ((daus[0] + daus[1] + posicio[torn])-63);
					}
					if(torngeneral==0) {
						//DAUS 4-5
						if((daus[0]==4 && daus[1]==5) || (daus[0]==5 && daus[1]==4)) {posicio[torn] = 53;}
						else {
						//DAUS 3-6
						if((daus[0]==3 && daus[1]==6) || (daus[0]==6 && daus[1]==3)) {posicio[torn] = 26;				}
						else {posicio[torn] = daus[0] + daus[1];}
						}
					}
					System.out.printf("\n\nHas obtingut un %d i %d = %d.",daus[0],daus[1],(int)(daus[0]+daus[1]));
					
					
					
					if(posicio[torn]==63) {
						guanyador = true;
						posicio[torn]=63;
						//System.out.printf("\n%s",tauler[posicio[torn]]);
						System.out.printf("\nAvanzas hasta la casilla %d \n",posicio[torn]);
						break;
					}
					
					}
					if((tauler[posicio[torn]]).equals("0")) {
						ubi = ""; 
					}
					ubi = tauler[posicio[torn]];
					//System.out.printf("\n%s",ubi]);
					System.out.printf("\nAvanzas hasta la casilla %d \n",posicio[torn]);
					//sleep(0.1);
					//System.err.printf("\n%s\n",(tauler[posicio[torn]]));
					if (posicio[torn] < 25) {
						fraseNum=1;
					}
					else {
						fraseNum=0;
					}
					switch(posicio[torn]) {
					
						/*OCA*/case 59: posicio[torn] = 63;  fraseNum = 1;guanyador=true;sleep(3);break;
						/*OCA*/ case 5: posicio[torn] = 9;   fraseNum = 1; tornarTirar=true; break;
						/*OCA*/ case 9: posicio[torn] = 14;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 14: posicio[torn] = 18;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 18: posicio[torn] = 23;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 23: posicio[torn] = 27;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 27: posicio[torn] = 32;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 32: posicio[torn] = 36;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 36: posicio[torn] = 41;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 41: posicio[torn] = 45;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 45: posicio[torn] = 50;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 50: posicio[torn] = 54;  fraseNum = 1; tornarTirar=true;break;
						/*OCA*/case 54: posicio[torn] = 59;  fraseNum = 1; tornarTirar=true;break;
						
						/*PONT*/ case 6: posicio[torn] = 12; fraseNum = 2; tornarTirar=true;break;
						/*PONT*/ case 12: posicio[torn] = 6; fraseNum = 2; tornarTirar=true;break;
						
						/*FONDA*/ case 19: posicio[torn] = 19; fraseNum = 4; tornsAfectat[torn] = 1; /*efecte[torn] = true;*/ break; //
						/*WELL*/  case 31: posicio[torn] = 31; fraseNum = 5; tornsAfectat[torn] = 2; if (pozo!=-1) {tornsAfectat[pozo]=0;System.out.printf("\nEL JUGADOR, %s ha salido del POZO!\n",nom_jugadors[pozo]);pozo = torn;}else { pozo = torn;}/*efecte[torn] = true;*/ break; //
						/*JAIL*/  case 52: posicio[torn] = 52; fraseNum = 6; tornsAfectat[torn] = 3; /*efecte[torn] = true;*/ break; //
						/*MAZE*/  case 42: posicio[torn] = 39; fraseNum = 7; break; //
						/*MORT*/  case 58: posicio[torn] = 0;  fraseNum = 8; break; //
						
						/*NORM*/ default:fraseNum = 0;break;
						//posicio[torn] =posicio[torn] + daus[0]+daus[1]
						
					}
					if(guanyador==true) {
						break;
					}
					
					sleep(1);
					System.err.printf("\n[ Casilla nº %s: %s ]\n\n\n",posicio[torn],frase[fraseNum]);
					sleep(0.1);

				}
				
				if(!tornarTirar){
					torn++;torngeneral++;
					if(torn == num_jugadors) {torn = 0;}
				}else{
					tornarTirar=false;
				}
				
				
				
				// posicions especials amb un switch
				// retallar array
				
				
			}
		if(guanyador == true) {
			sleep(0.1);
			System.err.printf("\n\nEl Jugador %s Ha guanyat a la ronda %d\n\n",nom_jugadors[torn],torngeneral);
			
			System.err.println("████████████████████████████████████████████████████████████████████████████╗");
			System.err.println("╚═══════════════════════════════════════════════════════════════════════════╝");
			sleep(0.1);
			System.out.println(" ██████╗    █████╗   ███╗   ██╗   █████╗   ██████╗    ██████╗   ██████╗  ██╗");
			System.out.println("██╔════╝   ██╔══██╗  ████╗  ██║  ██╔══██╗  ██╔══██╗  ██╔═══██╗  ██╔══██╗ ██║");
			System.out.println("██║  ███╗  ███████║  ██╔██╗ ██║  ███████║  ██║  ██║  ██║   ██║  ██████╔╝ ██║");
			System.out.println("██║   ██║  ██╔══██║  ██║╚██╗██║  ██╔══██║  ██║  ██║  ██║   ██║  ██╔══██╗ ╚═╝");
			System.out.println("╚██████╔╝  ██║  ██║  ██║ ╚████║  ██║  ██║  ██████╔╝  ╚██████╔╝  ██║  ██║ ██╗");
			System.out.println(" ╚═════╝   ╚═╝  ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝  ╚═════╝    ╚═════╝   ╚═╝  ╚═╝ ╚═╝");
			sleep(0.1);
			System.err.println("████████████████████████████████████████████████████████████████████████████╗");
			System.err.println("╚═══════════════════════════════════════════════════════════════════════════╝");
			
		}
		
 }
}