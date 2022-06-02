	
public class testJSON {

	public static void main(String[] args) {
		
	SCOREBOARD_READER datos = new SCOREBOARD_READER("scoreboard.json");
	
	String[] nombres = datos.getusers();
	for(int i = 0; i < nombres.length; i++) {
		String nom = nombres[i];
		int points = datos.getpoints(nom);
		System.out.println("Nom: "+nom+" Puntuacio: "+points);
	}
	datos.saveUser("Jordi",9000000);
	for(int i = 0; i < nombres.length; i++) {
		String nom = nombres[i];
		int points = datos.getpoints(nom);
		System.out.println("Nom: "+nom+" Puntuacio: "+points);
	}	
	
	int[][] random_block_selector = new int [100][100];
	// PONE DE MANERA RANDOM EN LAS LISTAS LOS NUEMEROS PARA HACER SORTEO
	
	for(int x = 0; x < random_block_selector[0].length; x++) {
		for(int i = 0; i < random_block_selector[0].length ; i++) {
			random_block_selector[i][x] = getRandomNumber(0, 9);
		}
	}
	
	//ESCOGE LOS BLOQUES DEFINITIVAMENTE
		int b;
		for(int x = 0; x < 5; x++) {
			//Sleep();
			b = 0;
			for(int i = 0; i < 8; i++) {
				//Sleep();
				for(int o = 0; o < 1000000;o++) {b=o;}
				
				b = random_block_selector[getRandomNumber(0,99)][getRandomNumber(0,99)];
				
			}
		}

	}
	public static int getRandomNumber(int min, int max) {
		int[]randomlist = new int[5];
		for(int i=0;i<randomlist.length-1;i++) {
			float g = (float) ((Math.random() * (max - min)) + min);
			randomlist[i]= (int) g; 
		}
		int h = ((int) ((Math.random() * (5 - 1)) + 1));
	    return randomlist[h];
	}
}
