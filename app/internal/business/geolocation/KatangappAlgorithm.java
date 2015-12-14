package internal.business.geolocation;

import business.ClosestPointsAlgorithm;
import business.UnreferenceablePointException;

import models.ReferenceablePoint;
import models.PolarSegment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author mdelapenya
 */
public class KatangappAlgorithm implements ClosestPointsAlgorithm {

	public static final int DEFAULT_MAX_ELEMENTS = 3;

	public List<ReferenceablePoint> closestPoints(
		ReferenceablePoint currentLocation, Set<ReferenceablePoint> points,
		int radiusMeters) {

		return closestPoints(
			currentLocation, points, radiusMeters, DEFAULT_MAX_ELEMENTS);
	}

	public List<ReferenceablePoint> closestPoints(
		ReferenceablePoint currentLocation, Set<ReferenceablePoint> points,
		int radiusMeters, int maxElements) {

		List<ReferenceablePoint> closestPoints = new ArrayList<>();

		List<PolarSegment> polarSegments = new ArrayList<>();

		// each polar segment will internally store the distance between points

		for (ReferenceablePoint point : points) {
			PolarSegment polarSegment;

			try {
				polarSegment = new PolarSegment(currentLocation, point);
			}
			catch (UnreferenceablePointException e) {
				continue;
			}

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