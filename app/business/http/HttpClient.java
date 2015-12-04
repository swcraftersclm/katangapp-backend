package business.http;

import java.text.MessageFormat;

import play.libs.ws.*;
import play.libs.F.Function;
import play.libs.F.Promise;

/**
 * @author mdelapenya
 */
public class HttpClient {

	public static String get(String idl, String idp, String ido) {
		String url = MessageFormat.format(ENDPOINT, idl, idp, ido);

		Promise<String> documentPromise = WS.url(url).get().map(
			new Function<WSResponse, String>() {

				public String apply(WSResponse response) {
					byte[] bytes = response.asByteArray();

					return new String(bytes);
				}

			}
		);

		return documentPromise.get(5000);
	}

	private static final String ENDPOINT =
		"http://unauto.twa.es/code/getparadas.php?idl={0}&idp={1}&ido={2}";

}
