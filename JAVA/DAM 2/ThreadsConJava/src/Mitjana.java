import java.util.Arrays;

public class Mitjana extends Thread {

	int array[];
	int pos_inici;
	int pos_fin;
	int nums_totals;
	float resultat; //mitjana
	
	
	
	public Mitjana(int[] array, int pos_inici, int pos_fin) {
		this.array = array;
		this.pos_inici = pos_inici;
		this.pos_fin = pos_fin;
		
	}
	public void run() {
        try {
        	int[] arrayNums = Arrays.copyOfRange(array, pos_inici, pos_fin);
        	nums_totals = arrayNums.length;
        	
            for(int i = 0;i<nums_totals;i++) {
               // System.out.println((i+1)+"/"+nums_totals);
                resultat+=arrayNums[i];
                
            	Thread.sleep(0);
            }

        } catch (InterruptedException e) {
        	
        }
    }

	
	public double getResultat() {
		return resultat/nums_totals;
	}
	public void setResultat(float resultat) {
		this.resultat = (float) resultat;
	}
	
}
