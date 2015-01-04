package ZADANIA_03;

public class Zadanie_3_count {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int z = 1234567;
		// jeśli chcesz sprawdzić liczbę 7549 zwyczajnie przypisz ją do "z =" zamiast 1234567;
		int count = 0;
		
		for (int i = 1; i < z; i = i + 1) {
		
		if (z % i == 0) {
			
			count += 1;
			
			}
			
		}
		
		if (count > 2) {
		System.out.println(z + " NIE JEST LICZBĄ PIERWSZĄ");
		}
		else{
		System.out.println(z + " JEST LICZBĄ PIERWSZĄ");
		}
	
	}
}


