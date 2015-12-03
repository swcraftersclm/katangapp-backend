package models;

/**
 * @author mdelapenya
 */
public class Point implements ReferenceablePoint {

	public Point(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public double getLatitude() {
		return latitude;
	}
	@Override
	public double getLongitude() {
		return longitude;
	}

	private double latitude;
	private double longitude;

}
