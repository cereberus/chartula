package grik;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.NXT;
import lejos.nxt.Sound;

public class tools {
	public static class Timer extends Thread { // to służy temu, aby robot nie
												// przekroczył czasu...

		private int time_left = 0;

		public Timer(int time_to_die) {
			time_left = time_to_die;

		}

		// TODO: get time
		public void sztop() {
			time_left = 1000000;

		}

		public void run() {
			while (time_left > 0) {
				try {
					time_left--;

					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}

			koniec();
		}
	}

	public static void doWait(long wait_time) {
		try {
			Thread.sleep(wait_time);
		} catch (Exception e) {
		}
	}

	public static void koniec() {
		LCD.clearDisplay();
		LCD.clear();

		PCR_2013.timer.sztop();
		motors.pilot.stop();
		motors.navigator.stop();
motors.zamnknijPaszcze();
		while (motors.pilot.isMoving()){}
		while (motors.navigator.isMoving()){}
		while (Motor.C.isMoving()){}
		motors.pilot.stop();
		motors.navigator.stop();
		Motor.C.stop();
		Sound.twoBeeps();
		NXT.shutDown();
	}
	
	static String text;
	static byte[] byteText;
	static FileOutputStream fos;
	static File f;

	static void startpliku(String filename) throws FileNotFoundException {
		f = new File(filename);
		fos = new FileOutputStream(f);

	}

	static void krespliku() throws IOException {
		fos.close();
	}

	static byte[] getBytes(String inputText) {
		// Debug Point
		byte[] nameBytes = new byte[inputText.length() + 1];

		for (int i = 0; i < inputText.length(); i++) {
			nameBytes[i] = (byte) inputText.charAt(i);
		}
		nameBytes[inputText.length()] = 0;

		return nameBytes;
	}


	static void appendToFile(String text) throws IOException {
		byteText = getBytes(text);

		// Critic to add a useless character into file
		// byteText.length-1
		for (int i = 0; i < byteText.length - 1; i++) {
			fos.write((char) byteText[i]);
		}
		String koniec = "\n";
		byteText = getBytes(koniec);
		fos.write((char) byteText[0]);
	}

}
