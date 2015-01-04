package ZADANIA_05;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class zadanie_4__ {

	public static void main(String[] args) {

		for (int k = 0; k < 10000; k = k + 1) {
			String s = CzytajZKlawiatury();
			System.out.println("echo" + s);
			if (s.equals("koniec"))
			{
				break;
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