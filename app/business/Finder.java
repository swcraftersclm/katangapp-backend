package business;

import models.QueryResult;

/**
 * @author mdelapenya
 */
public interface Finder {

	QueryResult findRoutes(double latitude, double longitude, int radius);

}
