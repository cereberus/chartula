package sorting;

import java.util.Arrays;

public class bubble_sort {

	public static int[] sorter(int[] tab) {

		int n = tab.length;
		int swaping = 0;

		while (n > 1) {

			for (int i = 0; i < tab.length - 1; i++) {
				if (tab[i] > tab[i + 1]) {
					swaping = tab[i];
					tab[i] = tab[i + 1];
					tab[i + 1] = swaping;
				}
			}

			// pokazuje kroki sortowania, mozna zakomentowac
			System.out.println("lista do posortowania "
					+ (Arrays.toString(tab)));
			System.out.println("sortuje...");

			n = n - 1;

		}

		return tab;

	}

	public static void main(String[] args) {

		//definiuje liste
		int[] lista = new int[5];
		lista[0] = 4;
		lista[1] = 2;
		lista[2] = 7;
		lista[3] = 6;
		lista[4] = 1;

		//printuje liste oryginalna
		System.out.println("lista do posortowania " + (Arrays.toString(lista)));

		

		System.out.println("lista do posortowania "
				+ (Arrays.toString(sorter(lista))));


	}

}
