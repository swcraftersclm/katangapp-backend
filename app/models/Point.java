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

	public double distanceTo(ReferenceablePoint to) {
		double latitude1 = this.getLatitude();
		double longitude1 = this.getLongitude();

		double latitude2 = to.getLatitude();
		double longitude2 = to.getLongitude();

		double earthRadiusMeters = 6371000;

		double latitudeRadians = Math.toRadians(latitude2 - latitude1);

		double longitudeRadians = Math.toRadians(longitude2 - longitude1);

		double a = Math.sin(latitudeRadians / 2) *
			Math.sin(latitudeRadians / 2) +
			Math.cos(Math.toRadians(latitude1)) *
			Math.cos(Math.toRadians(latitude2)) *
			Math.sin(longitudeRadians / 2) *
			Math.sin(longitudeRadians / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		return (earthRadiusMeters * c);
	}

	private double latitude;
	private double longitude;

}
