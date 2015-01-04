package grik;

import java.util.ArrayList;

import lejos.nxt.Button;
import lejos.nxt.Sound;
import lejos.robotics.navigation.Pose;
import lejos.util.Delay;

public class PCR_2013 {

	static public tools.Timer timer = new tools.Timer(2 * 60 - 5);

	enum przejazdy {
		PIERWSZY, DRUGI
	}

	enum corobic {
		BRAC, SZKODZIC, NIC
	}

	enum szukane {
		CZERWONE5, NIEBIESKIE10
	}

	static ArrayList<Integer> odsluchy = new ArrayList<Integer>();

	static ArrayList<Integer> wycinek_kolowy(ArrayList<Integer> czego,
			int odkad, int jaki) {
		ArrayList<Integer> wycinek = new ArrayList<Integer>();

		for (int i = odkad; i < jaki; i++) {
			wycinek.add(czego.get(i));
			if (i == (czego.size() - 1))
				break;
		}

		for (int i = 0; wycinek.size() < jaki; i++) {
			wycinek.add(czego.get(i));
			if (i == (czego.size() - 1))
				i = 0;
		}
		return wycinek;

	}

	static void skan() {
		motors.zamnknijPaszcze();
		odsluchy.clear();
		motors.pilot.rotate(360, true);
		while (motors.pilot.isMoving()) {
			odsluchy.add(sensors.ucho.getDistance());
			Delay.msDelay(5);
		}
		System.out.println(odsluchy.size());
	}

	static int gdzieMinimum(ArrayList<Integer> czego) {

		int gdzie = 0;
		int min = czego.get(0);
		for (int i = 1; i < czego.size(); i++) {
			if (czego.get(i) < min) {
				min = czego.get(i);
				gdzie = i;
			}

		}

		return gdzie;
	}

	static int sumaAY(ArrayList<Integer> czego) {

		int suma = czego.get(0);
		for (int i = 1; i < czego.size(); i++) {
			suma += czego.get(i);
		}

		return suma;
	}

	static int najcichszySektor(ArrayList<Integer> czego, int dlug) {

		int gdzie = 0;
		ArrayList<Integer> wycinek = wycinek_kolowy(czego, gdzie, dlug);
		int naj = sumaAY(wycinek);
		for (int i = 1; i < czego.size(); i++) {
			wycinek = wycinek_kolowy(czego, i, dlug);

			if (sumaAY(wycinek) > naj) {
				naj = sumaAY(wycinek);
				gdzie = i;
			}

		}

		return gdzie;
	}

	public static void main(String[] args) throws Exception {
		try {
			timer.setDaemon(true);
			timer.start();
			szukane szukam = szukane.NIEBIESKIE10;

			przejazdy przejazd = przejazdy.PIERWSZY;
			System.out.println("GRIK PCR Krakrobot 2013...");
			System.out.println("Niebieskie lewym czerwone prawym");

			int a = Button.waitForAnyPress();
			if (a == 4)
				szukam = szukane.CZERWONE5;
			System.out.println(szukam);

			System.out.println("Nacisnij duzy baton...");
			Button.waitForAnyPress();

			System.out.println("Pierwszy lewym drugi prawym");

			a = Button.waitForAnyPress();
			if (a == 4)
				przejazd = przejazdy.DRUGI;

			System.out.println("Nacisnij duzy baton...");
			Button.waitForAnyPress();

			corobic robie = corobic.NIC;

			motors.initArm();
			motors.zamnknijPaszcze();
			motors.initNavi();
			motors.pilot.travel(1);
			motors.pilot.rotate(-45);
			for (int i = 0; i < 3; i++) {
				motors.jedzDoLinii();

				motors.pilot.travel(motors.wysuniecie_oczka);
			}

			motors.pilot.setTravelSpeed(10);
			float kat_teraz = motors.pp.getPose().getHeading();
			skan();
			int najciszej = najcichszySektor(odsluchy, odsluchy.size() / 5);

			double kat_ciszy = (najciszej / (double) odsluchy.size() * 360)
					+ kat_teraz+36;

			int mane_moje = 0;

			int i = -1;
			while (true)

			{i++;
				int kat, dystans;

				dystans = cortex.generator.nextInt(30) + 20;
				do {
					kat = cortex.generator.nextInt(360);
				} while (Math.abs(kat - kat_ciszy) > 36);
				
				if ((i<3)&&(mane_moje==0)){
					
					dystans =50;
					kat = (int) (cortex.generator.nextInt(72)+kat_ciszy-36);
				}

				motors.navigator.rotateTo(kat);
				motors.otworzPaszcze();
				motors.pilot.travel(dystans);
				motors.zamnknijPaszcze();

				if (sensors.coMamy()==sensors.sytuacje.BLUE){
					if (szukam==szukane.CZERWONE5) robie=corobic.SZKODZIC;
					if (szukam==szukane.NIEBIESKIE10) robie=corobic.BRAC;
					
				}
				
				if (sensors.coMamy()==sensors.sytuacje.RED){
						if (szukam==szukane.CZERWONE5) robie=corobic.BRAC;
						if (szukam==szukane.NIEBIESKIE10) robie=corobic.SZKODZIC;
						}				
					

				System.out.println(robie);

				if (robie == corobic.NIC) {
					motors.pilot.travel(-1 * dystans);
				}

				if (robie == corobic.BRAC) {
					mane_moje++;
					if (mane_moje == 2) {
						motors.pilot.travel(-1 * dystans);
						tools.koniec();
					}

					else {
						motors.pilot.travel(-1 * dystans);
						motors.navigator.rotateTo(kat_ciszy);
						motors.pilot.travel(15);
						motors.otworzPaszcze();
						motors.pilot.travel(-15);
					}
				}

				if (robie == corobic.SZKODZIC) {
					motors.pilot.travel(50 - dystans);
					motors.otworzPaszcze();
					motors.pilot.travel(-50);
				}
			}
		} catch (Exception e) {
			tools.koniec();
		}

	}
}