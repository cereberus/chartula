package ZADANIA_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class zzz_chatbot_complete {

	public static void main(String[] args) {
		PytanieOdpowiedz[] pytaniaIodpowiedzi = new PytanieOdpowiedz[5];

		pytaniaIodpowiedzi[0] = new PytanieOdpowiedz("czesc", "no witam");
		pytaniaIodpowiedzi[1] = new PytanieOdpowiedz("jaki jest dzisiaj dzień", "a bo ja wiem?");
		pytaniaIodpowiedzi[2] = new PytanieOdpowiedz("hehe", "haha");
		pytaniaIodpowiedzi[3] = new PytanieOdpowiedz("nie tak", "tylko tak potrafię");
		pytaniaIodpowiedzi[4] = new PytanieOdpowiedz("jak sie masz", "całkiem nieźle");


		
	
		
		
		boolean zrozumialePytanie = false;
		boolean jest_pytanie = false;
		
		while (jest_pytanie)
			
		for (int i = 0; i < pytaniaIodpowiedzi.length; i = i + 1) {
			questioning();
			if (question.contains(pytaniaIodpowiedzi[i].pytanie)) {
				System.out.println(pytaniaIodpowiedzi[i].odpowiedz);
				zrozumialePytanie = true;
				jest_pytanie = true;
				
			} 
		}
		
		if (!zrozumialePytanie){
				System.out.println("Nie rozumiem pytania");
		}
	}



public static void questioning() {
	boolean koniec = false;
	for (int k = 0; k < 10000; k = k + 1) {
		
		if (!koniec)
		{
		String question = CzytajZKlawiatury();
		if (question.equals("koniec")) {
			koniec = true;
			System.out.println(koniec);}
		System.out.println("echo" + question);

		}
	}
}

public static String CzytajZKlawiatury() {
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
