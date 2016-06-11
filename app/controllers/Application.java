package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import models.*;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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

    @Inject
    private EvtBaggageArrivalService evtBaggageArrivalService;

    @Inject
    private EvtHandlingEndService evtHandlingEndService;

    @Inject
    private EvtHandlingStartService evtHandlingStartService;

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

    public Result getEvtBaggageArrivalByFlightId(){
        List<EvtBaggageArrival> evtBaggageArrivalList = evtBaggageArrivalService.getEvtBaggageArrivalByFlightId(4);
        JsonNode evtBaggageArrivalListJson = Json.toJson(evtBaggageArrivalList);
        return ok(evtBaggageArrivalListJson);
    }

    public Result getEvtBaggageArrivalByTime(){
        List<EvtBaggageArrival> evtBaggageArrivalList = evtBaggageArrivalService.getEvtBaggageArrivalByTime(22);
        JsonNode evtBaggageArrivalListJson = Json.toJson(evtBaggageArrivalList);
        return ok(evtBaggageArrivalListJson);
    }

    public Result getEvtHandlingEndByFlightId(){
        List<EvtHandlingEnd> evtHandlingEndByFlightIdList = evtHandlingEndService.getEvtHandlingEndByFlightId(4);
        JsonNode evtEndListJson = Json.toJson(evtHandlingEndByFlightIdList);
        return ok(evtEndListJson);
    }

    public Result getAllEvts(){
        List<EvtHandlingStart> evtHandlingStartsList = evtHandlingStartService.getEvtHandlingStartByFlightId(4);
        List<EvtBaggageArrival> evtBaggageArrivalList = evtBaggageArrivalService.getEvtBaggageArrivalByFlightId(4);
        List<EvtHandlingEnd> evtHandlingEndByFlightIdList = evtHandlingEndService.getEvtHandlingEndByFlightId(4);
        BasicDBList allEventList = new BasicDBList();
        allEventList.addAll(evtHandlingStartsList);
        allEventList.addAll(evtBaggageArrivalList);
        allEventList.addAll(evtHandlingEndByFlightIdList);
        BasicBSONObject bsonObject = new BasicBSONObject();
        bsonObject.put("Events", allEventList);
        JsonNode carouselsIdJson = Json.toJson(bsonObject);
        return ok(carouselsIdJson);
    }

    public Result getAllCarouselEvents(int carouselId){
        List<EvtHandlingStart> evtHandlingStartsList = evtHandlingStartService.getEvtHandlingStartByCarouselId(carouselId);
        BasicDBList allEventList = new BasicDBList();


        BasicBSONObject flightBSONObject = new BasicBSONObject();
        BasicBSONObject carouselBSONObject = new BasicBSONObject();

        for (Iterator<EvtHandlingStart> i = evtHandlingStartsList.iterator(); i.hasNext();) {
            List<BasicBSONObject> bsonObjectList = new ArrayList();
            BasicBSONObject bsonObject = new BasicBSONObject();
            allEventList.clear();
            EvtHandlingStart evtHandlingStart = i.next();
            int flight_id = evtHandlingStart.getFlightid();
            bsonObject.append("time", evtHandlingStart.getTime());
            bsonObject.append("name", "SH");
            bsonObject.append("bags", 0);
            System.out.println(bsonObject);
            bsonObjectList.add(bsonObject);
            /**
             * SH : Start Handling
             * SD : Storage Depletion
             * WA : Worker Allocation
             * BA : Baggage Arrival
             * EH : End Handling
             */

            List<EvtBaggageArrival> evtBaggageArrivalList = evtBaggageArrivalService.getEvtBaggageArrivalByFlightId(flight_id);
            System.out.println(evtBaggageArrivalList.size());
            for(Iterator<EvtBaggageArrival> j = evtBaggageArrivalList.iterator(); j.hasNext();){
                EvtBaggageArrival evtBaggageArrival = j.next();
                BasicBSONObject bsonObject1 = new BasicBSONObject();
                bsonObject1.put("time", evtBaggageArrival.getTime() );
                bsonObject1.put("name", "BA");
                bsonObject1.put("bags", evtBaggageArrival.getBags());
                System.out.println(bsonObject1);
                bsonObjectList.add(bsonObject1);
            }
            List<EvtHandlingEnd> evtHandlingEndByFlightIdList = evtHandlingEndService.getEvtHandlingEndByFlightId(flight_id);
            System.out.println(evtHandlingEndByFlightIdList.size());
            for(Iterator<EvtHandlingEnd> k = evtHandlingEndByFlightIdList.iterator(); k.hasNext();){
                EvtHandlingEnd evtHandlingEnd = k.next();
                BasicBSONObject bsonObject2 = new BasicBSONObject();
                bsonObject2.put("time", evtHandlingEnd.getTime() );
                System.out.println(bsonObject2);
                bsonObjectList.add(bsonObject2);
            }
            System.out.println(bsonObjectList);
            //allEventList.addAll(bsonObjectList);
            flightBSONObject.append(""+flight_id, bsonObjectList);
        }
        carouselBSONObject.append(""+carouselId, flightBSONObject);

        JsonNode carouselsEvtsJson = Json.toJson(carouselBSONObject);
        return ok(carouselsEvtsJson);
    }


}
