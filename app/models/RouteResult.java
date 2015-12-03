package models;

/**
 * @author mdelapenya
 */
public class RouteResult {

	public RouteResult(String routeId, long time) {
		this.idl = routeId;
		this.time = time;
	}

	public String getIdl() {
		return idl;
	}

	public long getTime() {
		return time;
	}

	private String idl;
	private long time;

}