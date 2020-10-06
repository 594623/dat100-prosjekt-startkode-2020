package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		
		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		
		// TODO - START
		double[] latitudes = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] longitudes = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		
		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		double phi_1 = Math.toRadians(latitude1);
		double phi_2 = Math.toRadians(latitude2);
		double delta_phi = phi_2 - phi_1;
		double lambda_1 = Math.toRadians(longitude1);
		double lambda_2 = Math.toRadians(longitude2);
		double delta_lambda = lambda_2 - lambda_1;
		double a = Math.pow(Math.sin(delta_phi / 2),2) + Math.cos(phi_1) * Math.cos(phi_2) * Math.pow(Math.sin(delta_lambda / 2),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		d = R * c;
		
		return d;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		speed = (distance(gpspoint1, gpspoint2) / secs) * 3.6;
		
		return speed;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr = "  ";
		String TIMESEP = ":";

		// TODO - START

		int hr, min, sec;
		hr = secs / 60 / 60;
		min = (secs / 60) % 60;
		sec = secs % 60;
		
		timestr += twoDigits(hr) + TIMESEP + twoDigits(min) + TIMESEP + twoDigits(sec);
				
		//timestr.format("{0}" + TIMESEP + "{1}" + TIMESEP + "{2}", hr, min, sec);
		
		return timestr;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	
	private static String twoDigits(int num) {
		String s = "";
		
		if (num / 10 != 0) {
			s += num;
		} else if (num == 0) {
			s = "00";
		} else {
			s = "0" + num;
		}
		
		return s;
	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = "";
		
		String output = "";

		// TODO - START
		
		str += (double) Math.round(d * 100) / 100;
		
		for(int i = 0; i < 10 - str.length(); i++) {
			output += " ";
		}
		
		output += str;
		
		return output;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
