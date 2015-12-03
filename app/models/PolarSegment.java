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

	public double getDistance() {
		return distance;
	}

	public ReferenceablePoint getTo() {
		return to;
	}

	public ReferenceablePoint getFrom() {
		return from;
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

	private final double distance;
	private final ReferenceablePoint from;
	private final ReferenceablePoint to;

}