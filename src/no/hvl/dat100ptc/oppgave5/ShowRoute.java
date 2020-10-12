package no.hvl.dat100ptc.oppgave5;

import static javax.swing.JOptionPane.showInputDialog;

import java.util.Scanner;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		double input = 0;
		boolean success = false;
		do {
			try {
				Scanner scan = new Scanner(showInputDialog("Enter your weight: "));
				input = (double) Math.round(scan.nextDouble() * 10) / 10;
				success = true;
			} catch (Exception e) {
				success = false;
			}
		} while (success == false);
		
		
		showStatistics(input);
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon));

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		// TODO - START
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		ystep = MAPYSIZE / (Math.abs(maxlat - minlat));
		
		//Map size / difference of maxlon & minlon
		
		return ystep;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		double xstep = xstep();
		double ystep = ystep();
		
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double minlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		
		setColor(76,187,23);
		
		int prevx = 0, prevy = 0;
		
		for (int i = 0; i < gpspoints.length; i++) {
			double xMinDiff = gpspoints[i].getLongitude() - minlon;
			double yMinDiff = gpspoints[i].getLatitude() - minlat;
			
			int xCoord = (int) (xMinDiff * xstep) + MARGIN;
			int yCoord = (int)(-yMinDiff * ystep) + MARGIN;
			
			fillCircle(xCoord, yCoord, 3);
			
			if (i > 0) {
				drawLine(prevx, prevy, xCoord, yCoord);
			}
			
			prevx = xCoord;
			prevy = yCoord;
			
		}
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public void showStatistics(double weight) {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
				
		String[] strings = {
				"Total Time     : " + GPSUtils.formatTime(gpscomputer.totalTime()),
				"Total distance : " + Math.round(gpscomputer.totalDistance() / 10.0) / 100.0 + " km",
				"Total elevation: " + Math.round(gpscomputer.totalElevation() * 100) / 100.0 + " m",
				"Max speed      : " + Math.round(gpscomputer.maxSpeed() * 100) / 100.0 + " km/t",
				"Average speed  : " + Math.round(gpscomputer.averageSpeed() * 100) / 100.0 + " km/t",
				"Energy         : " + Math.round(gpscomputer.totalKcal(weight) * 100) / 100.0 + " kcal"
		};
		
		for (int i = 0; i < strings.length; i++) {
			drawString(strings[i], MARGIN, MARGIN + TEXTDISTANCE * i);
		}
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT;
	}

}
