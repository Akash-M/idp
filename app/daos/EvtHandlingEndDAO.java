package daos;

import models.EvtHandlingEnd;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EvtHandlingEndDAO extends MongoRepository<EvtHandlingEnd, Integer> {
    public EvtHandlingEnd findByTime(int time);
}
