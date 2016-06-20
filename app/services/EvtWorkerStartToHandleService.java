package services;

import models.EvtWorkerStartToHandle;

import java.util.List;

/**
 * Created by prate_000 on 19-06-2016.
 */
public interface EvtWorkerStartToHandleService {
    List<EvtWorkerStartToHandle> getEvtWorkerStartToHandleList();
    List<EvtWorkerStartToHandle> getEvtWorkerStartToHandleByTime(Integer time);
    List<EvtWorkerStartToHandle> getEvtWorkerStartToHandleListByFlightId(Integer flight_id);
}
