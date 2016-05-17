package daos;

import models.EvtStorageDepletionStart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EvtStoreDepletionStartDAO extends MongoRepository<EvtStorageDepletionStart, Integer> {
    EvtStorageDepletionStart findByTime(int time);
}
