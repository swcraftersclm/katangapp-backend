package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author mdelapenya
 */
public class QueryResult {

	public QueryResult(List<BusStopResult> results) {
		this.results = results;
	}

	public List<BusStopResult> getResults() {
		return results;
	}

	@JsonProperty("paradas")
	private List<BusStopResult> results;

}
