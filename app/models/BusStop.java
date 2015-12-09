package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mdelapenya
 */
public class BusStop implements ReferenceablePoint {

	public BusStop(
		String routeId, String stopId, String orderId, double latitude,
		double longitude, String address) {

		this.address = address;
		this.idl = routeId;
		this.ido = orderId;
		this.idp = stopId;
		this.point = new Point(latitude, longitude);
	}

	public double distanceTo(ReferenceablePoint to) {
		return point.distanceTo(to);
	}

	public String getAddress() {
		return address;
	}

	public String getIdl() {
		return idl;
	}

	public String getIdo() {
		return ido;
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

	@Override
	public String toString() {
		return "idl: " + idl + ", idp: " + idp + ", ido: " + ido + ", " +
			point + ", address:" + address;
	}

	private String idl;

	private String ido;

	private String idp;

	@JsonProperty("direccion")
	private String address;

	@JsonIgnore
	private Point point;

}
