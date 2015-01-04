package random;

import java.util.Random;

public class random_nextInt {

	public static void main(String[] args) {
	    Random r = new Random();  
	    //------------------------
	    
	    int random_int = r. nextInt(101);
		int random_int_in_range = r.nextInt(501)+50; 
		System.out.println("random_int: " + random_int);
		System.out.println("random_int_in_range: " + random_int_in_range);
	}

}
