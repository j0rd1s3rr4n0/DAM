public class temps extends Thread { //una clase que hereda de la clase Thread
	static int seg;
	int temps_boost;
	private static int instant_on;
	private static int instant_off;
	private static boolean SpeedBoosted = false;
    public temps(){// Contructor porque la clase es heredada 
        super();
    }
    public void run() {
    int nuSeg=0; //El Contador de de segundos    
        if(Game.ISLIVERAQUET && Game.isGamestarted()) {
        	try {
                for (;;){ //inicio del for infinito           
                	seg+= nuSeg;   
                	nuSeg++; 
                	Game.sc(nuSeg);
                	//System.out.println(nuSeg);
                	int tms =999;
                	sleep(tms);
                	System.out.println("SEGONS: "+seg);
                }             
            } catch (Exception e) {
                 System.err.println(e.getMessage());
            }
        }/*else {
        	System.err.println(seg+" "+nuSeg);
        }*/
 }
    
  public static int getTemps() {return temps.seg;}
  public static void BoostSpeed() {
	  
	  temps.instant_off = temps.instant_on+10;
	  if(Game.VELOCIDADJUEGO < 1.5) {
		  Game.VELOCIDADJUEGO +=0.1;
	  }
	  if(!isSpeedBoosted()) {
		  temps.instant_on = temps.getTemps();
	  }
	  if(temps.instant_off <= temps.instant_on) {
		  Game.VELOCIDADJUEGO = 0;
	  }
	  
  }
public static int getSeg() {
	return seg;
}
public static void setSeg(int seg) {
	temps.seg = seg;
}
public int getTemps_boost() {
	return temps_boost;
}
public void setTemps_boost(int temps_boost) {
	this.temps_boost = temps_boost;
}
public static int getInstant_on() {
	return instant_on;
}
public static void setInstant_on(int instant_on) {
	temps.instant_on = instant_on;
}
public static int getInstant_off() {
	return instant_off;
}
public static void setInstant_off(int instant_off) {
	temps.instant_off = instant_off;
}
public static boolean isSpeedBoosted() {
	return SpeedBoosted;
}
public static void setSpeedBoosted(boolean speedBoosted) {
	SpeedBoosted = speedBoosted;
}

}