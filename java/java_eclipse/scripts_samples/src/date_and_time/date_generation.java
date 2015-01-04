package date_and_time;

import java.util.GregorianCalendar;
import java.util.Random;

public class date_generation {

	private static GregorianCalendar dataUrodzenia;
	static Random rn = new Random();
	
	
	private static GregorianCalendar stworz_date(){
		int month = rn.nextInt(11) + 1;
		int date = rn.nextInt(30) + 1;
		//System.out.println("dzien" + day + " " + month );
		GregorianCalendar kalendarz = new GregorianCalendar(1993, month  , date);
		kalendarz.set(1993, month, date);
						System.out.println(kalendarz.getTime()); //shows date and time
						System.out.println(kalendarz.get(2)+1); //prints month
						System.out.println(kalendarz.getClass()); //type(kalendarz)
						

	
		return kalendarz;
	}
	
	
	public static void main(String[] args) {
		System.out.println(stworz_date());
		
		

	}

}
