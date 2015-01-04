package ZADANIA_04;

public class Zadanie_2_max {
	  
	 public static int maksimum(int[] tab) {
	 	int max = tab[0];
	 	for (int i=0;i<tab.length;i=i+1){
	 		//System.out.println("elenent tablicy po kolei i: "+ tab[i]);
	 		if (tab[i] > max){
	 		//System.out.println("elenent większy i: "+ tab[i]);
	 		max = tab[i];
	 		
	 		}
	 	}
	  	return max;
	}

	  public static void main(String[] args) {
	int[] tab = new int[5];
	tab[0]= -4;
	tab[1]= -2;
	tab[2]= -7;
	tab[3]= -6;
	tab[4]= -1;
	  	System.out.println("maksimum w tablicy wynosi: "+ maksimum(tab));
	  	}
	}
