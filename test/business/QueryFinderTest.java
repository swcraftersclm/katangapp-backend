package business;

import static org.fest.assertions.Assertions.assertThat;

import business.geolocation.GeoLocator;
import business.mocks.MockBusStopsFinder;

import models.BusStopResult;
import models.Point;
import models.QueryResult;
import models.TestPointFactory;

import java.util.List;

import org.junit.Test;

import play.test.WithApplication;

/**
 * @author mdelapenya
 */
public class QueryFinderTest extends WithApplication{

	@Test
	public void testFindRoutes() {
		Finder busStopFinder = MockBusStopsFinder.mockFinder();

		Point puertaBisagra = TestPointFactory.getPuertaBisagra();
		int radius = 2000;

		QueryResult queryResult = busStopFinder.findRoutes(
			puertaBisagra.getLatitude(), puertaBisagra.getLongitude(), radius);

		List<BusStopResult> results = queryResult.getResults();

		assertThat(results).hasSize(GeoLocator.DEFAULT_MAX_ELEMENTS);
	}

	@Test
	public void testFindRoutesWithoutRadiusShouldNotReturnRoutes() {
		Finder busStopFinder = MockBusStopsFinder.mockFinder();

		Point puertaBisagra = TestPointFactory.getPuertaBisagra();
		int radius = 0;

		QueryResult queryResult = busStopFinder.findRoutes(
			puertaBisagra.getLatitude(), puertaBisagra.getLongitude(), radius);

		List<BusStopResult> results = queryResult.getResults();

		assertThat(results).hasSize(0);
	}

}
