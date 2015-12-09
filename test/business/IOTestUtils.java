package business;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author mdelapenya
 */
public class IOTestUtils {

	public static String readFile(String filePath) throws IOException {
		URL resource = IOTestUtils.class.getResource("/");

		Path path = Paths.get(resource.getFile() + filePath);

		return new String(Files.readAllBytes(path), Charset.forName("UTF-8"));
	}

}