package ZADANIA_03;

public class Zadanie_1_elseif  {
	public static void main(String[] args) {
		for (int i = 0; i < 400; i = i + 1) {
			if (i % 2 == 0 && i != 300) {
				System.out.println(i + " jest parzyste");
			}	
			
			else if (i == 300) {
				System.out.println(i + " NIEPARZYSTA:)");
			}
			
			
			else {
				System.out.println(i + " jest nieparzyste");
			}
		}
	}
}
