package ZADANIA_04;

//import java.util.Arrays;

public class Zadanie_6_reversed { 
	 public static int[] reverse(int[] tab) {
//		 	int[] wynik = new int[tab.length];
		 	int[] wynik = tab.clone();
//		 	System.out.println("lista wynik "+ (Arrays.toString(wynik)));		 
		 		for (int i=0;i< wynik.length; i=i+1){
		 			wynik[i] = tab[tab.length - i -1];
//		 			System.out.println(i + " -ta pozycja zamieniana na "+ (tab.length - i -1)+ " czyli " +tab[tab.length - i -1]);
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
		int[] wynik = reverse(tab);
		for (int i=0;i< wynik.length; i=i+1){
		  	System.out.println(i+" ty element to "+ wynik[i]);
				}
		  	}
		}

