package ZADANIE_dodatkowe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GraNIM_better {

	public static void main(String[] args) {

		
//		I assume that the computer starts picking
		
		int IleZetonowNaStole = 24;
		int IleZetonowMogeMaxZabrac = 2;
		int IleBierzeKomp = 0;
		
//		Some pregame info about the winner :D A prophet?
		if (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1) == 1)
		{
			System.out.println("Nie ma nawet co grać. Jeśli dobrze pograsz to już wygrałeś.");
			System.out.println("CONGRATULATIONS!!"); 
			System.exit(0); 
		}
//	The magic winning variable		
//		int win = (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1));
		
		
		System.out.println("Możesz zabrać maxymalnie "+IleZetonowMogeMaxZabrac+" żetonów." );
		System.out.println("Zaczyna komputer"); 
		System.out.println(""); 
		System.out.println("Let the game begin");
		System.out.println("------------------");

//------Let the game begin------------------------------------------------------
		for (int i = 0; i < 10000; i = i + 1) {
			System.out.println("Na stole zetonow " + IleZetonowNaStole);
			
			
//The loop for the winning algorithm			
//			for (int k = IleZetonowNaStole; k < 10000; k = k + 1)
//			{
//				
//			}
			
			if ((IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1)) == 0)
			{
				IleBierzeKomp = IleZetonowMogeMaxZabrac;
//				System.out.println("IleBierzeKomp = IleZetonowMogeMaxZabrac " + IleBierzeKomp + " = " + IleZetonowMogeMaxZabrac);
			}
			else
			{
				IleBierzeKomp = (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1)) - 1;
//				System.out.println("IleBierzeKomp = IleZetonowMogeMaxZabrac - 1   " + IleBierzeKomp + " = " + (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1)) + "-" + 1);
			}
			
			System.out.println("Komputer zabiera " + IleBierzeKomp);
			IleZetonowNaStole = IleZetonowNaStole-IleBierzeKomp;
		
			
			
	
			
			if (IleZetonowNaStole <=0)
			{
				System.out.println("CONGRATULATIONS!!"); 
				break;
			}
			
			
			
			System.out.println("Na stole zetonow " + IleZetonowNaStole);
			int s = Integer.parseInt(CzytajZKlawiatury());
			
			
//------ While for keeping the rules of our game				
			
			while (s == 0 || s > IleZetonowMogeMaxZabrac)
			{
				
				if (s == 0)
				{
					System.out.println("Nie oszukuj! Musisz zabrać przynajmniej jeden żeton.");
					System.out.println("Jeszcze raz wprowadź ilość żetonów, które chcesz zabrać.");
					s = Integer.parseInt(CzytajZKlawiatury());
				}
				
				else if (s > IleZetonowMogeMaxZabrac)
				{
					System.out.println("Nie oszukuj! Musisz zabrać przynajmniej 1 żeton lub nie więcej żetonów niż " + IleZetonowMogeMaxZabrac);
					System.out.println("Jeszcze raz wprowadź ilość żetonów, które chcesz zabrać.");
					s = Integer.parseInt(CzytajZKlawiatury());
				}
				
				
			}
			
			
			
			
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

