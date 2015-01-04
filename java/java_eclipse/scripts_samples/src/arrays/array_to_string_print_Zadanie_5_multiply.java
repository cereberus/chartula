package arrays;

import java.util.Arrays;

public class array_to_string_print_Zadanie_5_multiply { 
	 public static int[] wymnozTablicePrzez2(int[] tab) 
	 	{
//		 	int[] wynik = new int[tab.length];
		 	int[] wynik = tab.clone();
//		 	System.out.println("lista multi "+ (Arrays.toString(wynik)));
		 		for (int i=0;i< wynik.length; i=i+1){
		 			wynik[i] = wynik[i] * 2;
		 		}
		  	return wynik;
		}
		  public static void main(String[] args) {
		int[] tab = new int[5];
		tab[0]= 4;
		tab[1]= 2;
		tab[2]= 7;
		tab[3]= 6;
		tab[4]= 1;
		int[] wynik = wymnozTablicePrzez2(tab);
		for (int i=0;i< wynik.length; i=i+1){
		  	System.out.println(i+" ty element to "+ wynik[i]);
		  	System.out.println("lista multi: "+ (Arrays.toString(wynik)));
				}
		  	}
		}

