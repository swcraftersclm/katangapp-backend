package models;

/**
 * @author mdelapenya
 */
public class RouteResult implements Comparable<RouteResult> {

	public RouteResult(String routeId, long time) {
		this.idl = routeId;
		this.time = time;
	}

	@Override
	public int compareTo(RouteResult that) {
		if (this.time < that.getTime()) {
			return -1;
		}
		else if (this.time > that.time) {
			return 1;
		}

		return 0;
	}

	public String getIdl() {
		return idl;
	}

	public long getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "idl: " + idl + ", time: " + time;
	}

	private String idl;
	private long time;

}