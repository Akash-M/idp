package daos;

import models.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface WorkerDAO extends MongoRepository<Worker, Integer> {
    public Worker findById(Integer id);
}
