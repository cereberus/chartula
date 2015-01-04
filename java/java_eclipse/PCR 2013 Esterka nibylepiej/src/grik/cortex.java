package grik;



import java.util.ArrayList;
import java.util.Random;

public class cortex {


	public static Random generator = new Random();
	static double[] milimetry = { 0, 2, 4, 9, 12, 17, 26, 32, 42, 51, 61, 71,
		84, 88, 100, 112, 121, 129, 132 };

static double MiliToKat(double mili) {
	if (mili < 0)
		return 0.0;
	if (mili > 135)
		return -90.0;
	double mniejsza = 0.0;
	double wieksza = 0.0;
	int i = 0;
	for (i = 0; i < 19; i++) {
		if (milimetry[i] <= mili)
			mniejsza = i;
		else
			break;

	}

	for (i = 0; i < 19; i++) {
		if (milimetry[i] >= mili) {
			wieksza = i;
			break;
		}

	}

	return ((wieksza + mniejsza) / 2.0) * -5.0;

}

static double KatToMili(double kat)

{

	if (kat < -90)
		return 135.0;
	if (kat > 0)
		return 0.0;

	return (milimetry[(int) kat / -5]);

}
}
