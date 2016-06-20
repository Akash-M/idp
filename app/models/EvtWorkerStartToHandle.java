package models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by prate_000 on 19-06-2016.
 */
@Document(collection = "eventWorkerStartToHandle")
public class EvtWorkerStartToHandle {

    @Field("_time")
    private Integer time;

    @Field("flight_id")
    private Integer flightId;

    @Field("worker_id")
    private List<Integer> workerIds;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getFlightid() {
        return flightId;
    }

    public void setFlightid(Integer flight_id) {
        this.flightId = flight_id;
    }

    public List<Integer> getWorkerIds() {
        return workerIds;
    }

    public void setWorkerIds(List<Integer> workerIds) {
        this.workerIds = workerIds;
    }
}
