package daos;

import models.EventHandlingEnd;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EHERepository extends MongoRepository<EventHandlingEnd, Integer> {
    public EventHandlingEnd findByTime(int time);
}
