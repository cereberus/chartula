package ZADANIA_03;

public class Zadanie_5_gwiazdka_iteracyjnie {
	public static int silnia(int n) {
		// TODO Auto-generated method stub
		//int c = 1;
		int silnia = 1;

		for (int i=1;i<=n;i=i+1)
		{
			silnia = silnia*i;
		}
		return silnia;
		
	}

		  public static void main(String[] args) {
		double e=0;
		   	for (int i=0;i<20;i=i+1)
		   		{
		e = e +(double)1/(double)silnia(i); 
		//System.out.println("silnia " +(double)silnia(i));
		  	 	}
		  	System.out.println(e+" to jest e");
		  	}
		}