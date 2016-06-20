package services;

import models.EvtBaggageArrival;

import java.util.List;

/**
 * Created by prate_000 on 30-05-2016.
 */
public interface EvtBaggageArrivalService {
    List<EvtBaggageArrival> getEvtBaggageArrivalList();
    List<EvtBaggageArrival> getEvtBaggageArrivalByTime(Integer time);
    List<EvtBaggageArrival> getEvtBaggageArrivalByFlightId(Integer flight_id);
    List<EvtBaggageArrival> getEvtBaggageArrivalByFlightIdAndTime(Integer flight_id, Integer time);
    List<EvtBaggageArrival> getEvtBaggageArrivalByFlightIdOrderByTime(Integer flightId);
}
