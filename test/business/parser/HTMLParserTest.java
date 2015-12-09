package business.parser;

import static org.fest.assertions.Assertions.assertThat;

import business.IOTestUtils;

import models.RouteResult;

import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * @author mdelapenya
 */
public class HTMLParserTest {

	@Test
	public void testParseResponse() throws Exception {
		String html = IOTestUtils.readFile("sample.html");

		Date now = new Date();

		List<RouteResult> routeResults = HTMLParser.parseResponse(
			"L92", "P01", now, html);

		assertThat(routeResults).hasSize(3);

		assertThat(routeResults.get(0).getIdl()).isEqualTo("L92");
		assertThat(routeResults.get(1).getIdl()).isEqualTo("41b");
		assertThat(routeResults.get(2).getIdl()).isEqualTo("L03");
	}

	@Test
	public void testParseResponseForP001() throws Exception {
		String html = IOTestUtils.readFile("sample-P001.html");

		Date now = new Date();

		List<RouteResult> routeResults = HTMLParser.parseResponse(
			"41", "P001", now, html);

		assertThat(routeResults).hasSize(31);

		assertThat(routeResults.get(0).getIdl()).isEqualTo("41");
		assertThat(routeResults.get(1).getIdl()).isEqualTo("41b");
		assertThat(routeResults.get(2).getIdl()).isEqualTo("41b");
		assertThat(routeResults.get(3).getIdl()).isEqualTo("42");
		assertThat(routeResults.get(4).getIdl()).isEqualTo("42");
		assertThat(routeResults.get(5).getIdl()).isEqualTo("L01");
		assertThat(routeResults.get(6).getIdl()).isEqualTo("L01");
		assertThat(routeResults.get(7).getIdl()).isEqualTo("L03");
		assertThat(routeResults.get(8).getIdl()).isEqualTo("L03");
		assertThat(routeResults.get(9).getIdl()).isEqualTo("L05");
		assertThat(routeResults.get(10).getIdl()).isEqualTo("L05");
		assertThat(routeResults.get(11).getIdl()).isEqualTo("L10");
		assertThat(routeResults.get(12).getIdl()).isEqualTo("L10");
		assertThat(routeResults.get(13).getIdl()).isEqualTo("L10C2");
		assertThat(routeResults.get(14).getIdl()).isEqualTo("L11");
		assertThat(routeResults.get(15).getIdl()).isEqualTo("L11");
		assertThat(routeResults.get(16).getIdl()).isEqualTo("L12");
		assertThat(routeResults.get(17).getIdl()).isEqualTo("L5d");
		assertThat(routeResults.get(18).getIdl()).isEqualTo("L5d");
		assertThat(routeResults.get(19).getIdl()).isEqualTo("L61");
		assertThat(routeResults.get(20).getIdl()).isEqualTo("L61");
		assertThat(routeResults.get(21).getIdl()).isEqualTo("L62");
		assertThat(routeResults.get(22).getIdl()).isEqualTo("L62");
		assertThat(routeResults.get(23).getIdl()).isEqualTo("L71");
		assertThat(routeResults.get(24).getIdl()).isEqualTo("L71");
		assertThat(routeResults.get(25).getIdl()).isEqualTo("L72");
		assertThat(routeResults.get(26).getIdl()).isEqualTo("L72");
		assertThat(routeResults.get(27).getIdl()).isEqualTo("L72b");
		assertThat(routeResults.get(28).getIdl()).isEqualTo("L72b");
		assertThat(routeResults.get(29).getIdl()).isEqualTo("L94");
		assertThat(routeResults.get(30).getIdl()).isEqualTo("L94");
	}

}