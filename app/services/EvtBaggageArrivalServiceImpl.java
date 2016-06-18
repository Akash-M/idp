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

    public List<EvtBaggageArrival> getEvtBaggageArrivalByTime(int time) {
        List<EvtBaggageArrival> evtBaggageArrival = evtBaggageArrivalDAO.findByTime(time);
        return evtBaggageArrival;
    }

    @Override
    public List<EvtBaggageArrival> getEvtBaggageArrivalList() {
        return evtBaggageArrivalDAO.findAll();
    }

    public List<EvtBaggageArrival> getEvtBaggageArrivalByFlightId(int flightId){
        return evtBaggageArrivalDAO.findByFlightId(flightId);
    }

    @Override
    public List<EvtBaggageArrival> getEvtBaggageArrivalByFlightIdAndTime(int flight_id, int time) {
        return evtBaggageArrivalDAO.findByFlightIdAndTime(flight_id, time);
    }

    @Override
    public List<EvtBaggageArrival> getEvtBaggageArrivalByFlightIdOrderByTime(int flightId){
        return evtBaggageArrivalDAO.findByFlightIdOrderByTime(flightId);
    }
}
