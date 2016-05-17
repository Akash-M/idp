package daos;

import models.EventBaggageArrival;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EBARepository extends MongoRepository<EventBaggageArrival, Integer> {
    public EventBaggageArrival findByTime(int time);
}
