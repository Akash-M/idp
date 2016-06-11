package services;

import daos.EvtHandlingStartDAO;
import models.EvtHandlingStart;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 11-06-2016.
 */
@Named
public class EvtHandlingStartServiceImpl implements EvtHandlingStartService {

    @Inject
    private EvtHandlingStartDAO evtHandlingStartDAO;

    @Override
    public List<EvtHandlingStart> getEvtHandlingStartByFlightId(int flight_id) {
        return evtHandlingStartDAO.findByFlightId(flight_id);
    }

    @Override
    public List<EvtHandlingStart> getEvtHandlingStartList() {
        return evtHandlingStartDAO.findAll();
    }

    @Override
    public List<EvtHandlingStart> getEvtHandlingStartByTime(int time) {
        return evtHandlingStartDAO.findByTime(time);
    }

    @Override
    public List<EvtHandlingStart> getEvtHandlingStartByCarouselId(int carousel_id) {
        return evtHandlingStartDAO.findByCarouselId(carousel_id);
    }
}
