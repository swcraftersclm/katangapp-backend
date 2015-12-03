package controllers;

import business.BusStopsFinder;
import business.Finder;

import models.QueryResult;

import play.libs.Json;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author mdelapenya
 */
public class Results extends Controller {

    public static Result index(String latitude, String longitude, int radius) {
        Finder busStopFinder = new BusStopsFinder();

        double dLatitude = Double.parseDouble(latitude);
        double dLongitude = Double.parseDouble(longitude);

        QueryResult queryResult = busStopFinder.findRoutes(
            dLatitude, dLongitude, radius);

        return ok(Json.toJson(queryResult));
    }

}
