package models;

/**
 * @author mdelapenya
 */
public interface ReferenceablePoint {

	double getLatitude();

	double getLongitude();

	double distanceTo(ReferenceablePoint point);

}
