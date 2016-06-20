package services;

import daos.EvtBaggageArrivalDAO;
import models.EvtBaggageArrival;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 30-05-2016.
 */
@Named
public class EvtBaggageArrivalServiceImpl implements EvtBaggageArrivalService{

    @Inject
    private EvtBaggageArrivalDAO evtBaggageArrivalDAO;

    public List<EvtBaggageArrival> getEvtBaggageArrivalByTime(Integer time) {
        List<EvtBaggageArrival> evtBaggageArrival = evtBaggageArrivalDAO.findByTime(time);
        return evtBaggageArrival;
    }

    @Override
    public List<EvtBaggageArrival> getEvtBaggageArrivalList() {
        return evtBaggageArrivalDAO.findAll();
    }

    public List<EvtBaggageArrival> getEvtBaggageArrivalByFlightId(Integer flightId){
        return evtBaggageArrivalDAO.findByFlightId(flightId);
    }

    @Override
    public List<EvtBaggageArrival> getEvtBaggageArrivalByFlightIdAndTime(Integer flight_id, Integer time) {
        return evtBaggageArrivalDAO.findByFlightIdAndTime(flight_id, time);
    }

    @Override
    public List<EvtBaggageArrival> getEvtBaggageArrivalByFlightIdOrderByTime(Integer flightId){
        return evtBaggageArrivalDAO.findByFlightIdOrderByTime(flightId);
    }
}
