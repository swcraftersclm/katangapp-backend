import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.*;

import static play.mvc.Results.*;

/**
 * @author mdelapenya
 */
public class Global extends GlobalSettings {

	public Promise<Result> onBadRequest(RequestHeader request, String error) {
		return Promise.<Result>pure(createBadRequest());
	}

	public Promise<Result> onHandlerNotFound(RequestHeader request) {
		return Promise.<Result>pure(createBadRequest());
	}

	private Results.Status createBadRequest() {
		return badRequest("Don't try to hack the URI!");
	}

}