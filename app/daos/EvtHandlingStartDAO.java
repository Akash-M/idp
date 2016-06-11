package daos;

import models.EvtHandlingStart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EvtHandlingStartDAO extends MongoRepository<EvtHandlingStart, Integer> {
    List<EvtHandlingStart> findByTime(int time);
    List<EvtHandlingStart> findByFlightId(int flight_id);
    List<EvtHandlingStart> findByCarouselId(int carousel_id);
    List<EvtHandlingStart> findAll();
}
