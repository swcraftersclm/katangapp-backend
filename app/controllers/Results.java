package controllers;

import business.BusStopsFinder;
import business.Finder;

import business.http.HttpClient;

import models.QueryResult;

import play.libs.Json;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author mdelapenya
 */
public class Results extends Controller {

    public static Result unauto(String idl, String idp, String ido) {
        HttpClient httpClient = new HttpClient();

        String response = httpClient.get(idl, idp, ido);

        return ok(response);
    }

    public static Result index(String lt, String ln, int r) {
        Finder busStopFinder = new BusStopsFinder();

        double dLatitude = Double.parseDouble(lt);
        double dLongitude = Double.parseDouble(ln);

        QueryResult queryResult = busStopFinder.findRoutes(
            dLatitude, dLongitude, r);

        return ok(Json.toJson(queryResult));
    }

}
