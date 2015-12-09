package controllers;

import business.BusStopsFinder;
import business.Finder;
import business.http.HttpClient;

import models.QueryResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

import play.libs.Json;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author mdelapenya
 */
public class Results extends Controller {

    public static Result index(String lt, String ln, int r) {
        Finder busStopFinder = new BusStopsFinder();

        double dLatitude = Double.parseDouble(lt);
        double dLongitude = Double.parseDouble(ln);

        QueryResult queryResult = busStopFinder.findRoutes(
            dLatitude, dLongitude, r);

        boolean isPrettyPrint = isPrettyPrint();

        JsonNode node = Json.toJson(queryResult);

        if (isPrettyPrint) {
            try {
                return ok(prettyPrint(node)).as("application/json");
            }
            catch (JsonProcessingException e) {
                // fall back to default JSON print
            }
        }

        return ok(node);
    }

    public static Result unauto(String idl, String idp, String ido) {
        HttpClient httpClient = new HttpClient();

        String response = httpClient.get(idl, idp, ido);

        return ok(response);
    }

    private static boolean isPrettyPrint() {
        Map<String, String[]> queryStringParametersMap =
            request().queryString();

        boolean isPrettyPrint = queryStringParametersMap.containsKey(
            "prettyPrint");

        if (isPrettyPrint) {
            final String[] pretties = queryStringParametersMap.get(
                "prettyPrint");

            if (pretties[0].equalsIgnoreCase("true") ||
                pretties[0].equalsIgnoreCase("1")) {

               return true;
            }
        }

        return false;
    }

    private static String prettyPrint(JsonNode node)
        throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        final ObjectWriter objectWriter =
            mapper.writerWithDefaultPrettyPrinter();

        return objectWriter.writeValueAsString(node);
    }

}
