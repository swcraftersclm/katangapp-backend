package business;

import models.BusStop;
import models.BusStopResult;
import models.QueryResult;
import models.RouteResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdelapenya
 */
public class BusStopsFinder implements Finder{

	public QueryResult findRoutes(
		double latitude, double longitude, int radius) {

		List<BusStopResult> busStopResults = new ArrayList<>();

		for (int i = 1; i <= 2; i++) {

			BusStop busStop = new BusStop(
				"41", "P0" + i, -19.0000-i, 56.787812*i,
				"c/ Jarama " + i + ", Toledo, España");

			List<RouteResult> routeResults = new ArrayList<>();

			for (int j = 1; j < 5; j++) {
				String routeId = "L" + j;

				RouteResult routeResult = new RouteResult(routeId, 1000*j);

				routeResults.add(routeResult);
			}

			BusStopResult busStopResult = new BusStopResult(
				busStop, routeResults);

			busStopResults.add(busStopResult);
		}

		return new QueryResult(busStopResults);
	}

}
