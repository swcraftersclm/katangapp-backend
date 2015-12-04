package business.parser;

import static org.fest.assertions.Assertions.assertThat;

import models.RouteResult;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.Test;

/**
 * @author mdelapenya
 */
public class HTMLParserTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void testParseResponse() throws Exception {
		String html = read("/resources/sample.html");

		Date now = new Date();

		List<RouteResult> routeResults = HTMLParser.parseResponse(
			"L92", "P01", now, html);

		assertThat(routeResults).hasSize(3);

		assertThat(routeResults.get(0).getIdl()).isEqualTo("L92");
		assertThat(routeResults.get(1).getIdl()).isEqualTo("41b");
		assertThat(routeResults.get(2).getIdl()).isEqualTo("L03");
	}

	private String read(String path) throws IOException {
		InputStream is = this.getClass().getResourceAsStream(path);

		temporaryFolder.create();

		File sample = temporaryFolder.newFile();

		FileUtils.copyInputStreamToFile(is, sample);

		return FileUtils.readFileToString(sample);
	}

}