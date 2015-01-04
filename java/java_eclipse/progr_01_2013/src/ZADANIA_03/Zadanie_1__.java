package ZADANIA_03;

public class Zadanie_1__  {
	public static void main(String[] args) {
		for (int i = 0; i < 400; i = i + 1) {
			if (i % 2 == 0) {
				if (i==300)
				{
					  System.out.println(i + " NIEPARZYSTA :)");
				}
				else
				{
				  System.out.println(i + " jest parzyste");
				}
			} 
			else {
				System.out.println(i + " jest nieparzyste");
			}
		}
	}
}
