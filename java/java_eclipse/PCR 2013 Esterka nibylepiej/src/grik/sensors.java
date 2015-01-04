package grik;

import java.util.ArrayList;

import grik.sieci.klocek_pcr_nn;
import grik.sieci.pole_pcr_nn;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;

import lejos.nxt.SensorPort;
import lejos.nxt.ColorSensor.Color;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;

public class sensors {

	
	
	static ColorSensor oko = new ColorSensor(SensorPort.S1);
	
	static UltrasonicSensor ucho = new UltrasonicSensor(SensorPort.S2);
	
	static TouchSensor palec = new TouchSensor(SensorPort.S3);
	
	
	static Color barwy = new Color(0, 0, 0, 0, 0);
	static klocek_pcr_nn siec_klocek = new klocek_pcr_nn();
	static pole_pcr_nn siec_pole = new pole_pcr_nn();
	
	enum sytuacje {RED,BLUE,NOPE}

	static boolean czyLinia() {
		barwy = oko.getColor();
		double red = (barwy.getRed()) / 255.0;
		double green = (barwy.getGreen()) / 255.0;
		double blue = (barwy.getBlue()) / 255.0;
		double background = (barwy.getBackground()) / 255.0;

		double[] odczyty = new double[] { red, green, blue, background };

		int wyszlo = siec_pole.getClass(odczyty);

		if (wyszlo == 0)
			return false;
		else
			return true;

	}
	
	static sytuacje coMamy() {
		barwy = oko.getColor();
		double red = (barwy.getRed()) / 255.0;
		double green = (barwy.getGreen()) / 255.0;
		double blue = (barwy.getBlue()) / 255.0;
		double background = (barwy.getBackground()) / 255.0;

		double[] odczyty = new double[] { red, green, blue, background };

		int wyszlo = siec_klocek.getClass(odczyty);

	if (wyszlo==1) return sytuacje.BLUE;
	if (wyszlo==2) return sytuacje.RED; //taak?
	return sytuacje.NOPE;

	}
	
	static int jakiklocek() {
		barwy = oko.getColor();
		double red = (barwy.getRed()) / 255.0;
		double green = (barwy.getGreen()) / 255.0;
		double blue = (barwy.getBlue()) / 255.0;
		double background = (barwy.getBackground()) / 255.0;

		double[] odczyty = new double[] { red, green, blue, background };

		int wyszlo = klocek_pcr_nn.getClass(odczyty);

		if (wyszlo == 0)
			return 0; //zaden!
		
		if (wyszlo == 1)
			return 1; //czerwony!
		
		else
			return 2; //niebieski!
		
		


	}
	
	static int odczytUcho(){
		
		while (odsluchy.size()<3){odsluchy.add(255);} 
		odsluchy.add(ucho.getDistance());
		odsluchy.remove(0);
		//System.out.println(odsluchy);
		
		for (int i=0;i<3;i++){
			if ((odsluchy.get(i)>uchoProg) ||  (odsluchy.get(i)<minObiekt))return 255;}
		int kandydat=odsluchy.get(1);
		
		if ((kandydat<maxLapka) && (kandydat>minLapka))kandydat=255;
		Delay.msDelay(100);
		
		//System.out.println(kandydat);
		return kandydat; //srodkowy		
		
		}
	

static ArrayList<Integer> zOka()

{
	ArrayList<Integer> lista=new ArrayList<Integer>();
	barwy=oko.getColor();
	lista.add(barwy.getRed());
	lista.add(barwy.getGreen());
	lista.add(barwy.getBlue());
	lista.add(barwy.getBackground());
	
	return lista;
	
}
}
