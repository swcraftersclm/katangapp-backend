package models;

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

	private List<BusStopResult> results;

}
