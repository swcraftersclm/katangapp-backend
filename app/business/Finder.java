package business;

import business.store.Store;

import models.QueryResult;

/**
 * @author mdelapenya
 */
public interface Finder {

	QueryResult findRoutes(double latitude, double longitude, int radius);

	Store getStore();

}
