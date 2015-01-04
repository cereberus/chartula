package ZADANIA_05;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class zadanie_4_bez_break {

	public static void main(String[] args) {

		boolean koniec = false;
		
		for (int k = 0; k < 10000; k = k + 1) {
			
			if (!koniec)
			{
			String s = CzytajZKlawiatury();
			if (s.equals("koniec")) {
				koniec = true;
				System.out.println(koniec);}
			System.out.println("echo" + s);
		
			
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