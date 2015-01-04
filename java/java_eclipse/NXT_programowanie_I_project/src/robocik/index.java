package robocik;

import java.util.ArrayList;
import java.util.Random;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.Pose;

public class index {

	/**
	 * 
	 * @author Mikolaj "Jesmasta" Buchwald
	 * @param args
	 * @throws InterruptedException 
	 * 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		motors.initNavi();
		System.out.println("Press any button, please");
		Button.waitForAnyPress();
		System.out.println("I'm ready to proceed");
		
		
		
		while(true){
			
			if (sensors.prawy_palec.isPressed()) {
//				motors.pilot.rotate(90);
				Motor.C.setSpeed(90.0f);
				Motor.C.rotate(-45);	
				System.out.println("i lift up");			
			}
			
//		Thread.sleep(1000);
//			
//			if (sensors.lewy_palec.isPressed()) {
//				Motor.C.setSpeed(90.0f);	
//				int pozycja = Motor.C.getPosition();
//				System.out.println(pozycja);
//				Motor.C.rotateTo(0);
//				System.out.println("put it down!");
//			}
			
		Thread.sleep(1000);
			
			if (sensors.lewy_palec.isPressed()) {
				sensors.ultraDistance();	
			}
			
			
		}
		

	}

}
