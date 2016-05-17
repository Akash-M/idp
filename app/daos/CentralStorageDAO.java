package daos;

import models.CentralStorage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface CentralStorageDAO extends MongoRepository<CentralStorage, Integer> {
    CentralStorage findById(Integer id);
}
