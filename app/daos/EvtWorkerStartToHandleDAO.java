package daos;

import models.EvtWorkerStartToHandle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prate_000 on 18-06-2016.
 */
public interface EvtWorkerStartToHandleDAO extends MongoRepository<EvtWorkerStartToHandle, Integer> {

    List<EvtWorkerStartToHandle> findAll();
    List<EvtWorkerStartToHandle> findByFlightIdOrderByTime(Integer flight_id);
    List<EvtWorkerStartToHandle> findByTime(Integer time);
}
