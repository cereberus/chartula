package ZADANIA_03;

public class Zadanie_3__ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a = 7549;
		// jeśli chcesz sprawdzić liczbę np. 1234567 zwyczajnie przypisz ją do "z =" zamiast 7549;
		boolean jestPierwsza=true;
		
		for (int i = 2; i < a; i = i + 1) {
			if(a % i == 0)
			{
				jestPierwsza = false;
			}
		}
		if (jestPierwsza==true)
		{
			System.out.println(a + " JEST LICZBĄ PIERWSZĄ");
		}
		else
		{
			System.out.println(a + " NIE JEST LICZBĄ PIERWSZĄ");
		}

	}

}
