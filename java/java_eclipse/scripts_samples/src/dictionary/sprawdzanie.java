package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class sprawdzanie {

	public static void main(String[] args) throws IOException {


		Scanner s = new Scanner(
				new File(
						"C:\\Google Drive\\work\\workspace_new_32\\_paulina\\src\\_dictionary\\dict.txt"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()) {
			list.add(s.next());
		}
		s.close();

//		System.out.println(list.get(3));
//		System.out.println(list);
		// System.out.println("lista dict: "+ (Arrays.toString(list)));
//		System.out.println("");

		String[] slowniczek = new String[list.size()];
		list.toArray(slowniczek);


		String zapytanie = "";

		while (!zapytanie.equals("koniec")) {
			System.out.println("Jeśli wpiszesz \"koniec\" program zakończy się.");
			System.out.println("Wprowadź proszę frazę, której szukasz w słowniku: ");
			zapytanie = CzytajZKlawiatury();
			
			System.out.println("Słowo, którego szukasz: " + "\"zapytanie\"");
			boolean czyZawiera = false;

			for (int i = 0; i < slowniczek.length; i = i + 1) {
				if ((boolean) slowniczek[i].equals(zapytanie)) {
					czyZawiera = true;
				}

			}

			if (czyZawiera) {
				System.out.println("Słowo \"" + zapytanie + "\" jest w słowniku.");
			} else {
				System.out.println("Słowa \"" + zapytanie + "\" nie ma w słowniku.");
			}
			
			System.out.println("---");
			System.out.println("następne zapytanie");
			System.out.println("---");
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
