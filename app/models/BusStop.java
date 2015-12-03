package models;

/**
 * @author mdelapenya
 */
public class BusStop implements ReferenceablePoint {

	public BusStop(
		String routeId, String stopId, double latitude, double longitude,
		String address) {

		this.address = address;
		this.idl = routeId;
		this.idp = stopId;
		this.point = new Point(latitude, longitude);
	}

	public String getAddress() {
		return address;
	}

	public String getIdl() {
		return idl;
	}

	public String getIdp() {
		return idp;
	}

	@Override
	public double getLatitude() {
		return getPoint().getLatitude();
	}

	@Override
	public double getLongitude() {
		return getPoint().getLongitude();
	}

	public Point getPoint() {
		return point;
	}

	private String idl;

	private String idp;

	private String address;

	private Point point;

}
