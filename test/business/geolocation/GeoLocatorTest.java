package business.geolocation;

import static org.fest.assertions.Assertions.assertThat;

import business.store.MockBusStopStore;

import models.BusStop;
import models.ReferenceablePoint;
import models.TestPointFactory;

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
		ReferenceablePoint current = TestPointFactory.getPuertaBisagra();

		MockBusStopStore mockBusStopStore = new MockBusStopStore();

		Map<String, BusStop> store = mockBusStopStore.getStore();

		Set<ReferenceablePoint> points = new HashSet<ReferenceablePoint>(store.values());

		List<ReferenceablePoint> referenceablePoints = GeoLocator.closestPoints(
			current, points, 2000);

		assertThat(referenceablePoints).hasSize(3);
	}

}