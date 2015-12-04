package business.http;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * @author mdelapenya
 */
public class HttpClientTest {

	@Test
	public void testGet() {
		String idl = "41";
		String idp = "P001";
		String ido = "1.00000";

		String response = HttpClient.get(idl, idp, ido);

		assertThat(response).isNotEmpty();
	}

}