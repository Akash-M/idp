package daos;

import models.EvtHandlingStart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EvtHandlingStartDAO extends MongoRepository<EvtHandlingStart, Integer> {
    public EvtHandlingStart findByTime(int time);
}
