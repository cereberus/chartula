package gogolewski;
//package sortowanie;

public class Wstawianie {

	public static void SortowaniePrzezWstawianie(int[] wejscie) {

		for (int i = 1; i < wejscie.length; i = i + 1) {

			int liczba = wejscie[i];

			int j = i;

			pokazTablice(wejscie);	
			
			
			while ((j > 0) && (wejscie[j - 1] > liczba)) {

				wejscie[j] = wejscie[j - 1];
				
				
				j = j - 1;

			}
			wejscie[j] = liczba;
			
		}
	}

	public static void pokazTablice(int[] wejscie) {

		for (int x : wejscie)
			System.out.print(x + " ");

		System.out.println();
	}

	public static void main(String[] args) {

		int[] tablica = { 5, 3, 2, 5, 6, 1, 0 };

		pokazTablice(tablica);

		SortowaniePrzezWstawianie(tablica);

		pokazTablice(tablica);
	}
}