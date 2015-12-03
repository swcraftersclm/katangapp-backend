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

    public static Result index(String lt, String ln, int r) {
        Finder busStopFinder = new BusStopsFinder();

        double dLatitude = Double.parseDouble(lt);
        double dLongitude = Double.parseDouble(ln);

        QueryResult queryResult = busStopFinder.findRoutes(
            dLatitude, dLongitude, r);

        return ok(Json.toJson(queryResult));
    }

}
