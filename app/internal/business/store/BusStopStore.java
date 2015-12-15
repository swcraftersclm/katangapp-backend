package internal.business.store;

import business.store.JsonStore;
import business.store.Store;

import models.BusStop;
import models.Route;
import models.json.BusStopDeserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mdelapenya
 */
public final class BusStopStore implements Store {

	public static Store getInstance() {
		if (instance == null) {
			instance = new BusStopStore();
		}

		return instance;
	}

	@Override
	public int size() {
		return getInstance().getStore().size();
	}

	@Override
	public boolean isEmpty() {
		return getInstance().getStore().isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return getInstance().getStore().containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return getInstance().getStore().containsValue(value);
	}

	@Override
	public BusStop get(Object key) {
		return getInstance().getStore().get(key);
	}

	@Override
	public BusStop put(String key, BusStop value) {
		return getInstance().getStore().put(key, value);
	}

	@Override
	public BusStop remove(Object key) {
		return getInstance().getStore().remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends BusStop> m) {
		getInstance().getStore().putAll(m);
	}

	@Override
	public void clear() {
		getInstance().getStore().clear();
	}

	@Override
	public Set<String> keySet() {
		return getInstance().getStore().keySet();
	}

	@Override
	public Collection<BusStop> values() {
		return getInstance().getStore().values();
	}

	@Override
	public Set<Entry<String, BusStop>> entrySet() {
		return getInstance().getStore().entrySet();
	}

	public Map<String, BusStop> getStore() {
		return busStopStore;
	}

	private BusStopStore() {
		busStopStore = new ConcurrentHashMap<>();

		populateRoutesAndBusStops();
		populateBusStopCoordinates();
	}

	private void populateBusStopCoordinates() {
		JsonStore busStopsJsonStore = new BusStopsJsonStore();

		final JsonNode busStops = busStopsJsonStore.getJson();

		for (JsonNode busStopsArray : busStops) {
			ObjectMapper mapper = new ObjectMapper();

			SimpleModule module = new SimpleModule();

			module.addDeserializer(BusStop.class, new BusStopDeserializer());

			mapper.registerModule(module);

			try {
				BusStop[] busStopModels = mapper.treeToValue(
					busStopsArray, BusStop[].class);

				for (BusStop busStop : busStopModels) {
					// update lat long from the bus stop

					BusStop storedBusStop = busStopStore.get(busStop.getId());

					storedBusStop.setCoordinates(
						busStop.getLatitude(), busStop.getLongitude());
				}
			}
			catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	private void populateRoutesAndBusStops() {
		JsonStore routesJsonStore = new RoutesJsonStore();

		final JsonNode routes = routesJsonStore.getJson();

		for (JsonNode routesArray : routes) {
			ObjectMapper mapper = new ObjectMapper();

			try {
				Route[] routeModels = mapper.treeToValue(
					routesArray, Route[].class);

				for (Route route : routeModels) {
					final List<BusStop> busStops = route.getBusStops();

					for (BusStop busStop : busStops) {
						busStop.setRouteId(route.getId());

						// add the bus stop to the Store

						busStopStore.put(busStop.getId(), busStop);
					}
				}
			}
			catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	private static Store instance;
	private static Map<String, BusStop> busStopStore;

}
