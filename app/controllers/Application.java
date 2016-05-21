package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Carousel;
import models.CentralStorage;
import play.libs.Json;
import play.mvc.*;
import services.CarouselService;
import services.CentralStorageService;

import play.mvc.Controller;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named
public class Application extends Controller {

    @Inject
    private CentralStorageService csService;

    @Inject
    private CarouselService carouselService;

    public Result getCentralStorage() {
        List<CentralStorage> cs = csService.getCSCapacities();
        JsonNode csJson = Json.toJson(cs);
        return ok(csJson);
        /*return ok("Awesome");*/
    }

    public Result getCarouselList() {
        List<Carousel> cs = carouselService.getCarousels();
        JsonNode csJson = Json.toJson(cs);
        return ok(csJson);
        /*return ok("Awesome");*/
    }

    public Result getWorkStationsCount(){
        return ok(carouselService.countWorkStations(1)+"\n");
    }

    public Result home() {
        return ok(views.html.home.render());
    }

    public Result carousel() {
        return ok(views.html.carousel.render());
    }

}
