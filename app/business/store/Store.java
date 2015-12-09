package business.store;

import models.BusStop;

import java.util.Map;

/**
 * @author mdelapenya
 */
public interface Store extends Map<String, BusStop> {

	Map<String, BusStop> getStore();

}
