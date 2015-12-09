package models;

/**
 * @author mdelapenya
 */
public interface ReferenceablePoint {

	double distanceTo(ReferenceablePoint point);

	double getLatitude();

	double getLongitude();

}
