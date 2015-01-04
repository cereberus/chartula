package ZADANIA_05;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class pegadogia {

	
	
    public static void main(String[] args) {
    	
    	boolean koniec = false;
    	
    	
   		 for (int k = 0; k < 10000; k = k + 1) {
   			 
   			if (!koniec)
   			{
   				

   		 String s = CzytajZKlawiatury();
   		if (s.equals("koniec")) {
				koniec = true;
   		    }
   			
   		Odpowiedz(s);
   	 }
}
    }

    
    public static void Odpowiedz(String pytanie)
    {
   	 PytanieOdpowiedz[] pytaniaIodpowiedzi = new PytanieOdpowiedz[5];
   	 pytaniaIodpowiedzi[0] = new PytanieOdpowiedz("czesc", "witam", "no witam");
   	 pytaniaIodpowiedzi[1] = new PytanieOdpowiedz("jak", "encepence", "dobrze");
   	 pytaniaIodpowiedzi[2] = new PytanieOdpowiedz("lubisz?", "jakataka", "tak");
   	 pytaniaIodpowiedzi[3] = new PytanieOdpowiedz("obiad", "kolacja", "pyry");
   	 pytaniaIodpowiedzi[4] = new PytanieOdpowiedz("who", "jaki kram",  "I am the doctor");
   	 
   	 String test = pytanie;
   	 
   	 boolean zrozumialePytanie = false;
   	 for (int i = 0; i < pytaniaIodpowiedzi.length; i = i + 1)
   	 {
   		 if (zrozumialePytanie == false)
   		 {
   			 if (test.contains(pytaniaIodpowiedzi[i].pytanie))
   			 {
   				 System.out.println(pytaniaIodpowiedzi[i].odpowiedz);

   				 zrozumialePytanie = true;
   			 }
   		 }
   	 }
   	 if (zrozumialePytanie == false)
   	 {
   		 System.out.println("Nie rozumiem pytania");
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
