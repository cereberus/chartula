package ZADANIA_04;

public class Zadanie_4_suma {
	  
	 public static int suma(int[] tab) {
	 	int sum = 0;
	 	for (int i=0;i<tab.length;i=i+1){
	 		//System.out.println("elenent tablicy po kolei i: "+ tab[i]);
	 		sum += tab[i];
	 
	 		
	 		
	 	}
	  	return sum;
	}

	  public static void main(String[] args) {
	int[] tab = new int[5];
	tab[0]= 4;
	tab[1]= 2;
	tab[2]= 7;
	tab[3]= 6;
	tab[4]= 1;
	  	System.out.println("suma elementów w tablicy wynosi: "+ suma(tab));
	  	}
	}
