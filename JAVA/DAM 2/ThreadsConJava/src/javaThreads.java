import java.util.ArrayList;
public class javaThreads {
   

    public static void main(String[] args) {
    	long TempsInici = System.nanoTime(); // CONTADOR INICI DE PROGRAMA
    	
        ArrayList <Thread> threads = new ArrayList();
        int TAMANY_ARRAY = 1000;
        int CONVERSOR_ns_TO_s = 1000000000; // 1 000 000 000 nanosegons = 1 segon
        
        int[] lista = new int[TAMANY_ARRAY];
        int NUM_THREADS = 5; // MÉS OPTIM = TAMANY_ARRAY
        int POS_FRE = 200;   // TAMANY_ARRAY/NUM_THREADS;
        
        
        
        
        //RANDOM VALUES
        int max = 10;
        int min = 0;
        
        
        for(int i = 0; i < TAMANY_ARRAY; i++) {
        	lista[i] = (int)(Math.random() *  max - min + 1) + min;
        }
        
        //Constructor de Threads
        for(int NUM_THREAD_ITERATOR = 0; NUM_THREAD_ITERATOR < NUM_THREADS;NUM_THREAD_ITERATOR++) {
        	threads.add(
        			new Mitjana(
        					lista,
        					(POS_FRE * NUM_THREAD_ITERATOR),
        					(POS_FRE * NUM_THREAD_ITERATOR)+ POS_FRE
        			)
			);
        }
        
        
        //Dar prioridad a los 10 primeros threads 
        /*for(int i = 0,i = 200; i < 10;i++,i--){
        	if(i == 0) {
        		threads.get(i).setPriority(1);
        	}else {
        		threads.get(i).setPriority(i+100);	
        	}
        }*/
        
    	//EXECUCIÓ Threads
        for(int i = 0; i < threads.size();i++) {
        	threads.get(i).setName("THREAD Nº "+(i+1));
        	threads.get(i).start();
        }
        
        //COMPROVACIO DE SI TOTS ELS FILS JA NO ESTAN EN PROCES
        boolean AllAlive = false;
        System.out.println("RUNNING THREADS!");
        do{
        	AllAlive = true;
        	for(int i = 0; i < threads.size();i++) {
	        	if(!threads.get(i).isAlive()) {AllAlive = false;}
        	}
        	try {
    			Thread.sleep(500);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }while(AllAlive);
        
        //System.out.println("\nTOTS ELS THREADS JA NO ESTAN VIUS");
        
        // MOSTRAR 
        
        float suma_media_threads = 0;
        for(int i = 0; i < threads.size();i++) {
        	suma_media_threads += (float) ((Mitjana) threads.get(i)).getResultat();
        	System.out.println(threads.get(i).getName()+" : "+(float)((Mitjana) threads.get(i)).getResultat());
        }
        suma_media_threads = suma_media_threads/NUM_THREADS; 
        System.out.println("\n=======================================");
        System.out.println("	MITJANA  AMB  THREADS");
        System.out.println("		"+suma_media_threads);
        
        
        
        
        
        
        int sumatorio = 0;
        for(int i = 0; i < TAMANY_ARRAY;i++) {
        	sumatorio +=lista[i];
        }
        System.out.println("=======================================");
        System.out.println("	MITJANA  SENSE  THREADS");
        System.out.println("		"+(float)sumatorio/TAMANY_ARRAY);
        
        
        
        
        long TempsFi = System.nanoTime(); // CONTADOR FINAL DE PROGRAMA
        //TOTAL TEMPS D'EXECUCIÓ
        long duration = (TempsFi - TempsInici)/CONVERSOR_ns_TO_s;  //divide by 1000000 to get milliseconds.       
        System.out.println("=======================================");
        System.out.println("	TEMPS D'EXECUCIÓ: "+duration+" segons");
        System.out.println("=======================================");
    }
}

