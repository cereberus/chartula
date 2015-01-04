package ZADANIA_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class zzz {

    public static void main(String[] args) {

   	 PytanieOdpowiedz[] pytaniaIodpowiedzi = new PytanieOdpowiedz[5];

     	 

       	pytaniaIodpowiedzi[0] = new PytanieOdpowiedz("czesc", "no witam");

       	pytaniaIodpowiedzi[1] = new PytanieOdpowiedz("jak sie masz", "dobrze");

       	pytaniaIodpowiedzi[2] = new PytanieOdpowiedz("hehe", "tak");

       	pytaniaIodpowiedzi[3] = new PytanieOdpowiedz("nie nie nie", "dlaczego tak negatywnie");

       	pytaniaIodpowiedzi[4] = new PytanieOdpowiedz("co tam", "nieeeee");
       	
       	boolean koniec = false;
       	
       	
   	 for (int k = 0; k < 10000; k = k + 1) {
   		 
   		if (!koniec)
			{
   		 String test = CzytajZKlawiatury();
   		 
   		 

   	   	boolean zrozumialePytanie = false;
   	   	
   	    	for (int i=0;i< pytaniaIodpowiedzi.length;i=i+1)
   	    	{

//   			for (int z = 0; z < 10000; z ++) {
   	    		
   	    		
   				
   					
//   				String s = CzytajZKlawiatury();
   				if (test.equals("gg wp")) {
   					koniec = true;
//   					System.out.println(koniec);
   					}
//   				System.out.println("echo" + s);
   			
   				
   				
//   			}

   	    	
   				if (zrozumialePytanie == false) 
   				{
   				 
   					if (test.contains(pytaniaIodpowiedzi[i].pytanie))
   	    		    
   				   	 {
   	    		   	 
   						System.out.println(pytaniaIodpowiedzi[i].odpowiedz);
   					    
   	    			zrozumialePytanie = true ;
   				   	 }

   	        	}
   	                	 
   	    	

   	    	
   	 	}
   				
   	 
   	    	if (zrozumialePytanie==false)
	   	    	{
//   	    		System.out.println(test);
   	    		if (test.equals("gg wp"))
	    			{
	    			System.out.println("GG");
	    			}
   	    		else{
   	    			
   	    		
	   				System.out.println("Nie rozumiem pytania");
   	    		}
	   	    	}
   	    	
   	 }
   	 }
    }
   	 
    public static String CzytajZKlawiatury() {
   	 // TODO Auto-generated method stub
   	 String s = "";
   	 try {
   		 BufferedReader klaw = new BufferedReader(new InputStreamReader(
   				 System.in));

   		 // a Stringi
   		 s = klaw.readLine();
   	 } catch (Exception e) {

   	 }
   	 return s;
    }
}
