package ZADANIA_04;

import java.util.Arrays;




public class Zadanie_8__prim { 
	
	public static void main(String[] args) {
	   	 String[] tab = new String[6];
	   	 
	   	 tab[0]= "ala";
	   	 tab[1]= "ma";
	   	 tab[2]= "ala";
	   	 tab[3]= "i";
	   	 tab[4]= "psa";
	   	 tab[5]= "itp";
	   	 
	   	 String zapytanie="kota";
	   	 boolean czyZawiera = false;
	   	 
	   	 //TODO - kod do napisania
	   	 
	   	if (Arrays.asList(tab).contains(zapytanie)) {czyZawiera=true;}
	   	 
	   	 if(czyZawiera)
	   	 {
	   		 System.out.println("słowo "+zapytanie+" jest w słowniku");
	   	 }
	   	 else
	   	 {
	   		 System.out.println("słowa "+zapytanie+" nie ma w słowniku");
	   	 }
	    }
	}


