package ZADANIA_04;



public class Zadanie_3_min__use_max_in_min {
	
	 public static int minimum(int[] tab) {
	 	
	 	int max = 0;
	 	for (int i=0;i<tab.length;i=i+1){
	 		//System.out.println("elenent tablicy po kolei i: "+ tab[i]);
	 		if (tab[i] > max){
	 		//System.out.println("elenent większy i: "+ tab[i]);
	 		max = tab[i];
	 		}
	 	}
	 		
	 	int min = max;	
	 	for (int k=0;k<tab.length;k=k+1){
	 		//System.out.println("elenent tablicy po kolei i: "+ tab[i]);
	 		if (tab[k] < min){
	 		//System.out.println("elenent mniejszy i: "+ tab[i]);
	 		min = tab[k];
	 		
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
