package models;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * @author mdelapenya
 */
public class RouteResultTest {

	@Test
	public void testCompareShouldBeEquals() {
		RouteResult one = new RouteResult("", 1000);
		RouteResult two = new RouteResult("", 1000);

		assertThat(one.compareTo(two)).isEqualTo(0);
	}

	@Test
	public void testCompareShouldBeGreaterThan() {
		RouteResult one = new RouteResult("", 2000);
		RouteResult two = new RouteResult("", 1000);

		assertThat(one.compareTo(two)).isEqualTo(1);
	}

	@Test
	public void testCompareShouldBeLessThan() {
		RouteResult one = new RouteResult("", 1000);
		RouteResult two = new RouteResult("", 2000);

		assertThat(one.compareTo(two)).isEqualTo(-1);
	}

}