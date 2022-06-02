import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class controlador_aeri {
	/*
	/ -> Falta Acabar 
	X -> Fet 
	[/] 1.- Afegir un avió a l’espai aeri. 
	[/] 2.- Gestionar un avió de l’espai Aeri. 
	[/] 3.- Mostrar L’espai Aeri actual. 
	[X] 4.- Xifrar els avions de combat. 
	[X] 5.- Desxifrar els avions de combat 
	[X] 6.- Sortir

	COMERCIAL 
	[X] 1 - Encendre i apagar motors. 
	[X] 2 - Accelerar i Frenar. 
	[X] 3 - Pujar Tren d’aterratge i Baixar tren d’aterratge. 
	[X] 4 - Pujar i baixar en alçada. 
	[X] 5 - Establir rumb. 
	[X] 6 - Retornar Estat de l’Avió (Llegir estat Avió) 
	[X] 7 - Posicionar X/Y 
	[X] 9 - Sortir

	COMBAT 
	[X] 1 - Encendre i apagar motors. 
	[X] 2 - Accelerar i Frenar. 
	[X] 3 - Pujar Tren d’aterratge i Baixar tren d’aterratge. 
	[X] 4 - Pujar i baixar en alçada. 
	[X] 5 - Establir rumb. ( 0 - 360 ) 
	[X] 6 - Retornar Estat de l’Avió (Llegir estat Avió) 
	[X] 7 - Posicionar X/Y 
	[X] 8 - DISPARAR AVIO 
	[X] 9 - Sortir


	[X] Construir FUNCION DE VISUALIZAR AVIONS 
	[/] CONSTRUIR FUNCION DE PELIGROS

	[X] CONSTRUIR SETCOORDENADES 
	[X] CONSTRUIR DISPARAR


	[-] VALIDAR CREAR AVION SI YA HAY Y ALERTAR 
	[-] CREAR FUNCION ACCIDENTE DE AVION 
	[-] CREAR FUNCION ACCIDENTE AVION MULTIPLE


	[X] CREAR GENERADOR DE MATRICULAS 
	[-] CREAR CONSTRUCTOR DE AVIONES : 
	CREAR AVION 
		1 ) TIPO 1
		2 ) TIPO 2
		3 ) Altres --> Altres : e.next(); --> USAR REGEX
*/
	String addPlane() {
		Scanner e = new Scanner(System.in);
		String resposta = "";
		String option = "";
		boolean need_crypt = true;
		int opt = 0;


		boolean valid = false;
		do {
			String[] opt_avions = { "Comercial", "Combat" };
			System.out.printf("VOLEU CREAR UN AVIO DE \n [0] %s\n [1] %s\n[> ".toUpperCase(), opt_avions[0], opt_avions[1]);
			option = e.next();
			try {
				opt = Integer.parseInt(option);
				System.out.printf("Ha Escollit Avio %s\n\n".toUpperCase(), opt_avions[opt]);
				valid = true;
			} catch (Exception e2) {valid = false;}
		} while (!valid);

		ArrayList<String> parametres = new ArrayList<String>();


		String retornar = "";
		if (option.equals("0")) {
			retornar += "Comercial";
		} else {
			retornar += "Combat";
			System.out.print("DESEA ENMASCARAR DICHO AVION DE COMBATE CON UN COMERCIAL?\n[0] SI\n[1] NO\n[> ");
			int f;
			if (0 == (f = e.nextInt())) {
				try {
					parametres.add("Comercial");
					retornar += "X";
				} catch (Exception e2) {
					// TODO: handle exception
				}
			} else if (1 == f) {
				try {
					parametres.add("Combat");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return retornar;
	}

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		boolean[] test = new boolean[5];
		char[][] mapa = new char[1000][1000];
		controlador_aeri p = new controlador_aeri();
		p.MatriculGen(); // DELETE
		ArrayList<avio> avions = new ArrayList<avio>();
		/*
		 	COMERCIAL
		 	avions.add(new comercial("AF-GFF", "BOEING", "747", "BCN", "MAD", 2, new Coordenada(100, 120), 100,new int[] { 100, 70, 20 }));
		 	COMBAT
			avions.add(new combat("AF-DDD", "BOEING", "747", "BCN", "AUS", new Coordenada(100, 100), 1,new int[] { 100, 100 }, new boolean[5],false));
			COMBATX
			avions.add(new combat(p.MatriculGen(), "BOEING", "747", "BCN", "AUS", new Coordenada(100, 100), 1,new int[] { 100, 100 }, new boolean[5],true));
		*/
		do {
			System.out.print(
					("\n" + "1.- Afegir un avió a l’espai aeri.\r\n" + "2.- Gestionar un avió de l’espai Aeri.\r\n"
							+ "3.- Mostrar L’espai Aeri actual.\r\n" + "4.- Xifrar els avions de combat.\r\n"
							+ "5.- Desxifrar els avions de combat\r\n" + "6.- Sortir\n[> ").toUpperCase());
			switch (e.nextInt()) {

			case 1:
				//TODO AQUIVOY
				boolean forcecontinue = false;
				if(p.HasPlaneOnLandingTrack(avions)) { // HAY UN AVION EN LA PISTA? -- SI?
					System.out.print("\nACTUALMENT HI HA UN AVIO A LA PISTA. AFEGIR UN AVIO PODRIA CAUSAR UN ACCIDENT\nVOLS CONTINUAR?\n[> ");
					String sel = p.nextText(e,"\nACTUALMENT HI HA UN AVIO A LA PISTA. AFEGIR UN AVIO PODRIA CAUSAR UN ACCIDENT\nVOLS CONTINUAR?\n[> " ,"[SI,NO,S,N]");
					if(sel.toUpperCase().equals("SI") || sel.toUpperCase().equals("S")) {forcecontinue = true;}
					else {forcecontinue = false;}
				}else {forcecontinue = true;}
				
				if(forcecontinue == true) {
					String newavio = p.addPlane();
					// [Combat, Comercial, EC-AFF, BOEING, 747, BCN, MAD, 2]
					String data[] = "Matricula (EX: EC-AFF),Marca (EX: Boeing),Model (EX: 747),Origen (EX: BCN),Desti(EX: MAD),Numero Tripulants (0-9),COORDENADA X,COORDENADA Y,NUM. PASSATGERS,LLARGADA,GROSOR,ALTURA"
							.toUpperCase().split(",");
					// PISTA D'ATERRATGE I DESPEGUE
					int min_x = 0 , max_x = 120 , min_y = 100, max_y = 100;
					
					if (newavio.equals("Combat")) {
						avions.add(new combat(
								//p.nextText(e, data[0]), // MÄTRICULÄ
								p.menu_add(e, data[0], 0,"[A-Z]{2}-[A-Z]{3}"),
								//p.nextText(e, data[1]), 	// MÄRCÄ
								p.menu_add(e, data[1], 1,"[A-Z]{2-10}"),
								//p.nextText(e, data[2]), 	// MODEL
								p.menu_add(e, data[2], 2,"[0-9]{3}"),
								//p.nextText(e, data[3]), 	// ORIGEN
								p.menu_add(e, data[3], 3,"[A-Z]{3}"),
								//p.nextText(e, data[4]), 	// DESTI
								p.menu_add(e, data[4], 4,"[A-Z]{3}"),
								new Coordenada(p.nextNumRand(max_x, min_x, data[6]), p.nextNumRand(max_y, min_y, data[7])), // COORDENÄDES
								//p.nextNum(e, data[5]), 		// N-TRIPULANTS
								Integer.parseInt(p.menu_add(e, data[5], 5,"[0-9]{1}")),
								new int[] { 1, 0 }, 		// DESTI_MISIL
								new boolean[5], 				// MISILS
								false							// ENCRIPTAT
						));
					}if (newavio.equals("CombatX")) {
						avions.add(new combat(
								//p.nextText(e, data[0]), // MÄTRICULÄ
								p.menu_add(e, data[0], 0,"[A-Z]{2}-[A-Z]{3}"),
								//p.nextText(e, data[1]), 	// MÄRCÄ
								p.menu_add(e, data[1], 1,"[A-Z]{2-10}"),
								//p.nextText(e, data[2]), 	// MODEL
								p.menu_add(e, data[2], 2,"[0-9]{3}"),
								//p.nextText(e, data[3]), 	// ORIGEN
								p.menu_add(e, data[3], 3,"[A-Z]{3}"),
								//p.nextText(e, data[4]), 	// DESTI
								p.menu_add(e, data[4], 4,"[A-Z]{3}"),
								new Coordenada(p.nextNumRand(max_x, min_x, data[6]), p.nextNumRand(max_y, min_y, data[7])), // COORDENÄDES
								//p.nextNum(e, data[5]), 		// N-TRIPULANTS
								Integer.parseInt(p.menu_add(e, data[5], 5,"[0-9]{1}")),
								new int[] { 1, 0 }, 		// DESTI_MISIL
								new boolean[5], 			// MISILS
								true 						// ENCRIPTAT
						));
					} else if (newavio.equals("Comercial")) {
						avions.add(
								new comercial(
									//p.nextText(e, data[0]), // MÄTRICULÄ
									p.menu_add(e, data[0], 0,"[A-Z]{2}-[A-Z]{3}"),
									//p.nextText(e, data[1]), 	// MÄRCÄ
									p.menu_add(e, data[1], 1,"[A-Z]{2-10}"),
									//p.nextText(e, data[2]), 	// MODEL
									p.menu_add(e, data[2], 2,"[0-9]{3}"),
									//p.nextText(e, data[3]), 	// ORIGEN
									p.menu_add(e, data[3], 3,"[A-Z]{3}"),
									//p.nextText(e, data[4]), 	// DESTI
									p.menu_add(e, data[4], 4,"[A-Z]{3}"),
									//p.nextNum(e, data[5]), 		// N-TRIPULANTS
									Integer.parseInt(p.menu_add(e, data[5], 5,"[0-9]{1}")),
									new Coordenada(p.nextNumRand(max_x, min_x, data[6]), p.nextNumRand(max_y, min_y, data[7])), // COORDENÄDES
									//p.nextNum(e, data[8]), // N_PÄSSÄTGERS
									Integer.parseInt(p.menu_add(e, data[6], 6,"[0-9]{1-3}")),
									new int[] { 
											//p.nextNum(e, data[9]),
											Integer.parseInt(p.menu_add(e, data[6], 6,"[0-9]{1-3}")),
											//p.nextNum(e, data[10]),
											Integer.parseInt(p.menu_add(e, data[6], 6,"[0-9]{1-3}")),
											//p.nextNum(e, data[11])
											Integer.parseInt(p.menu_add(e, data[6], 6,"[0-9]{1-3}"))
											} // DIMENSIONS
																														// []
								)
						);
					}
				}
				break;

			case 2:
				System.out.print("QUIN AVIO VOLS GESTIONAR:\n");
				int para = -1;
				int ander = p.SelectAvio(e, avions);
				if (avions.size() >= ander && ander != -1) { // SI EL AVION EXISTE => GESTIONAR
					if (avions.get(ander).askcombat() == true) {
						// TODO COMBAT
						do {
							System.out.print(
									"1 - Encendre i apagar motors.\n2 - Accelerar i Frenar.\n3 - Pujar Tren d’aterratge i Baixar tren d’aterratge.\n4 - Pujar i baixar en alçada.\n5 - Establir rumb.\n6 - Retornar Estat de l’Avió (Llegir estat Avió)\n7 - Posicionar X/Y\n8 - DISPARAR AVIO \n9 - Sortir\n[> "
											.toUpperCase());
							para = e.nextInt();
							switch (para) {
							// MOTOR
							case 1:
								avions.get(ander).switchMotor();
								break;
							// ACCELERAR / FRENAR ...
							case 2:
								if (avions.get(ander).isMotor_on() == true) {
									boolean ok;
									do {
										System.out
												.println("STATUS AVIO: " + avions.get(ander).getVelocitat() + " KM/H");
										System.out.print(
												"ACCIONS:\n 1) accelerar\n 2) STOP FRENAR/ACCELERAR \n 3) Frenar\n[> "
														.toUpperCase());
										switch (e.nextInt()) {
										case 1:
											avions.get(ander).Accelerar();
											ok = true;
											break;
										case 2:
											avions.get(ander).idle();
											ok = true;
											break;
										case 3:
											avions.get(ander).Frenar();
											ok = true;
											break;
										default:
											System.out.println();
											ok = false;
										}
									} while (!ok);
								} else {
									System.out.println(" NO POTS REALITZAR AQUESTA ACCIO SI NO ENCENS EL MOTOR! ");
								}
								break;
							// TREN ATERRATGE
							case 3:
								if (avions.get(ander).isMotor_on() == true) {
									if (avions.get(ander).getAlçada() < 500
											&& avions.get(ander).isTrenAterratge() == true) {
										System.out
												.println(" NO POTS TREURE EL TREN D'ATERRATGE A MENYS DE 500 METRES! ");
									} else {
										if (avions.get(ander).getAlçada() > 500
												&& avions.get(ander).isTrenAterratge() == false
												&& avions.get(ander).getVelocitat() > 300) {
											System.out
													.println("NO POTS POSAR EL TREN D'ATERRATGE A MÉS DE 500 METRES! ");
										} else {
											avions.get(ander).switchTrenAterratge();
										}
									}
								} else {
									System.out.println(" NO POTS REALITZAR AQUESTA ACCIO SI NO ENCENS EL MOTOR! ");
								}
								break;
							// PUJAR / BAIXAR
							case 4:
								if (avions.get(ander).isMotor_on() == true) {
									if (avions.get(ander).getVelocitat() <= 179 && avions.get(ander).getAlçada() == 0) {
										System.out.println("PER ENLAIRARSE ES NECESITA MINIM 180 KM/H !");
									} else {
										boolean ok;
										do {
											System.out.println("STATUS AVIO: " + avions.get(ander).getAlçada() + " , "
													+ avions.get(ander).getVelocitat() + "KM/H");
											System.out.print(
													"ACCIONS:\n 1) ASCENDIR\n 2) DESCENDIR \n 3) MANTENIR ALÇADA\n[> "
															.toUpperCase());
											switch (e.nextInt()) {
											case 1:
												if (avions.get(ander).getVelocitat() >= 180) {
													if (avions.get(ander).getCoordenades().getLatitud() == 500
															&& avions.get(ander).isTrenAterratge() == true) {
														System.out.println(
																"NO POTS INCREMENTAR L'ALÇADA SI NO AMAGUES EL TREN D'ATERRATGE!");
													} else {
														avions.get(ander).upAlçada();
													}
												} else {
													System.out.println("NECESITES INCREMENTAR LA VELOCITAT A "
															+ (180 - avions.get(ander).getVelocitat())
															+ " MÉS DE LA ACTUAL!");
												}
												ok = true;
												break;
											case 2:
												if (avions.get(ander).getAlçada() == 0
														&& avions.get(ander).isEnlairat() == true) {
													// TODO AQUI VALIDAR SI POS ESTA EN PISTA I SI ES AIXI MIRAR VELOCITAT PER ACCIDENT AERI O NO
													avions.remove(ander);
													ok = true;
													para = 9;
													break;
												} else if (avions.get(ander).getAlçada() == 0
														&& avions.get(ander).isEnlairat() == false) {
													System.out.println("EPP! QUE NO POTS ATRAVESAR EL TERRA ");
													ok = false;
													break;
												} else {
													if (avions.get(ander).getCoordenades().getLatitud() == 500
															&& avions.get(ander).isTrenAterratge() == false) {
														System.out.println(
																"NO POTS DECREMENTAR L'ALÇADA SI NO ACTIVES EL TREN D'ATERRATGE!");
													} else {
														avions.get(ander).downAlçada();
													}
												}
												ok = true;
												break;
												
											case 3:
												ok = true;
												break;
											default:
												System.out.println();
												ok = false;
											}
										} while (!ok);
									}

								} else {
									System.out.println(" NO POTS REALITZAR AQUESTA ACCIO SI NO ENCENS EL MOTOR! ");
								}
								break;
							// ESTABLIR RUMB
							case 5:
								int grados;
								do {
									System.out.print("\nQUIN RUMB VOLS ANAR?\n ACTUALMENT VAS A "
											+ avions.get(ander).getRumb() + "º\n[> ");
									grados = e.nextInt();
								} while (!(grados >= 0 && grados <= 360));
								break;
							// SORTIR
							case 6:
								avions.get(ander).info();
								break;
							// SET POS X/Y
							case 7:
								avions.get(ander).getCoordenades().setLatitud(e.nextInt());
								avions.get(ander).getCoordenades().setLongitud(e.nextInt());
								break;
							case 8:
								combat Acombat = (combat) avions.get(ander);
								if (Acombat.contMisil() > 0) {
									Acombat.disparara();
									int[] objectiu = Acombat.getObjectiu();
									try {
										boolean impacte = false;
										int explosion = -1;
										for (int i = 0; i < avions.size(); i++) {
											int x = avions.get(i).getCoordenades().getLongitud();
											int y = avions.get(i).getCoordenades().getLatitud();
											if (objectiu[0] == x && objectiu[1] == y) {
												impacte = true;
												explosion = i;
											}
										}
										if (impacte == false) {
											System.out.println(" EXPLOCIÓ EN EL AIRE ");
										} else {
											System.out.println(
													"AVIÓ " + avions.get(explosion).getMatricula() + " IMPACTAT!");
											avions.remove(explosion);
										}
									} catch (Exception e3) {

									}

								} else {
									System.out.println(" NO TENS MUNICIÓ ");
								}
							}
						} while (para != 9);

					} else {
						do {
							System.out.print(
									"1 - Encendre i apagar motors.\n2 - Accelerar i Frenar.\n3 - Pujar Tren d’aterratge i Baixar tren d’aterratge.\n4 - Pujar i baixar en alçada.\n5 - Establir rumb.\n6 - Retornar Estat de l’Avió (Llegir estat Avió)\n7 - Posicionar X/Y\n8 - Sortir\n[> "
											.toUpperCase());
							para = e.nextInt();
							switch (para) {
							// MOTOR
							case 1:
								avions.get(ander).switchMotor();
								break;
							// ACCELERAR / FRENAR ...
							case 2:
								if (avions.get(ander).isMotor_on() == true) {
									boolean ok;
									do {
										System.out
												.println("STATUS AVIO: " + avions.get(ander).getVelocitat() + " KM/H");
										System.out.print(
												"ACCIONS:\n 1) accelerar\n 2) STOP FRENAR/ACCELERAR \n 3) Frenar\n[> "
														.toUpperCase());
										switch (e.nextInt()) {
										case 1:
											avions.get(ander).Accelerar();
											ok = true;
											break;
										case 2:
											avions.get(ander).idle();
											ok = true;
											break;
										case 3:
											avions.get(ander).Frenar();
											ok = true;
											break;
										default:
											System.out.println();
											ok = false;
										}
									} while (!ok);
								} else {
									System.out.println(" NO POTS REALITZAR AQUESTA ACCIO SI NO ENCENS EL MOTOR! ");
								}
								break;
							// TREN ATERRATGE
							case 3:
								if (avions.get(ander).isMotor_on() == true) {
									if (avions.get(ander).getAlçada() < 500
											&& avions.get(ander).isTrenAterratge() == true) {
										System.out
												.println(" NO POTS TREURE EL TREN D'ATERRATGE A MENYS DE 500 METRES! ");
									} else {
										if (avions.get(ander).getAlçada() > 500
												&& avions.get(ander).isTrenAterratge() == false
												&& avions.get(ander).getVelocitat() > 300) {
											System.out
													.println("NO POTS POSAR EL TREN D'ATERRATGE A MÉS DE 500 METRES! ");
										} else {
											avions.get(ander).switchTrenAterratge();
										}
									}
								} else {
									System.out.println(" NO POTS REALITZAR AQUESTA ACCIO SI NO ENCENS EL MOTOR! ");
								}
								break;
							// PUJAR / BAIXAR
							case 4:
								if (avions.get(ander).isMotor_on() == true) {
									if (avions.get(ander).getVelocitat() <= 179 && avions.get(ander).getAlçada() == 0) {
										System.out.println("PER ENLAIRARSE ES NECESITA MINIM 180 KM/H !");
									} else {
										boolean ok;
										do {
											System.out.println("STATUS AVIO: " + avions.get(ander).getAlçada() + " , "
													+ avions.get(ander).getCoordenades().getLatitud() + " , "
													+ avions.get(ander).getVelocitat() + "KM/H");
											System.out.print(
													"ACCIONS:\n 1) ASCENDIR\n 2) DESCENDIR \n 3) MANTENIR ALÇADA\n[> "
															.toUpperCase());
											switch (e.nextInt()) {
											case 1:
												if (avions.get(ander).getVelocitat() >= 180) {
													if (avions.get(ander).getCoordenades().getLatitud() == 500
															&& avions.get(ander).isTrenAterratge() == true) {
														System.out.println(
																"NO POTS INCREMENTAR L'ALÇADA SI NO AMAGUES EL TREN D'ATERRATGE!");
													} else {
														avions.get(ander).upAlçada();
													}
												} else {
													System.out.println("NECESITES INCREMENTAR LA VELOCITAT A "
															+ (180 - avions.get(ander).getVelocitat())
															+ " MÉS DE LA ACTUAL!");
												}
												ok = true;
												break;
											case 2:
												if (avions.get(ander).getAlçada() == 0
														&& avions.get(ander).isEnlairat() == true) {
													avions.remove(ander);
													ok = true;
													para = 9;
													break;
												} else if (avions.get(ander).getAlçada() == 0
														&& avions.get(ander).isEnlairat() == false) {
													System.out.println("EPP! QUE NO POTS ATRAVESAR EL TERRA ");
													ok = false;
													break;
												} else {
													if (avions.get(ander).getCoordenades().getLatitud() == 500
															&& avions.get(ander).isTrenAterratge() == false) {
														System.out.println(
																"NO POTS DECREMENTAR L'ALÇADA SI NO ACTIVES EL TREN D'ATERRATGE!");
													} else {
														avions.get(ander).downAlçada();
													}

												}
												ok = true;
												break;
											case 3:
												ok = true;
												break;
											default:
												System.out.println();
												ok = false;
											}
										} while (!ok);
									}

								} else {
									System.out.println(" NO POTS REALITZAR AQUESTA ACCIO SI NO ENCENS EL MOTOR! ");
								}
								break;
							// ESTABLIR RUMB
							case 5:
								int grados;
								do {
									System.out.println("QUIN RUMB VOLS ANAR?\n ACTUALMENT VAS A "
											+ avions.get(ander).getRumb() + "º\n[> ");
									grados = e.nextInt();
								} while (grados >= 0 && grados <= 360);
								break;
							// SORTIR
							case 6:
								avions.get(ander).info();
								break;
							// SET POS X/Y
							case 7:
								avions.get(ander)
									.getCoordenades()
										.setLatitud(
												e.nextInt()
										);
								avions.get(ander)
									.getCoordenades()
										.setLongitud(
												e.nextInt()
										);
								break;
							}
						} while (para != 8);

					}
				}
				break;
			case 3:
				System.out.println("SITUACIO DE LES AERONAUS");
				p.MostraEspaiAeriActual(avions);
				System.out.println("PERILLS DETECTATS");
				p.accident_xoc(avions);
				break;
			case 4:
				System.out.println("FUNCIONALITAT EN MANTENIMENT");
				p.decryptAvio(avions);
				break;
			case 5:
				System.out.println("FUNCIONALITAT EN MANTENIMENT");
				p.cryptAvio(avions);
				break;
			case 6:
				System.out.println("[ SORTINT DEL CONTROLADOR AERI ]\n");
				e.close();
				System.exit(0);
				break;
			default:
				System.out.println("\n la opcio escollida no correspon a cap accio\n".toUpperCase());
			}
		} while (true);

	}

	void MostraEspaiAeriActual(ArrayList<avio> avions) {
		String[] parametres = " ,Marca:,Model: ,Matricula: ,X: ,Y: ,Alçada: ,Velocitat: ,Tren aterratge: ,Motor: ,Misils: ,Origen: ,Desti: "
				.split(",");

		int longit_max = 0;
		for (int i = 0; i < parametres.length; i++) {
			if (parametres[i].length() > longit_max) {
				longit_max = parametres[i].length();
			}
		}

		for (int x = 0; x < parametres.length; x++) {
			System.out.print(parametres[x] + Centered(longit_max, parametres[x]));
			for (int i = 0; i < avions.size(); i++) {
				if (avions.get(i) instanceof combat) {
					combat Acombat = (combat) avions.get(i);
					// System.out.println(Acombat.isEncriptat());
					if (Acombat.isEncriptat()) {
						System.out.print("	ENCRIPTAT");
					} else {
						System.out.print("        ");
						switch (x) {
						case 0:
							System.out.print("	AVIO " + i);
							break;
						case 1:
							System.out.print("	" + avions.get(i).getMarca());
							break;
						case 2:
							System.out.print("	" + avions.get(i).getModel());
							break;
						case 3:
							System.out.print("	" + avions.get(i).getMatricula());
							break;
						case 4:
							System.out.print("	" + avions.get(i).getCoordenades().getLongitud());
							break;
						case 5:
							System.out.print("	" + avions.get(i).getCoordenades().getLatitud());
							break;
						case 6:
							System.out.print("	" + avions.get(i).getAlçada());
							break;
						case 7:
							System.out.print("	" + avions.get(i).getVelocitat());
							break;
						case 8:
							if (avions.get(i).isTrenAterratge()) {
								System.out.print("	On");
							} else {
								System.out.print("	Off");
							}
							;
							break;
						case 9:
							if (avions.get(i).isMotor_on()) {
								System.out.print("	On");
							} else {
								System.out.print("	Off");
							}
							break;
						case 10:
							System.out.print("	" + Acombat.contMisil());
							break;
						case 11:
							System.out.print("	" + avions.get(i).getOrigen());
							break;
						case 12:
							System.out.print("	" + avions.get(i).getDesti());
							break;
						}
					}
				} else {
					System.out.print("        ");
					switch (x) {
					case 0:
						System.out.print("AVIO " + i);
						break;
					case 1:
						System.out.print(avions.get(i).getMarca());
						break;
					case 2:
						System.out.print(avions.get(i).getModel());
						break;
					case 3:
						System.out.print(avions.get(i).getMatricula());
						break;
					case 4:
						System.out.print(avions.get(i).getCoordenades().getLongitud());
						break;
					case 5:
						System.out.print(avions.get(i).getCoordenades().getLatitud());
						break;
					case 6:
						System.out.print(avions.get(i).getAlçada());
						break;
					case 7:
						System.out.print(avions.get(i).getVelocitat());
						break;

					case 8:
						if (avions.get(i).isTrenAterratge()) {
							System.out.print("On");
						} else {
							System.out.print("Off");
						}
						;
						break;
					case 9:
						if (avions.get(i).isMotor_on()) {
							System.out.print("On");
						} else {
							System.out.print("Off");
						}
						break;

					case 10:
						System.out.print("------");
						break;
					case 11:
						System.out.print(avions.get(i).getOrigen());
						break;
					case 12:
						System.out.print(avions.get(i).getDesti());
						break;
					}
				}
			}
			System.out.println();
		}
	}

	String nextText(Scanner e, String ms) {
		System.out.print(ms + ": ");
		return e.next();
	}

	String nextText(Scanner e, String ms, String regex) {

		String r;

		do {
			System.out.println(ms + ": ");
			r = e.next();
		} while (!regex_validator(r, regex));

		return r;
	}

	int nextNum(Scanner e, String ms) {
		System.out.print(ms + ": ");
		return e.nextInt();
	}

	int nextNumRand(int max, int min, String ms) {
		int random = (int) ((Math.random() * (max - min)) + min);
		System.out.print(ms + ": " + random + "\n");
		return random;
	}

	boolean regex_validator(String ms, String regex) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(ms);
		boolean matchFound = matcher.find();
		return matchFound;
	}

	// MENU DISPARAR A QUINA COORDENADA

	void disparoA(int coord[], ArrayList<avio> avions) {
		int x = 0;
		while (x < avions.size() && avions.get(x).getCoordenades().getLongitud() != coord[0]
				&& avions.get(x).getCoordenades().getLatitud() != coord[1]) {
			x++;
		}
		if (x < avions.size()) {
			avions.remove(avions.get(x));
		}

	}

	// MENU DE SELECCIO DE L'AVIO
	int SelectAvio(Scanner e, ArrayList<avio> avions) {
		int sel = -1;
		for (int i = 0; i < avions.size(); i++) {
			System.out.println((i + 1) + ") " + avions.get(i).getMatricula());
		}
		System.out.println((avions.size() + 1) + ") Salir".toUpperCase());
		do {
			System.out.print("[> ");
			sel = e.nextInt();
		} while (sel >= 1 && sel > (avions.size() + 1));
		sel -= 1;
		if (sel == avions.size()) {
			System.out.println("[ Saliendo del Gestor de Aviones... ]".toUpperCase());
			return -1;
		} else {
			return sel;
		}
	}

	String Centered(int longitud, String frase) {
		String str_rtn = "";
		for (int i = frase.length(); i < longitud; i++) {
			str_rtn += " ";
		}
		return str_rtn;
	}

	void cryptAvio(ArrayList<avio> avions) {
		for (int i = 0; i < avions.size(); i++) {
			if (avions.get(i) instanceof combat) {
				try{
					combat acombat = (combat) avions.get(i);
					acombat.setEncriptat(false);
				}catch (Exception e) {}
			}
		}
	}

	void decryptAvio(ArrayList<avio> avions) {
		for (int i = 0; i < avions.size(); i++) {
			if (avions.get(i) instanceof combat) {
				try{
					combat acombat = (combat) avions.get(i);
					acombat.setEncriptat(true);
				}catch (Exception e) {}
			}
		}
	}
	String MatriculGen() {
		String [] letra = "abcdefghijklmnopqrstuvwxyz".toUpperCase().split("");
		String matri = "";
		for(int i = 0; i < 5 ; i++) {
			int random = (int) ((Math.random() * (letra.length - 0)) + 0);
			if(i == 2) {
				matri+="-";
			}
			matri+= letra[random];
		}
		return matri;
	}
	String menu_add(Scanner e,String section ,int options_array_index,String pattern){
		String value_rtn = ""; 
		String datos [][] = {
		/*"Matricula (EX: EC-AFF)"*/
			{"","","","","","","ALTRE"},
		/*"Marca (EX: Boeing)"*/
			"Iberia,Boeing,Condor,Luftansa,Rayanair,Ana AirLine,ALTRE".toUpperCase().split(","),
		/*"Model (EX: 747)"*/
			"747,220,293,335,261,419,ALTRE".split(","),
		/*"Origen (EX: BCN)"*/
			"BCN,IBZ,FKT,MAD,LSB,NYC,ALTRE".split(","),
		/*"Desti(EX: MAD)"*/
			"BCN,IBZ,FKT,MAD,LSB,NYC,ALTRE".split(","),
		/*"Numero Tripulants (2-3)"*/
			"0,1,2,3,4,5,ALTRE".split(","),
		/*"COORDENADA X"*/
			"100".split(","),
		/*"COORDENADA Y"*/
			"100".split(","),
		/*"NUM. PASSATGERS"*/
			"5,50,100,250,500,1000,ALTRE".split(","),
		/*"LLARGADA"*/
			"5,10,20,25,50,100,ALTRE".split(","),
		/*"GROSOR"*/
			"3,5,10,20,25,50,ALTRE".split(","),
		/*"ALTURA"*/
			"2,5,10,15,20,25,ALTRE".split(","),
		};
		 for(int i = 0;i<datos[0].length-1; i++) {
			 datos[0][i] = MatriculGen();
		 }
		//MENU
		System.out.println("OPCIONS "+section+":");
		for(int i = 0; i < datos[options_array_index].length; i++){
			System.out.printf(" %d ) %s\n",i,datos[options_array_index][i]);
		}
		int slct = -1;
		do{
			System.out.print("[> ");
			slct = e.nextInt();
		}while(datos[options_array_index].length < slct && slct < 0);
		if(slct == 6){
			System.out.print("ALTRE: ");
			value_rtn = nextText(e,section,pattern);
		}else{
			value_rtn = datos[options_array_index][slct];
		}
		System.out.println("ESCOLLIT COM A "+section.toUpperCase()+" "+value_rtn);
		return value_rtn;
	}
	boolean HasPlaneOnLandingTrack(ArrayList<avio> avions) {
		boolean t = false;
		for(int i = 0; i < avions.size() ; i++ ) {
			avio abreviame = (avio) avions.get(i);
			// 50 PERQUE CONSIDERO QUE SI ESTA A MENYS DE 50m d'alçada 
			if(abreviame.getAlçada() < 50 &&(abreviame.getCoordenades().getLongitud() == 100 && (abreviame.getCoordenades().getLatitud()>99 && abreviame.getCoordenades().getLatitud() < 121))) {
				System.out.println(" [ A B * C D ]");
				t = true;
			}else {
				t = false;
			}
		}
		return t;
	}
	void isAccidentAeri(ArrayList<avio> avions,Scanner e,int t_avio) {
		for(int i = 0; i < avions.size() ; i++ ) {
			avio abreviame = (avio) avions.get(i);
			// SI AVIO A menys de 10m altura && x = 100 && y = 100-120 && NotHasPlaneInTrack 
			if(abreviame.getAlçada() < 10 && ( abreviame.getCoordenades().getLongitud() == 100 && (abreviame.getCoordenades().getLatitud()>99 && abreviame.getCoordenades().getLatitud() < 121)) && HasPlaneOnLandingTrack(avions) == false && (abreviame.getVelocitat()<200)) {
				System.out.println(" [ ATERRANT AVIO . . . ]");
				System.out.print("VOL APARCAR L'AVIO?\nS/n\n[> ");
				try {
					switch(e.next().charAt(0)) {
						case 'S':case's':avions.remove(t_avio);break;
						default:break;
					}
				}catch (Exception e2) {}
			}else {System.out.println("ACCIDENT AERI DE L'AVIO AMB MATRICULA "+abreviame.getMatricula()+"! A LA POSICIO("+2+","+1+")");}
		}
	}
	void accident_xoc(ArrayList<avio> avions) {
		char [] implicats = new char[10];
		for(int i = 0; i < avions.size(); i++) {
			for(int x = 0; x < avions.size(); x++) {
				avio Avio1 = (avio) avions.get(i);
				avio Avio2 = (avio) avions.get(x);
				if(!Avio1.getMarca().equals(Avio2.getMarca())) {
					if(20 > Math.abs(Avio1.getCoordenades().getLongitud() - Avio2.getCoordenades().getLongitud())){
						if(20 > Math.abs(Avio1.getCoordenades().getLatitud() - Avio2.getCoordenades().getLatitud())){
							avions.remove(avions.indexOf(Avio1));
							avions.remove(avions.indexOf(Avio2));
							System.out.printf("\n L'AVIO %s i l'avio %s s'han estavellat!\n".toUpperCase(),Avio1.getMatricula(),Avio2.getMatricula());
						}else if(500 > Math.abs(Avio1.getCoordenades().getLatitud() - Avio2.getCoordenades().getLatitud())){
							System.out.printf("\n L'AVIO %s i l'avio %s estan a %d metres de DISTANCIA de Longitud\n".toUpperCase(),Avio1.getMatricula(),Avio2.getMatricula(),Math.abs(Avio1.getCoordenades().getLatitud() - Avio2.getCoordenades().getLatitud()));
						}
					}else if(50 > Math.abs(Avio1.getCoordenades().getLongitud() - Avio2.getCoordenades().getLongitud())){
						System.out.printf("\n L'AVIO %s i l'avio %s estan a %d metres de DISTANCIA de Longitud\n".toUpperCase(),Avio1.getMatricula(),Avio2.getMatricula(),Math.abs(Avio1.getCoordenades().getLongitud() - Avio2.getCoordenades().getLongitud()));
					}
				}
			}
		}
	}
}
