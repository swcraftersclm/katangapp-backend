package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author mdelapenya
 */
public class BusStopResult {

	public BusStopResult(BusStop busStop, List<RouteResult> results) {
		this.busStop = busStop;

		this.results = results;
	}

	public BusStop getBusStop() {
		return busStop;
	}

	public List<RouteResult> getResults() {
		return results;
	}

	@JsonProperty("parada")
	private BusStop busStop;

	@JsonProperty("tiempos")
	private List<RouteResult> results;

}
