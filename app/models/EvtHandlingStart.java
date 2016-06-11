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
    private int time;

    @Field("carousel_id")
    private int carouselId;

    @Field("flight_id")
    private int flightId;

    @Field("workingstations")
    private List<Integer> workingStations;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCarouselid() {
        return carouselId;
    }

    public void setCarouselid(int carousel_id) {
        this.carouselId = carousel_id;
    }

    public int getFlightid() {
        return flightId;
    }

    public void setFlightid(int flight_id) {
        this.flightId = flight_id;
    }

    public List<Integer> getWorkingstations() {
        return workingStations;
    }

    public void setWorkingstations(List<Integer> workingStations) {
        this.workingStations = workingStations;
    }
}
