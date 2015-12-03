package business.geolocation;

import models.ReferenceablePoint;
import models.PolarSegment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author mdelapenya
 */
public class GeoLocator {

	public static List<ReferenceablePoint> closestPoints(
		ReferenceablePoint currentLocation, Set<ReferenceablePoint> points,
		int radiusMeters) {

		return closestPoints(currentLocation, points, radiusMeters, 3);
	}

	public static List<ReferenceablePoint> closestPoints(
		ReferenceablePoint currentLocation, Set<ReferenceablePoint> points,
		int radiusMeters, int maxElements) {

		if (radiusMeters == 0) {
			radiusMeters = Integer.MAX_VALUE;
		}

		List<ReferenceablePoint> closestPoints = new ArrayList<>();

		List<PolarSegment> polarSegments = new ArrayList<>();

		// each polar segment will internally store the distance between points

		for (ReferenceablePoint point : points) {
			PolarSegment polarSegment = new PolarSegment(
				currentLocation, point);

			if (polarSegment.getDistance() <= radiusMeters) {
				polarSegments.add(polarSegment);
			}
		}

		// fail fast, avoiding sorting

		if (polarSegments.isEmpty()) {
			return closestPoints;
		}

		// sort polar segments using the distance field

		Collections.sort(polarSegments);

		for (int i = 0; i < maxElements; i++) {
			PolarSegment polarSegment = polarSegments.get(i);

			closestPoints.add(polarSegment.getTo());
		}

		return closestPoints;
	}

}