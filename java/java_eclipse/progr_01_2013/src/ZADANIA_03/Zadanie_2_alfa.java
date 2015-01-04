package ZADANIA_03;

public class Zadanie_2_alfa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int z = 1234;
		
		for (int i = 1; i < 1235; i = i + 1)
		if (z % i == 0) {
			System.out.println(i + "  jest dzielnikiem liczby " + z);
		}

	}

}
