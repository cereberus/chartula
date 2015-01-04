package ZADANIA_02;

public class zadanie_4 {
	   public static void main(String[] args) {
			String s="ala ma ";
			String p= "psy";
			String r= " kotów";
			
			System.out.println(s + "1 kota");
			System.out.println(s + "2 " + p);
			System.out.println(s + "3 " + p);
			System.out.println(s + "4 " + p);
			
			
		   	for (int i=5;i<15;i=i+1)
		   	{
		            
					s = "ala ma " + i + r;
					
		           System.out.println(s);
		   	}
		   }
		}
