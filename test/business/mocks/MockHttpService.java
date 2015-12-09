package business.mocks;

import business.IOTestUtils;
import business.http.HttpService;
import business.http.UnautoHttpService;

import org.mockito.Mockito;

import java.io.IOException;

/**
 * @author mdelapenya
 */
public class MockHttpService {

	public static HttpService mockUnautoHttpService() throws IOException {
		final HttpService spy = Mockito.spy(new UnautoHttpService());

		String mockResponse = IOTestUtils.readFile("sample-P001.html");

		Mockito.when(
			spy.get(
				Mockito.anyString(), Mockito.anyString(), Mockito.anyString())
		).thenReturn(mockResponse);

		return spy;
	}

}
