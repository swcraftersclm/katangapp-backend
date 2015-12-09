package business.http;

import static org.fest.assertions.Assertions.assertThat;

import business.IOTestUtils;

import java.io.IOException;

import org.junit.Test;

import org.mockito.Mockito;

import play.test.WithApplication;


/**
 * @author mdelapenya
 */
public class HttpClientTest extends WithApplication {

	@Test
	public void testGet() throws Exception {
		String idl = "41";
		String idp = "P001";
		String ido = "1.00000";

		HttpClient httpClient = Mockito.spy(new HttpClient());

		mockHttpService(httpClient);

		String response = httpClient.get(idl, idp, ido);

		assertThat(response).isNotEmpty();
	}

	private void mockHttpService(HttpClient client) throws IOException {
		String mockResponse = IOTestUtils.readFile("sample-P001.html");

		Mockito.when(
			client.get(
				Mockito.anyString(), Mockito.anyString(), Mockito.anyString())
		).thenReturn(mockResponse);
	}

}