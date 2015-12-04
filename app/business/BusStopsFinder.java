package business;

import business.geolocation.GeoLocator;

import business.http.HttpClient;
import business.parser.HTMLParser;
import business.store.BusStopStore;

import models.BusStop;
import models.BusStopResult;
import models.Point;
import models.QueryResult;
import models.ReferenceablePoint;
import models.RouteResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mdelapenya
 */
public class BusStopsFinder implements Finder{

	public QueryResult findRoutes(
		double latitude, double longitude, int radius) {

		ReferenceablePoint currentLocation = new Point(latitude, longitude);

		BusStopStore busStopStore = BusStopStore.getInstance();

		Set<ReferenceablePoint> dataSet = new HashSet<ReferenceablePoint>(
			busStopStore.values());

		List<ReferenceablePoint> closestPoints = GeoLocator.closestPoints(
			currentLocation, dataSet, radius);

		List<BusStopResult> busStopResults = new ArrayList<>();

		if (closestPoints.isEmpty()) {
			return new QueryResult(busStopResults);
		}

		for (ReferenceablePoint closestPoint : closestPoints) {
			BusStop busStop = (BusStop)closestPoint;

			String responseHtml = HttpClient.get(
				busStop.getIdl(), busStop.getIdp(), busStop.getIdo());

			List<RouteResult> routeResults = HTMLParser.parseResponse(
				busStop.getIdl(), busStop.getIdp(), new Date(), responseHtml);

			BusStopResult busStopResult = new BusStopResult(
				busStop, routeResults);

			busStopResults.add(busStopResult);
		}

		return new QueryResult(busStopResults);
	}

}
