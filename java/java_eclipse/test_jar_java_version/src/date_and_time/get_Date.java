package date_and_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.ArrayList;


public class get_Date {

	public static void main(String[] args) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp );

	}

}
