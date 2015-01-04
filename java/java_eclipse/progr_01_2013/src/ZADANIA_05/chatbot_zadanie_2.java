package ZADANIA_05;

public class chatbot_zadanie_2 {

	public static void main(String[] args) {
		PytanieOdpowiedz[] pytaniaIodpowiedzi = new PytanieOdpowiedz[5];

		pytaniaIodpowiedzi[0] = new PytanieOdpowiedz("czesc", "no witam");
		pytaniaIodpowiedzi[1] = new PytanieOdpowiedz("jaki jest dzisiaj dzień", "a bo ja wiem?");
		pytaniaIodpowiedzi[2] = new PytanieOdpowiedz("hehe", "haha");
		pytaniaIodpowiedzi[3] = new PytanieOdpowiedz("nie tak", "tylko tak potrafię");
		pytaniaIodpowiedzi[4] = new PytanieOdpowiedz("jak sie masz", "całkiem nieźle");


		String test = "czesc";
		
		boolean zrozumialePytanie = false;
		
		for (int i = 0; i < pytaniaIodpowiedzi.length; i = i + 1) {
			if (test.contains(pytaniaIodpowiedzi[i].pytanie)) {
				System.out.println(pytaniaIodpowiedzi[i].odpowiedz);
				zrozumialePytanie = true;
				
			} 
		}
		
		if (!zrozumialePytanie){
				System.out.println("Nie rozumiem pytania");
		}
	}
}

// boolean czyZawiera =false;
//
// if (czyZawiera)
// {
// for (int i=0;i< pytaniaIodpowiedzi.length;i=i+1)
// {
// if (test.contains(pytaniaIodpowiedzi[i].pytanie))
// {
// System.out.println(pytaniaIodpowiedzi[i].odpowiedz);
// }
//
// }
// }
// else{
// System.out.println("nie rozumiem pytania");
// }
// }
// }

