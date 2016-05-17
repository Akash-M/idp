package daos;

import models.EventHandlingStart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EHSRepository extends MongoRepository<EventHandlingStart, Integer> {
    public EventHandlingStart findByTime(int time);
}
