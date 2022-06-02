package upisoft_Jordi_Serrano;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		main p = new main();
		Scanner e = new Scanner(System.in);
		ArrayList<Personatge> personatges = new ArrayList<Personatge>();

		int opcio;
		do {
			System.out.print("\n1. Exit\n2. Insert data\3. Show data in console\n4. Fight between factions\nChoose an option: ");
			opcio = e.nextInt();
			int raca;
			boolean faction;
			String nombre;
			boolean habilitat = true;
			int habilitat_orc = 0;
			double habilitat_elf = 0;
			int nWeapons;
			switch(opcio) {
			case 1:
				System.exit(0);
				break;
			case 2:
				do {
					System.out.println("Choose race (1-Human 2-Orc 3-Elf): ");
					raca = e.nextInt();	
				}while(raca > 0 && raca < 4);
				int fact;
				do {
					System.out.println("Choose faction (1-Alliance 2-Horde): ");
					fact = e.nextInt();
				}while(fact != 1 && fact != 2);
				if(fact ==1) {
					faction = true;
				}
				else {
					faction = false;
				}
					
				
				do {
					System.out.println("Name: ");
					nombre = e.next();
				}while(nombre.length()<3);
				switch(raca) {
					case 1:
						char thab;
						
						do {
							System.out.print("Inteligencia (Y-N): ");
							thab = e.next().toLowerCase().charAt(0);
						}while(thab!='n'||thab!='y');
						if(thab == 'n') {
							habilitat = true;
						}else {
							habilitat = false;
						}
						break;
					case 2:
						
						do {
							System.out.print("Tenacitat (1-3): ");
							habilitat_orc = e.nextInt();
						}while(habilitat_orc>3 || habilitat_orc<1);
						break;
					case 3:
						do {
							System.out.print("Magia (0-0.99): ");
							habilitat_elf = e.nextDouble();
						}while(habilitat_elf >= 1 || habilitat_elf < 0);
						break;
				}
				
				System.out.println("Attack power: ");
				int attackPower = e.nextInt();
				int mWeapons;
				do {
					System.out.println("How many weapons (1-10): ");
					mWeapons = e.nextInt();
				}while(mWeapons > 10 || mWeapons < 1);
				ArrayList<weapon> weapons = new ArrayList<weapon>();
				nWeapons = 0;
				for(int i = 0; i < mWeapons; i++) {
					
					System.out.println("Weapon 1 Name: ");
					String wName = e.next();
					System.out.println("Weapon 1 Attack Power: ");
					int attacPower = e.nextInt();
					nWeapons+=attackPower;
					weapons.add(new weapon(wName,attackPower));
				}
				switch(raca) {
				case 1:
					personatges.add(new Human(faction,nombre,mWeapons, nWeapons,habilitat));
					
					break;
				case 2:
					personatges.add(new Orc(faction,nombre,mWeapons, nWeapons,habilitat_orc));
					break;
				case 3:
					personatges.add(new Elf(faction,nombre,mWeapons, nWeapons,habilitat_elf));
					break;
			}
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			}
		}while(opcio!=1);
		e.close();
	}
	
	public insertData() {
		Scanner e = new Scanner(System.in);
		
		
		
		
	}

}
