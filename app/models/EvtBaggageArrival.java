package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Document(collection = "eventBaggageArrival")
public class EvtBaggageArrival {

    @Field("_time")
    private Integer time;

    @Field("flight_id")
    private Integer flightId;

    private Integer bags;

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

    public Integer getBags() {
        return bags;
    }

    public void setBags(Integer bags) {
        this.bags = bags;
    }
}
