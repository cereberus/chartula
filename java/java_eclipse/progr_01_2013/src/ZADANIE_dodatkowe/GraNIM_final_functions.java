package ZADANIE_dodatkowe;

import java.io.BufferedReader;
import java.io.InputStreamReader;




public class GraNIM_final_functions {
	
	public static int IleZetonowNaStole = 22;
	public static int IleZetonowMogeMaxZabrac = 2;
	public static int IleBierzeKomp = 0;
	public static int KtoZaczyna = 0;
	
	
	public static void main(String[] args) {

		
	
		
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

		
//Decision time. Who starts the comedy
		System.out.println("Zdecyduj kto ma brać jako pierwszy.");
		System.out.println("0 to komputer, 1 to gracz, 2 wybór losowy"); 
		int KtoZaczyna = Integer.parseInt(CzytajZKlawiatury());


//In case someone tries to cheat. Reminder
		while (KtoZaczyna < 0 || KtoZaczyna > 2)
		{
			System.out.println("0 to komputer, 1 to gracz, 2 wybór losowy"); 
			System.out.println("Innych opcji nie ma :) Wprowadź 0 lub 1 lub 2"); 
			KtoZaczyna = Integer.parseInt(CzytajZKlawiatury());
		}
		
//Numbers interpretations		
		if (KtoZaczyna == 2) {KtoZaczyna = (int) Math.floor((Math.random()*2));}
		if (KtoZaczyna == 0) {System.out.println("Zaczyna komputer.");}
		if (KtoZaczyna == 1) {System.out.println("Zaczyna gracz.");}
		
		
		
		
		System.out.println(""); 
		System.out.println("Let the game begin");
		System.out.println("------------------");


		if (KtoZaczyna == 1)
		{
		Player();
		}
		
		
//------Let the game begin------------------------------------------------------
		while (IleZetonowNaStole > 0) 
		{
			
			
		
			Computer();
			
	
			
			Player();
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
	
	
	public static void Player() 
{
///////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@///////////////////	

	
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
	



///////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@///////////////////
}
	
	public static void Computer()
	{
		System.out.println("Na stole zetonow " + IleZetonowNaStole);
		
		
		if ((IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1)) == 0)
		{
			IleBierzeKomp = IleZetonowMogeMaxZabrac;
//			System.out.println("IleBierzeKomp = IleZetonowMogeMaxZabrac " + IleBierzeKomp + " = " + IleZetonowMogeMaxZabrac);
		}
		
		
		else if (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1) == 1)
		{
			IleBierzeKomp = (int) Math.floor((Math.random()*IleZetonowMogeMaxZabrac)+1);
		}
		
		else
		{
			IleBierzeKomp = (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1)) - 1;
//			System.out.println("IleBierzeKomp = IleZetonowMogeMaxZabrac - 1   " + IleBierzeKomp + " = " + (IleZetonowNaStole % (IleZetonowMogeMaxZabrac +1)) + "-" + 1);
		}
		
		System.out.println("Komputer zabiera " + IleBierzeKomp);
		IleZetonowNaStole = IleZetonowNaStole-IleBierzeKomp;
	
	
	}

}

//Acta est fabula, plaudite!	