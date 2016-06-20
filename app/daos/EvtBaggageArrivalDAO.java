package daos;

import models.EvtBaggageArrival;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
public interface EvtBaggageArrivalDAO extends MongoRepository<EvtBaggageArrival, Integer>{
    List<EvtBaggageArrival> findAll();
    List<EvtBaggageArrival> findByTime(Integer time);
    //List<EvtBaggageArrival> findByTimeOrderByFlightId(Integer time);
    List<EvtBaggageArrival> findByFlightId(Integer flightId);
    List<EvtBaggageArrival> findByFlightIdOrderByTime(Integer flightId);
    List<EvtBaggageArrival> findByFlightIdAndTime(Integer flight_id, Integer time);
}
