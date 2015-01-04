package ZADANIA_04;


public class Zadanie_3_min_infinity {
	
	 public static int minimum(int[] tab) {
	 	int min = (int) Double.POSITIVE_INFINITY;
//	 	int a= Integer.MAX_VALUE;
	 	for (int i=0;i<tab.length;i=i+1){
	 		//System.out.println("elenent tablicy po kolei i: "+ tab[i]);
	 		if (tab[i] < min){
	 		//System.out.println("elenent mniejszy i: "+ tab[i]);
	 		min = tab[i];
	 		
	 		}
	 	}
	  	return min;
	}

	  public static void main(String[] args) {
	int[] tab = new int[5];
	tab[0]= 4;
	tab[1]= 2;
	tab[2]= 7;
	tab[3]= 6;
	tab[4]= 1;
	  	System.out.println("minimum w tablicy wynosi: "+ minimum(tab));
	  	}
	}
