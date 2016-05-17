package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.CentralStorage;
import play.libs.Json;
import play.mvc.*;
import services.CentralStorageService;

import play.mvc.Controller;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class Application extends Controller {

    @Inject
    private CentralStorageService csService;

    public Result getCentralStorage() {
        CentralStorage cs = csService.getCSCapacities(1);
        JsonNode csJson = Json.toJson(cs);
        return ok(csJson);
        /*return ok("Awesome");*/
    }

    public Result home() {
        return ok(views.html.home.render());
    }

    public Result carousel() {
        return ok(views.html.carousel.render());
    }

}
