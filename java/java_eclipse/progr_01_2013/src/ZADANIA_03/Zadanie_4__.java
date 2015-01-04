package ZADANIA_03;

public class Zadanie_4__ {
	public static void main(String[] args) {
		
		//int a=1234567;
		int z=1000;
		
		for (int a = 2; a < z; a = a + 1) {
		boolean jestPierwsza=true;
		
		
			
		
		for (int i = 2; i < a; i = i + 1) {
			if(a%i == 0)
			{
				jestPierwsza = false;
			}
		}
		if (jestPierwsza==true)
		{
			System.out.println(a + " JEST LICZBĄ PIERWSZĄ");
		}
		
	}
}
}
