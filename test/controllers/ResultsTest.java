package controllers;

import static org.fest.assertions.Assertions.assertThat;

import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentType;
import static play.test.Helpers.status;

import business.store.MockBusStopStore;

import models.BusStop;
import models.Point;
import models.TestPointFactory;

import org.junit.Test;

import play.mvc.Result;
import play.test.WithApplication;

import java.util.Map;

/**
 * @author mdelapenya
 */
public class ResultsTest extends WithApplication {

	@Test
	public void testIndex() {
		Point puertaBisagra = TestPointFactory.getPuertaBisagra();

		String latitude = String.valueOf(puertaBisagra.getLatitude());
		String longitude = String.valueOf(puertaBisagra.getLongitude());
		int radius = 1000;

		Result result = Results.index(latitude, longitude, radius);

		assertThat(status(result)).isEqualTo(OK);
		assertThat(contentType(result)).isEqualTo("application/json");
	}

	@Test
	public void testUnauto() {
		MockBusStopStore mockBusStopStore = new MockBusStopStore();

		for (Map.Entry<String, BusStop> stopEntry :
				mockBusStopStore.entrySet()) {

			BusStop busStop = stopEntry.getValue();

			Result result = Results.unauto(
				busStop.getIdl(), busStop.getIdp(), busStop.getIdo());

			assertThat(status(result)).isEqualTo(OK);
			assertThat(contentType(result)).isEqualTo("text/plain");

			break;
		}

	}

}
