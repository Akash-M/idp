package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Carousel;
import models.CentralStorage;
import play.libs.Json;
import play.mvc.*;
import services.*;

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

    @Inject
    private FlightService flightService;

    @Inject
    private WorkerService workerService;

    @Inject
    private GroundHandlerService groundHandlerService;

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

    public Result carousel() { return ok(views.html.carousel.render());}

    public Result getCarouselDetailsById(int id) {
        Carousel carousel = carouselService.findById(id);
        JsonNode carouselJson = Json.toJson(carousel);
        JsonNode flightsNode = carouselService.getFlightList(id);

        int flightIdAtFirstIndexOfFlightList = flightsNode.get(0).asInt();
        JsonNode workerNodes = flightService.getWorkersList(flightIdAtFirstIndexOfFlightList);

        int workerIdAtFirstIndexOfWorkerList = workerNodes.get(0).asInt();
        int groundHandlerId = workerService.getGroundHandlerId(workerIdAtFirstIndexOfWorkerList);
        String groundHandlerName = groundHandlerService.getGroundHandlerNameById(groundHandlerId);

        int workingStationsCount = carouselService.countWorkStations(id);
        ObjectNode carouselObjectNodeForMerging = ((ObjectNode) carouselJson);
        carouselObjectNodeForMerging = carouselObjectNodeForMerging.put("No_of_Workers", workingStationsCount);
        carouselObjectNodeForMerging = carouselObjectNodeForMerging.put("Ground_Handler_Name", groundHandlerName);
        return ok(carouselObjectNodeForMerging);
    }

}
