package models;

/**
 * @author mdelapenya
 */
public class PolarSegment implements Comparable<PolarSegment> {

	public PolarSegment(ReferenceablePoint from, ReferenceablePoint to) {
		this.from = from;
		this.to = to;
		this.distance = from.distanceTo(to);
	}

	@Override
	public int compareTo(PolarSegment that) {
		if (distance < that.distance) {
			return -1;
		}
		else if (distance > that.getDistance()) {
			return 1;
		}

		return 0;
	}

	public double getDistance() {
		return distance;
	}

	public ReferenceablePoint getFrom() {
		return from;
	}

	public ReferenceablePoint getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "from: [" + from + "], to: [" + to + "], distance: " + distance;
	}

	private final double distance;
	private final ReferenceablePoint from;
	private final ReferenceablePoint to;

}