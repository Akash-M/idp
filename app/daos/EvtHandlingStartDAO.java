package daos;

import models.EvtHandlingStart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EvtHandlingStartDAO extends MongoRepository<EvtHandlingStart, Integer> {
    List<EvtHandlingStart> findByTime(Integer time);
    List<EvtHandlingStart> findByFlightId(Integer flight_id);
    List<EvtHandlingStart> findByCarouselId(Integer carousel_id);
    List<EvtHandlingStart> findAll();
}
