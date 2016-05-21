package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.Flight;

import java.util.List;

/**
 * Created by prate_000 on 21-05-2016.
 */
public interface FlightService {
    List<Flight> getAllFlights();
    JsonNode getWorkersList(int flightId);
}
