package ZADANIA_05;

public class zadanie_3 {

	public static void main(String[] args) {
		PytanieOdpowiedz[] pytaniaIodpowiedzi = new PytanieOdpowiedz[5];

		pytaniaIodpowiedzi[0] = new PytanieOdpowiedz("czesc", "no witam");
		pytaniaIodpowiedzi[1] = new PytanieOdpowiedz("jaki jest dzisiaj dzień", "a bo ja wiem?");
		pytaniaIodpowiedzi[2] = new PytanieOdpowiedz("hehe", "haha");
		pytaniaIodpowiedzi[3] = new PytanieOdpowiedz("nie tak", "tylko tak potrafię");
		pytaniaIodpowiedzi[4] = new PytanieOdpowiedz("jak sie masz", "całkiem nieźle");


		String test = "czesc";
		
		
		for (int i = 0; i < pytaniaIodpowiedzi.length; i = i + 1) {
			
			String jednaOdpowiedz = "tylko jedna odpowiedź";
			pytaniaIodpowiedzi[i] = new PytanieOdpowiedz(pytaniaIodpowiedzi[i].pytanie, jednaOdpowiedz);	
			
			} 
		
		
//		for (int i = 0; i < pytaniaIodpowiedzi.length; i = i + 1) {
//			System.out.println(pytaniaIodpowiedzi[i].odpowiedz);	
//			
//			} 
		
		
		for (int i = 0; i < pytaniaIodpowiedzi.length; i = i + 1) {
			if (test.contains(pytaniaIodpowiedzi[i].pytanie)) {
				System.out.println(pytaniaIodpowiedzi[i].odpowiedz);
			
			} 
		}
		
	}
}


