package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		
		gpspoints = new GPSPoint[n];
		antall = 0;
		
		//throw new UnsupportedOperationException(TODO.construtor("GPSData"));

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		
		if (antall <= gpspoints.length - 1) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		} else inserted = false;
		
		return inserted;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		// TODO - START
		
		if (antall <= gpspoints.length - 1) {
			gpspoint = new GPSPoint(
					GPSDataConverter.toSeconds(time),
					Double.parseDouble(latitude),
					Double.parseDouble(longitude),
					Double.parseDouble(elevation)
			);
			gpspoints[antall] = gpspoint;
			antall++;
			return true;
		} else return false;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		
		for (int i = 0; i < gpspoints.length; i++) {
			System.out.println(gpspoints[i]);
		}
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
