package business.mocks;

import org.mockito.Mockito;
import play.mvc.Http;

import java.util.Collections;
import java.util.Map;

/**
 * @author mdelapenya
 */
public class MockResultsController {

	public static void mockRequest() {
		Long id = 2L;

		play.api.mvc.RequestHeader header = Mockito.mock(
			play.api.mvc.RequestHeader.class);

		Http.Request request = Mockito.mock(Http.Request.class);

		Map<String, String> flashData = Collections.emptyMap();
		Map<String, Object> argData = Collections.emptyMap();

		Http.Context context = new Http.Context(
			id, header, request, flashData, flashData, argData);

		Http.Context.current.set(context);
	}

}
