package gogolewski;
//package sortowanie;

public class babelkowe {

	public static void main(String[] arg) {

		int i, j, tmp;
		int[] tablica = new int[9];

		tablica[0] = 12;
		tablica[1] = 12;
		tablica[2] = 50;
		tablica[3] = 1;
		tablica[4] = 110;
		tablica[5] = 9;
		tablica[6] = 17;
		tablica[7] = 123;
		tablica[8] = 4;
		
	for (i = 0; i <= 7; i++){
			for (j = 0; j <= 7; j++)
				if (tablica[j] > tablica[j + 1]) {
					tmp = tablica[j];
					tablica[j] = tablica[j + 1];
					tablica[j + 1] = tmp;
				}
			
			for (int k = 0; k <= 8; k++)
				System.out.println(tablica[k]);
			System.out.println(" ");
			}
		for (i = 0; i <= 8; i++)
			System.out.println(tablica[i]);

	}

}