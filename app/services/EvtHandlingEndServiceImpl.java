package services;

import daos.EvtBaggageArrivalDAO;
import daos.EvtHandlingEndDAO;
import models.EvtHandlingEnd;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 30-05-2016.
 */
@Named
public class EvtHandlingEndServiceImpl implements EvtHandlingEndService{

    @Inject
    private EvtHandlingEndDAO evtHandlingEndDAO;

    @Override
    public List<EvtHandlingEnd> getEvtHandlingEndList() {
        return evtHandlingEndDAO.findAll();
    }

    public List<EvtHandlingEnd> getEvtHandlingEndByTime(int time) {
        return evtHandlingEndDAO.findByTime(time);
    }

    @Override
    public List<EvtHandlingEnd> getEvtHandlingEndByFlightId(int flight_id) {
        return evtHandlingEndDAO.findByFlightId(flight_id);
    }

}
