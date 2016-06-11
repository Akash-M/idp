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
    private int time;

    @Field("flight_id")
    private int flightId;

    @Field("worker_id")
    private int workerId;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getFlightid() {
        return flightId;
    }

    public void setFlightid(int flight_id) {
        this.flightId = flight_id;
    }

    public int getWorkerid() {
        return workerId;
    }

    public void setWorkerid(int worker_id) {
        this.workerId = worker_id;
    }
}
