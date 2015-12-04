package business.store;

import models.BusStop;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mdelapenya
 */
public class MockBusStopStore implements Store {

	public MockBusStopStore() {
		mockStore = new ConcurrentHashMap<>();

		String routeId = "L92";

		mockStore.put(
			"P359",
			new BusStop(
				routeId, "P359", "1.00000", 39.881565, -4.027802,
				"Convento, Toledo, España"));
		mockStore.put(
			"P360",
			new BusStop(
				routeId, "P360", "6.00000", 39.879323, -4.030383,
				"Plaza  Holanda, Toledo, España"));
		mockStore.put(
			"P018",
			new BusStop(
				routeId, "P018", "10.00000", 39.877237, -4.033278,
				"Ronda Buenavista 24 (Iglesia), Toledo, España"));
		mockStore.put(
			"P019",
			new BusStop(
				routeId, "P019", "11.00000", 39.876257, -4.035733,
				"Ronda Buenavista 28 (C.Comercial), Toledo, España"));
		mockStore.put(
			"P020",
			new BusStop(
				routeId, "P020", "18.00000", 39.875020, -4.034702,
				"Zaragoza (Colegio), Toledo, España"));
	}

	@Override
	public int size() {
		return mockStore.size();
	}

	@Override
	public boolean isEmpty() {
		return mockStore.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return mockStore.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return mockStore.containsValue(value);
	}

	@Override
	public BusStop get(Object key) {
		return mockStore.get(key);
	}

	@Override
	public BusStop put(String key, BusStop value) {
		return mockStore.put(key, value);
	}

	@Override
	public BusStop remove(Object key) {
		return mockStore.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends BusStop> m) {
		mockStore.putAll(m);
	}

	@Override
	public void clear() {
		mockStore.clear();
	}

	@Override
	public Set<String> keySet() {
		return mockStore.keySet();
	}

	@Override
	public Collection<BusStop> values() {
		return mockStore.values();
	}

	@Override
	public Set<Entry<String, BusStop>> entrySet() {
		return mockStore.entrySet();
	}

	@Override
	public Map<String, BusStop> getStore() {
		return mockStore;
	}

	private Map<String, BusStop> mockStore;

}