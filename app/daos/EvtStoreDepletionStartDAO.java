package daos;

import models.EvtStorageDepletionStart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EvtStoreDepletionStartDAO extends MongoRepository<EvtStorageDepletionStart, Integer> {
    List<EvtStorageDepletionStart> findByTime(int time);
    List<EvtStorageDepletionStart> findByFlightId(int flight_id);
    List<EvtStorageDepletionStart> findByFlightIdAndTime(int flight_id, int time);
}
