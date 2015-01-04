package ZADANIA_04;




public class Zadanie_7_mean { 
	 public static float mean(int[] tab) {
//		 	int[] wynik = new int[tab.length];
		 	float count = 0;
		 	float mean = 0;
	 
		 		for (int i=0;i< tab.length; i=i+1){
		 			count += tab[i];
//		 			System.out.println(count);
		 		}
		 	mean = count / tab.length;
//		 	System.out.println("mean = " + count + " / " + tab.length);
		  	return mean;
		}
		  public static void main(String[] args) {
		int[] tab = new int[5];
		tab[0]= 5;
		tab[1]= 3;
		tab[2]= 4;
		tab[3]= 4;
		tab[4]= 2;
		float mean = mean(tab);
		System.out.println("Średnia ocen wynosi: "+ mean);
		  	}
		}

