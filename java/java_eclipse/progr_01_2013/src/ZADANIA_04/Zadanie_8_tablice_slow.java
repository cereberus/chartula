package ZADANIA_04;




public class Zadanie_8_tablice_slow { 
	
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
	   	 
	   	for (int i=0; i< tab.length; i=i+1)
	   	{
 			if ((String) tab[i] == zapytanie) {czyZawiera = true;}

 		}
	   	 
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


