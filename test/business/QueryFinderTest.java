package business;

import static org.fest.assertions.Assertions.assertThat;

import business.store.MockBusStopStore;

import models.BusStopResult;
import models.QueryResult;

import java.util.List;

import org.junit.Test;

import org.mockito.Mockito;

import play.test.WithApplication;

/**
 * @author mdelapenya
 */
public class QueryFinderTest extends WithApplication{

	@Test
	public void testFindRoutes() {
		Finder busStopFinder = Mockito.spy(new BusStopsFinder());

		double latitude = 39.862658;
		double longitude = -4.025088;
		int radius = 2000;

		mockStore(busStopFinder);

		QueryResult queryResult = busStopFinder.findRoutes(
			latitude, longitude, radius);

		List<BusStopResult> results = queryResult.getResults();

		assertThat(results).hasSize(3);
	}

	@Test
	public void testFindRoutesWithoutRadiusShouldNotReturnRoutes() {
		Finder busStopFinder = Mockito.spy(new BusStopsFinder());

		double latitude = 39.862658;
		double longitude = -4.025088;
		int radius = 0;

		mockStore(busStopFinder);

		QueryResult queryResult = busStopFinder.findRoutes(
			latitude, longitude, radius);

		List<BusStopResult> results = queryResult.getResults();

		assertThat(results).hasSize(0);
	}

	private void mockStore(Finder finder) {
		Mockito.when(finder.getStore()).thenReturn(new MockBusStopStore());
	}

}