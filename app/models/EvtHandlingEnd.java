package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Document(collection = "eventHandlingEnd")
public class EvtHandlingEnd {
    @Field("_time")
    private Integer time;

    @Field("flight_id")
    private Integer flightId;

    @Field("worker_id")
    private Integer workerId;

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

    public Integer getWorkerid() {
        return workerId;
    }

    public void setWorkerid(int worker_id) {
        this.workerId = worker_id;
    }
}
