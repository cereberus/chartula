package hexagon;

import sieci.nn_kolor_pola;
import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.Color;

/**
 * Simple class that provides sensor methods.
 *
 * @author Piotr "Nex" Janus, Patryk "pp106" Piesiak
 * @version 0.2
 */
public class sensors {

    static ColorSensor ks = new ColorSensor(SensorPort.S1);
    
	static UltrasonicSensor ucho = new UltrasonicSensor(SensorPort.S2);

	public static final TouchSensor pomiar = new TouchSensor(SensorPort.S2);
	public static TouchSensor palec = new TouchSensor(SensorPort.S3);

    
    static Color kolor;
    private static double red;
    private static double green;
    private static double blue;
    static nn_kolor_pola siec_kolor = new nn_kolor_pola();  //-1: nic, 0:czarny, 1:pole
    
    
    public static String odczytyKoloru() {
        kolor = ks.getColor();

        return (kolor.getRed() + " " + kolor.getGreen() + " " + kolor.getBlue());
    }

    public static int jakiKolorPola() { //jak w neurosorterze, siecią.

        kolor = ks.getColor();
        red = (double) kolor.getRed() / 255.0;
        green = (double) kolor.getGreen() / 255.0;
        blue = (double) kolor.getBlue() / 255.0;
        double[] wektor = new double[]{red, green, blue};
        int odczyt  = siec_kolor.getClass(wektor);
        return (odczyt);
    }


}
