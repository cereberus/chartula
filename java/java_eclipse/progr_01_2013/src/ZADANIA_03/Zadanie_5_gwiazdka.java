package ZADANIA_03;

public class Zadanie_5_gwiazdka {
	  public static int silnia(int n) {
		  	int zwroc = 0;
		  	int step = 0;
		  	
		 	if (n==0) return 1;
		 	step =  silnia(n-1);
		 	System.out.println("pierwsze n: " +n);
		 	zwroc = step*n;
		 	System.out.println(n);
		 	return zwroc;
		}

		  public static void main(String[] args) {
//		double e=0;
//		   	for (int i=0;i<7;i=i+1)
//		   		{
//		e = e +(double)1/(double)silnia(i); 
//		//System.out.println("silnia " +(double)silnia(i));
//		  	 	}
		  	System.out.println(silnia(4));
		  	}
		}