package business.parser;

import models.RouteResult;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * @author mdelapenya
 */
public class HTMLParser {

	public static List<RouteResult> parseResponse(
		String routeId, String busStopId, Date queryDate, String html) {

		List<RouteResult> results = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(queryDate);

		Document doc = Jsoup.parse(html);

		Element busStopTitle = doc.getElementById("titparada");

		Element hour = doc.getElementById("hora");

		Matcher matcher = captureGroup(hour.text(), REGEXP_HOUR);

		String arrivalTime = matcher.group(1);

		RouteResult mainRouteResult = parseRouteResult(
			calendar, routeId, arrivalTime);

		results.add(mainRouteResult);

		String direction = matcher.group(2);

		Elements connectionsUl = doc.getElementsByTag("ul");

		for (Element connectionUl : connectionsUl) {
			Elements connectionsLi = connectionUl.getElementsByTag("li");

			for (Element connectionLi : connectionsLi) {
				matcher = captureGroup(connectionLi.text(), REGEXP_CONNECTIONS);

				String connectionRouteId = matcher.group(1);
				String connectionArrivalTime = matcher.group(2);

				RouteResult connectionRouteResult = parseRouteResult(
					calendar, connectionRouteId, connectionArrivalTime);

				results.add(connectionRouteResult);
			}
		}

		return results;
	}

	private static Matcher captureGroup(String text, String regexp) {
		Pattern pattern = Pattern.compile(regexp);

		Matcher matcher = pattern.matcher(text);

		matcher.matches();

		return matcher;
	}

	private static RouteResult parseRouteResult(
		Calendar calendar, String routeId, String arrivalTime) {

		int colonIndexOf = arrivalTime.indexOf(":");

		String strConnectionHour = arrivalTime.substring(
			0, colonIndexOf);

		int connectionHour = Integer.parseInt(strConnectionHour);

		String strConnectionMinutes = arrivalTime.substring(
			colonIndexOf + 1, arrivalTime.length());

		int connectionMinutes = Integer.parseInt(strConnectionMinutes);

		calendar.set(Calendar.HOUR_OF_DAY, connectionHour);
		calendar.set(Calendar.MINUTE, connectionMinutes);

		return new RouteResult(routeId, calendar.getTimeInMillis());
	}

	private static final String REGEXP_HOUR =
		".*:\\s(\\d{1,2}:\\d{2})\\s.*:\\s(.*)";

	private static final String REGEXP_CONNECTIONS =
		".*\\((.*)\\):\\s(\\d{1,2}:\\d{2})";

}