package gogolewski;
//package grA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class nim {

	public static void main(String[] args) {

		int IleZetonowNaStole = 10;
		for (int i = 0; i < 10000; i = i + 1) {
			System.out.println("Na stole zetonow " + IleZetonowNaStole);
			int ilebiore = 2;
			if (IleZetonowNaStole ==2){
				ilebiore = 1;}
			System.out.println("Komputer zabiera " + ilebiore);
			IleZetonowNaStole = IleZetonowNaStole-ilebiore;
			System.out.println("Na stole zetonow " + IleZetonowNaStole);
			System.out.println("Wybierz liczbe zetonow");
			int s = Integer.parseInt(CzytajZKlawiatury());
			System.out.println("Zabierasz " + s);
			IleZetonowNaStole = IleZetonowNaStole-s;
			if (IleZetonowNaStole <=0)
			{
				System.out.println("GAME OVER!!"); 
				break;
			}
		}
	}

	public static String CzytajZKlawiatury() {
		// TODO Auto-generated method stub
		String s = "";
		try {
			BufferedReader klaw = new BufferedReader(new InputStreamReader(
					System.in));

			// a Stringi
			s = klaw.readLine();
		} catch (Exception e) {

		}
		return s;
	}

}
