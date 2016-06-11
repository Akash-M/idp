package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.BasicDBList;
import models.Carousel;
import models.CentralStorage;
import models.Flight;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.mapping.Document;
import play.libs.Json;
import play.mvc.*;
import services.*;

import play.mvc.Controller;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
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
        /*Need to convert to Key-value pair JSON by adding key "Carousels"*/
        /*return ok("Awesome");*/
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

    public Result getFlightList(){
        List<Flight> allFlightsList = flightService.getAllFlights();
        JsonNode allFlightsListJson = Json.toJson(allFlightsList);
        return ok(allFlightsListJson);
        /*Need to convert to Key-value pair JSON by adding key "Flights"*/
    }

    public Result getFlightDetailsById(int id){
        JsonNode flightJsonNode = flightService.getFlightDetailsById(id);
        return ok(flightJsonNode);
    }

    public Result getAllCarouselsId(){
        List<Integer> carouselsId = carouselService.getAllCarouselsId();
        Collections.sort(carouselsId);

        BasicDBList carouselsIdList = new BasicDBList();
        carouselsIdList.addAll(carouselsId);
        BasicBSONObject bsonObject = new BasicBSONObject();
        bsonObject.put("Carousel_ids", carouselsIdList);
        JsonNode carouselsIdJson = Json.toJson(bsonObject);
        return ok(carouselsIdJson);
    }
}
