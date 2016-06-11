package daos;

import models.EvtHandlingEnd;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EvtHandlingEndDAO extends MongoRepository<EvtHandlingEnd, Integer> {
    List<EvtHandlingEnd> findAll();
    List<EvtHandlingEnd> findByTime(int time);
    List<EvtHandlingEnd> findByFlightId(int flight_id);
}
