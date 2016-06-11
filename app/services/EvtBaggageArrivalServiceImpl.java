package services;

import daos.EvtBaggageArrivalDAO;
import models.EvtBaggageArrival;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by prate_000 on 30-05-2016.
 */
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
}
