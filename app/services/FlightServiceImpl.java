package services;

import com.fasterxml.jackson.databind.JsonNode;
import daos.FlightDAO;
import models.Flight;
import play.libs.Json;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 21-05-2016.
 */
@Named
public class FlightServiceImpl implements FlightService {

    @Inject
    private FlightDAO flightDAO;

    public List<Flight> getAllFlights(){
        return flightDAO.findAll();
    }

    public JsonNode getWorkersList(int flightId){
        Flight flight = flightDAO.findById(flightId);
        JsonNode flightJson = Json.toJson(flight);
        JsonNode workerNode = flightJson.get("worker_id") ;
        return workerNode;
    }
}
