package daos;

import models.EventStorageDepletionStart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface ESDSRepository extends MongoRepository<EventStorageDepletionStart, Integer> {
    EventStorageDepletionStart findByTime(int time);
}
