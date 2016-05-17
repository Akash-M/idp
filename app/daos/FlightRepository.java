package daos;


import models.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface FlightRepository extends MongoRepository<Flight, Integer>{
     Flight findById(int id);
}
