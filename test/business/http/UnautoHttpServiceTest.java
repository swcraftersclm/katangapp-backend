package business.http;

import static org.fest.assertions.Assertions.assertThat;

import business.mocks.MockHttpService;

import org.junit.Test;

import play.test.WithApplication;

/**
 * @author mdelapenya
 */
public class UnautoHttpServiceTest extends WithApplication {

	@Test
	public void testGet() throws Exception {
		String idl = "41";
		String idp = "P001";
		String ido = "1.00000";

		final HttpService httpService = MockHttpService.mockUnautoHttpService();

		String response = httpService.get(idl, idp, ido);

		assertThat(response).isNotEmpty();
	}

}
