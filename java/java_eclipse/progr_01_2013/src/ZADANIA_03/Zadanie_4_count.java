package ZADANIA_03;

public class Zadanie_4_count {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String s = "";
		//int x = 7549;
		int z = 1000;
		int count = 0;
		
		for (int i = 2; i < z; i = i + 1) {
			
			for (int k = 2; k < i+1; k = k + 1) {
		
				if (i % k == 0) {
			
					count += 1;
			
				}
				
				//System.out.println(k + " kakaka");
				//System.out.println(count + " count count");
				
			}
			
			
			if (count < 3) {
				System.out.println(i + " JEST LICZBĄ PIERWSZĄ");
				}
				
			count = 0;
			
		}
		
		
	}
	
}
