package ZADANIE_dodatkowe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GraNIM__ {

	public static void main(String[] args) {

		int IleZetonowNaStole = 10;
		
		for (int i = 0; i < 10000; i = i + 1) {
			System.out.println("Na stole zetonow " + IleZetonowNaStole);
			if (IleZetonowNaStole == 3)
			{
				int ilebiore = 2;
				System.out.println("Komputer zabiera " + ilebiore);
				IleZetonowNaStole = IleZetonowNaStole-ilebiore;
			}
			else if (IleZetonowNaStole == 4)
			{
				int ilebiore = 1;
				System.out.println("Komputer zabiera " + ilebiore);
				IleZetonowNaStole = IleZetonowNaStole-ilebiore;
			}
			else if (IleZetonowNaStole == 2)
			{
				int ilebiore = 1;
				System.out.println("Komputer zabiera " + ilebiore);
				IleZetonowNaStole = IleZetonowNaStole-ilebiore;
			}
			else
			{
			int ilebiore = 1;
			System.out.println("Komputer zabiera " + ilebiore);
			IleZetonowNaStole = IleZetonowNaStole-ilebiore;
			}
			if (IleZetonowNaStole <=0)
			{
				System.out.println("CONGRATULATIONS!!"); 
				break;
			}
			System.out.println("Na stole zetonow " + IleZetonowNaStole);
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

