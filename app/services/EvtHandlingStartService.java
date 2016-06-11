package services;

import models.EvtHandlingStart;

import java.util.List;

/**
 * Created by prate_000 on 30-05-2016.
 */
public interface EvtHandlingStartService {
    List<EvtHandlingStart> getEvtHandlingStartList();
    List<EvtHandlingStart> getEvtHandlingStartByTime(int time);
    List<EvtHandlingStart> getEvtHandlingStartByFlightId(int flight_id);
    List<EvtHandlingStart> getEvtHandlingStartByCarouselId(int carousel_id);
}
