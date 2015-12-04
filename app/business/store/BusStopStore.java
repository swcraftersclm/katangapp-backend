package business.store;

import models.BusStop;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mdelapenya
 */
public final class BusStopStore implements Map<String, BusStop> {

	public static BusStopStore getInstance() {
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

	private BusStopStore() {
		store = new ConcurrentHashMap<>();
	}

	private Map<String, BusStop> getStore() {
		return store;
	}

	private static BusStopStore instance;
	private static Map<String, BusStop> store;

}