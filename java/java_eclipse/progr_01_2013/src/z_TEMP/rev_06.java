package z_TEMP;
import java.awt.List;
import java.util.Arrays;
import java.util.Collections;


public class rev_06 {

		public static int[] reverse(int[] tab) {
	//	 	int[] wynik = new int[tab.length];
		 	int[] reversed = tab.clone();
		 	System.out.println("lista reversed"+ (Arrays.toString(reversed)));
		 	
		 	for (int i = 0; i < reversed.length / 2; i++) {
		 		 
		 		}
		    
		  	return reversed;
		}
		
	
	   public static void main(String[] args) {
		   int[] tab = new int[5];
		   tab[0]= 4;
		   tab[1]= 2;
		   tab[2]= 7;
		   tab[3]= 6;
		   tab[4]= 1;
		   System.out.println(" dlugosc listy "+ (tab.length));
		   System.out.println("lista "+ (Arrays.toString(tab)));
		   System.out.println("");


		   System.out.println("lista reversed "+  (reverse(tab)));

		   
		   
		   int[] a = new int[]{1,2,3,4,5};
		   int[] b = tab.clone();

		   
		   System.out.println("lista a "+ (Arrays.toString(a)));
		   System.out.println("lista b "+ (Arrays.toString(b)));
		   
//		   int[] tygrys = null;
//		   tygrys[0]= 14;
//		   tygrys[1]= 4;
//		   tygrys[2]= 3;
//		   tygrys[3]= 8;
//		   tygrys[4]= 2;
//		   System.out.println("lista "+ (Arrays.toString(tygrys)));
			}
}