package business.geolocation;

import static org.fest.assertions.Assertions.assertThat;

import models.BusStop;
import models.Point;
import models.ReferenceablePoint;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author mdelapenya
 */
public class GeoLocatorTest {

	@Test
	public void testClosest() {
		ReferenceablePoint current = new Point(39.0, -4.075);

		Set<ReferenceablePoint> points = new HashSet<>();

		for (int i = 1; i <= 20; i++) {
			Random r = new Random();

			double latitude = RANGE_MIN_LAT +
				(RANGE_MAX_LAT - RANGE_MIN_LAT) * r.nextDouble();

			double longitude = RANGE_MIN_LONG +
				(RANGE_MAX_LONG - RANGE_MIN_LONG) * r.nextDouble();

			points.add(
				new BusStop(
					"L9" + i, "P0" + i, latitude, longitude, "Home" + i));
		}

		List<ReferenceablePoint> referenceablePoints = GeoLocator.closestPoints(
			current, points, 0);

		assertThat(referenceablePoints).hasSize(3);
	}

	private static final double RANGE_MAX_LAT = 90;
	private static final double RANGE_MIN_LAT = -90;
	private static final double RANGE_MAX_LONG = 180;
	private static final double RANGE_MIN_LONG = -180;

}