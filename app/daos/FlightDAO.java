package daos;


import models.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface FlightDAO extends MongoRepository<Flight, Integer>{
     Flight findById(Integer id);
}
