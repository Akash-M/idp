package services;

import models.EvtHandlingStart;

import java.util.List;

/**
 * Created by prate_000 on 30-05-2016.
 */
public interface EvtHandlingStartService {
    List<EvtHandlingStart> getEvtHandlingStartList();
    List<EvtHandlingStart> getEvtHandlingStartByTime(Integer time);
    List<EvtHandlingStart> getEvtHandlingStartByFlightId(Integer flight_id);
    List<EvtHandlingStart> getEvtHandlingStartByCarouselId(Integer carousel_id);
}
