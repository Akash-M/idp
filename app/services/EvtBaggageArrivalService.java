package services;

import models.EvtBaggageArrival;

import java.util.List;

/**
 * Created by prate_000 on 30-05-2016.
 */
public interface EvtBaggageArrivalService {
    List<EvtBaggageArrival> getEvtBaggageArrivalList();
    List<EvtBaggageArrival> getEvtBaggageArrivalByTime(int time);
}
