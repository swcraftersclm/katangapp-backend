package business.mocks;

import business.BusStopsFinder;
import business.Finder;
import org.mockito.Mockito;

/**
 * @author mdelapenya
 */
public class MockBusStopsFinder {

	public static Finder mockFinder() {
		Finder finder = Mockito.spy(new BusStopsFinder());

		Mockito.when(finder.getStore()).thenReturn(new MockBusStopStore());

		return finder;
	}

}
