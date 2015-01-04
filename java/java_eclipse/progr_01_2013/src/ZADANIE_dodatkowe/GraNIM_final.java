package ZADANIE_dodatkowe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GraNIM_final {

	public static void main(String[] args) {
		
		int IleZetonowNaStole = 22;
		int IleZetonowMogeMaxZabrac = 2;
		int IleBierzeKomp = 0;
		
// //		Some pregame info about the winner :D A prophet?
//		if (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1) == 1)
//		{
//			System.out.println("Nie ma nawet co grać. Jeśli dobrze pograsz to już wygrałeś.");
//			System.out.println("CONGRATULATIONS!!"); 
//			System.exit(0); 
//		}
		
	
		
// //	The cursed numbers
//			int win = 1;
//		for (int k = 1; k <= IleZetonowNaStole; k = k + IleZetonowMogeMaxZabrac)
//			{
//			
//			
//			if (k==1) System.out.print("liczby przeklęte: "+win +", ");
//			else System.out.print(win +", ");
//			win = win + IleZetonowMogeMaxZabrac + 1;
//			}
	

		System.out.println(""); 
		System.out.println(""); 
		System.out.println("Możesz zabrać maxymalnie "+IleZetonowMogeMaxZabrac+" żetonów." );
		System.out.println("");  
//		System.out.println("Zaczyna komputer");
		
		System.out.println("Zdecyduj kto ma brać jako pierwszy.");
		System.out.println("0 to komputer, 1 to gracz, 2 wybór losowy"); 
		int KtoZaczyna = Integer.parseInt(CzytajZKlawiatury());
		
		while (KtoZaczyna < 0 || KtoZaczyna > 2)
		{
			System.out.println("0 to komputer, 1 to gracz, 2 wybór losowy"); 
			System.out.println("Innych opcji nie ma :) Wprowadź 0 lub 1 lub 2"); 
			KtoZaczyna = Integer.parseInt(CzytajZKlawiatury());
		}
		
		
		if (KtoZaczyna == 2) {KtoZaczyna = (int) Math.floor((Math.random()*2));}
		if (KtoZaczyna == 0) {System.out.println("Zaczyna komputer.");}
		if (KtoZaczyna == 1) {System.out.println("Zaczyna gracz.");}
		
		
		
		
		System.out.println(""); 
		System.out.println("Let the game begin");
		System.out.println("------------------");


///////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@///////////////////	
		if (KtoZaczyna == 1)
		{
			
			if (IleZetonowNaStole <=0)
			{
				System.out.println("CONGRATULATIONS!!"); 
				System.exit(0); 
			}
			
/////////////////////////////////////////////////////////////////////////////////			
			
			System.out.println("Na stole zetonow " + IleZetonowNaStole);
			int r = Integer.parseInt(CzytajZKlawiatury());
			
			
//------ While for keeping the rules of our game				
			
			while (r == 0 || r > IleZetonowMogeMaxZabrac)
			{
				
				if (r == 0)
				{
					System.out.println("Nie oszukuj! Musisz zabrać przynajmniej jeden żeton.");
					System.out.println("Jeszcze raz wprowadź ilość żetonów, które chcesz zabrać.");
					r = Integer.parseInt(CzytajZKlawiatury());
				}
				
				else if (r > IleZetonowMogeMaxZabrac)
				{
					System.out.println("Nie oszukuj! Musisz zabrać przynajmniej 1 żeton lub nie więcej żetonów niż " + IleZetonowMogeMaxZabrac);
					System.out.println("Jeszcze raz wprowadź ilość żetonów, które chcesz zabrać.");
					r = Integer.parseInt(CzytajZKlawiatury());
				}								
			}
			
			System.out.println("Zabierasz " + r);
			IleZetonowNaStole = IleZetonowNaStole-r;
			if (IleZetonowNaStole <=0)
			{
				System.out.println("GAME OVER!!"); 
				System.exit(0); 
			}
			
		}

		
///////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@///////////////////
		
		
//------Let the game begin------------------------------------------------------
		while (IleZetonowNaStole > 0) 
		{
			
			
			System.out.println("Na stole zetonow " + IleZetonowNaStole);
			
			
			if ((IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1)) == 0)
			{
				IleBierzeKomp = IleZetonowMogeMaxZabrac;
//				System.out.println("IleBierzeKomp = IleZetonowMogeMaxZabrac " + IleBierzeKomp + " = " + IleZetonowMogeMaxZabrac);
			}
			
			
			else if (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1) == 1)
			{
				IleBierzeKomp = (int) Math.floor((Math.random()*IleZetonowMogeMaxZabrac)+1);
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
			
/////////////////////////////////////////////////////////////////////////////////			
			
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
			
/////////////////////////////////////////////////////////////////////////////////
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

