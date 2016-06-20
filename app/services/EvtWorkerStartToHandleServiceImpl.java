package services;

import daos.EvtWorkerStartToHandleDAO;
import models.EvtWorkerStartToHandle;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by prate_000 on 19-06-2016.
 */
@Named
public class EvtWorkerStartToHandleServiceImpl implements EvtWorkerStartToHandleService {

    @Inject
    private EvtWorkerStartToHandleDAO evtWorkerStartToHandleDAO;

    @Override
    public List<EvtWorkerStartToHandle> getEvtWorkerStartToHandleByTime(Integer time) {
        return evtWorkerStartToHandleDAO.findByTime(time);
    }

    @Override
    public List<EvtWorkerStartToHandle> getEvtWorkerStartToHandleList() {
        return evtWorkerStartToHandleDAO.findAll();
    }

    @Override
    public List<EvtWorkerStartToHandle> getEvtWorkerStartToHandleListByFlightId(Integer flight_id) {
        return evtWorkerStartToHandleDAO.findByFlightIdOrderByTime(flight_id);
    }
}
