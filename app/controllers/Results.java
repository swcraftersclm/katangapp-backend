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

    public static Result index() {
        Finder busStopFinder = new BusStopsFinder();

        QueryResult queryResult = busStopFinder.findRoutes(0d, 0d, 0);

        return ok(Json.toJson(queryResult));
    }

}
