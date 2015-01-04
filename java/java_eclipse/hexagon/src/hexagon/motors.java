package hexagon;

import lejos.nxt.*;
import java.util.*;

import lejos.robotics.navigation.*;
import lejos.robotics.localization.*;

import lejos.robotics.RegulatedMotor;

/**
 * Simple class that provides motor methods.
 *
 * @author Piotr "Nex" Janus, Patryk "pp106" Piesiak
 * @version 0.2cal
 *
 * używamy sieci:
 *
 * jednej do skanu koloru pola pod nami nn_kolor_pola drugiej do odczytu cyfry
 *
 */
public class motors {
//dużo zmiennych początkowych, na razie nie wszystkiegfo używamy

    public static int def_speed = 16;
    public static int push_speed = 16; //TODO:sprawdzic, czy dziala.
    private static final int turn_speed = 40; //predkosc skretu jest w stopniach , jazdy w sekindach.
    private static final float wheelDiameter = 3.0f;
    private static final float trackWidth = 17.0f; //gasienice po skosie
    private static final RegulatedMotor leftMotor = Motor.B;
    private static final RegulatedMotor rightMotor = Motor.A;
    private static final boolean reverse = true;
    private static final float startx = 0.0f;
    private static final float starty = 0.0f;
    private static final float startkaft = 0.0f;
    public static final float pole_bok = 20.0f;
    public static final float line_width = 2.0f;
    public static final float step = pole_bok + line_width;
    public static final DifferentialPilot pilot = new DifferentialPilot(wheelDiameter, trackWidth, leftMotor, rightMotor, reverse);
    public static Navigator navigator = new Navigator(pilot);
    public static OdometryPoseProvider pp = new OdometryPoseProvider(pilot);
	private static float startkat=0;
    public static Pose pose = new Pose(startx, starty, startkat);
    //TODO: tę korekte ogarnąć  
//    private static double now_error=0;
//    private static double recent_error=0;
//    private static int kat_korekta = 0;
//    
//    private static boolean blad_w_prawo=false;

    public static double odleglosc(float x1, float y1, float x2, float y2) { //z pitagorasa, oczywiście.
        return Math.abs(Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2))));
    }

    public static void initNavi() {
        pilot.addMoveListener(pp);
        navigator.setPoseProvider(pp);
        pp.setPose(pose); //pilot służy kierowaniu, navigator pilnuje koordynatów, pp obsługuje pozycję bieżaca; wiązemy te obiekty tu
        pilot.setTravelSpeed(def_speed);
        pilot.setRotateSpeed(turn_speed);

    }

    public static double cofajDoLinii() {

        pilot.setTravelSpeed(push_speed);

        Pose start = pp.getPose();

        pilot.backward();
        while (sensors.jakiKolorPola() != 0) {
        }
        pilot.stop();

        Pose end = pp.getPose();

        float x1 = start.getX();
        float y1 = start.getY();
        float x2 = end.getX();
        float y2 = end.getY();
        return odleglosc(x1, y1, x2, y2);


    }

    public static double jedzDoLinii() {
        pilot.setTravelSpeed(push_speed);

        Pose start = pp.getPose();

        pilot.forward();
        while (sensors.jakiKolorPola() != 0) {
        }
        pilot.stop();

        Pose end = pp.getPose();

        float x1 = start.getX();
        float y1 = start.getY();
        float x2 = end.getX();
        float y2 = end.getY();
        return odleglosc(x1, y1, x2, y2);
    }
}
