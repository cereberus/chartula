package hexagon;

import java.util.ArrayList;
import java.util.Random;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.Pose;

public class majn {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		System.out.println("hej hej hej");
//		Button.waitForAnyPress();
//		Sound.beepSequence();
//		
//		motors.initNavi();
//		
//		while(true){
//			double odl = motors.jedzDoLinii();
//			System.out.println(odl);
//			Sound.beep();
//			Button.waitForAnyPress();	
		
		motors.initNavi();
		Button.waitForAnyPress();
		System.out.println("Are you ready for the rumble?!!!");
		double korekta=12.0;
		Random generator = new Random();
		
		ArrayList punkty=new ArrayList<Pose>();
		
		Pose poz1;
		Pose poz2;
		while(true){
			
			if (sensors.palec.isPressed()) {
//				motors.pilot.rotate(90);
				Motor.C.setSpeed(90.0f);
				Motor.C.rotate(-45);	
				System.out.println("i rotate");
				
			}
			
			Thread.sleep(1000);
			
			if (sensors.pomiar.isPressed()) {
				Motor.C.setSpeed(90.0f);	
				int pozycja = Motor.C.getPosition();
				System.out.println(pozycja);
				Motor.C.rotateTo(0);				
				
			}
			
			
			
//			motors.jedzDoLinii();
//			
//			poz1=motors.pp.getPose();
//			
//			punkty.add(poz1);
//			motors.pilot.rotate(180);
//			motors.jedzDoLinii();
//			poz2=motors.pp.getPose();
//			float x1=poz1.getX();
//			float x2=poz2.getX();
//			float y1=poz1.getY();
//			float y2=poz2.getY();
//			float x=(x2+x1)/2;
//			float y=(y2+y1)/2;
//			
//			motors.navigator.goTo(x,y);
//			
//			while (motors.pilot.isMoving()){}
//			
//			double przejazd = motors.odleglosc(x1, y1, x2, y2)+(korekta*2.0);
//			System.out.println(przejazd);
//			if (przejazd>130.0) break;
//			
//			double kat_obrotu = (generator.nextDouble() *360)-180;
//			
//			motors.pilot.rotate(kat_obrotu);
			
			

			
		}
		
//		Sound.beepSequenceUp();
//		Button.waitForAnyPress();
		

	}

}
