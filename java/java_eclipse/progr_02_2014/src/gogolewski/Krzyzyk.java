package gogolewski;
import java.util.Scanner;

public class Krzyzyk {

	static char[][] tab = new char[3][3];
	static char x = 'x';
	static char o = 'o';
	static Scanner k = new Scanner(System.in);

	public static void main(String[] args) {
		int tura = 0;
		System.out.print("wype�nij plansz�:\n");

		for (int i = 0; i < 9; i++) { // gra ma 9 tur
			plansza(); // na pocz�tku tury wy�wietlana jest plansza
			if (tura % 2 == 0) { // zak�adamy �e zaczynamy od x, je�li nr tury
									// jest parzysty
				wprowadzaniex(); // jest tura x
				tura++; // nr tury ro�nie
			} else { // w przeciwnym razie
				wprowadzanieo(); // tura o
				tura++;
			}
		}
		System.out.println("Koniec gry!");
		plansza();
		wynik();
	}

	// poni�ej wszystkie funkcje u�yte w programie
	static boolean sprawdzanie(int a, int b) { // funkcja sprawdzaj�ca czy pole
												// jest wolne
		return tab[a][b] != x && tab[a][b] != o;
	}

	static void wprowadzaniex() {// funkcja dla wprowadzania krzy�yk�w
		int a = 0, b = 0;
		System.out.print("\nKrzy�yk:(podaj wsp�rz�dne x,y(0-2)\n");
		do {
			System.out.print("\nNie na zaj�tym ");
			do {
				a = k.nextInt();
				b = k.nextInt();
			} while (a < 0 || a > 2 || b < 0 || b > 2);// p�tla wprowadzania
														// dzia�a tak d�ugo, a�
														// nie wprowadzimy
														// wsp�rz�dnych pola
														// istniej�cego
		} while (!sprawdzanie(a, b)); // i a� nie wprowadzimy wsp�rz�dnych pola
										// nie zaj�tego
		tab[a][b] = x; // wpisywanie w podanym polu x
	}

	static void wprowadzanieo() { // funkcja dla wprowadzania k�ek
		int a = 0, b = 0;
		System.out.print("\nK�ko:(podaj wsp�rz�dnedne x,y(0-2)\n");
		do {
			System.out.print("\nNie na zaj�tym ");
			do {
				a = k.nextInt();
				b = k.nextInt();
			} while (a < 0 || a > 2 || b < 0 || b > 2); // tak samo jak dla x
		} while (!sprawdzanie(a, b));
		tab[a][b] = o; // wpisywanie o
	}

	static void plansza() { // funkcja wypisuj�ca plansz�
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 2) {
					System.out.print(tab[i][j]);
				} // za ostatnim polem nie ma �cianki
				else {
					System.out.print(tab[i][j] + "|");
				} // za pierwszym i drugim jest
			}
			System.out.println(""); // kolejny wiersz
		}

	}

	static void wynik() {
		if ((tab[0][0] == tab[1][0] && tab[1][0] == tab[2][0] && tab[2][0] == o)
				|| (tab[0][1] == tab[1][1] && tab[1][1] == tab[2][1] && tab[2][1] == o)
				|| (tab[0][2] == tab[1][2] && tab[1][2] == tab[2][2] && tab[2][2] == o)
				|| (tab[0][0] == tab[0][1] && tab[0][1] == tab[0][2] && tab[0][2] == o)
				|| (tab[1][0] == tab[1][1] && tab[1][1] == tab[1][2] && tab[1][2] == o)
				|| (tab[2][0] == tab[2][1] && tab[2][1] == tab[2][2] && tab[2][2] == o)
				|| (tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2] && tab[2][2] == o)
				|| (tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0] && tab[2][0] == o)) {
			System.out.println("Wygra�o k�ko!");
		} else {
			System.out.println("Wygra�� krzy�yk!");
		}
	}
}
