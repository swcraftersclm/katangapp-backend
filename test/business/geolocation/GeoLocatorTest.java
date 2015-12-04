package business.geolocation;

import static org.fest.assertions.Assertions.assertThat;

import business.store.MockBusStopStore;

import models.BusStop;
import models.Point;
import models.ReferenceablePoint;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author mdelapenya
 */
public class GeoLocatorTest {

	@Test
	public void testClosest() {
		double latitude = 39.862658;
		double longitude = -4.025088;

		ReferenceablePoint current = new Point(latitude, longitude);

		MockBusStopStore mockBusStopStore = new MockBusStopStore();

		Map<String, BusStop> store = mockBusStopStore.getStore();

		Set<ReferenceablePoint> points = new HashSet<ReferenceablePoint>(store.values());

		List<ReferenceablePoint> referenceablePoints = GeoLocator.closestPoints(
			current, points, 2000);

		assertThat(referenceablePoints).hasSize(3);
	}

}