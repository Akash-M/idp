package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Document(collection = "eventHandlingStart")
public class EvtHandlingStart {

    @Field("_time")
    private Integer time;

    @Field("carousel_id")
    private Integer carouselId;

    @Field("flight_id")
    private Integer flightId;

    @Field("workingstations")
    private List<Integer> workingStations;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCarouselid() {
        return carouselId;
    }

    public void setCarouselid(Integer carousel_id) {
        this.carouselId = carousel_id;
    }

    public Integer getFlightid() {
        return flightId;
    }

    public void setFlightid(Integer flight_id) {
        this.flightId = flight_id;
    }

    public List<Integer> getWorkingstations() {
        return workingStations;
    }

    public void setWorkingstations(List<Integer> workingStations) {
        this.workingStations = workingStations;
    }
}
