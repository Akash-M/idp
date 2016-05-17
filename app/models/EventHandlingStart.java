package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Document(collection = "eventHandlingStart")
public class EventHandlingStart {

    @Id
    private int time;
    private int carousel_id;
    private int flight_id;
    private List<Integer> workingStations;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCarousel_id() {
        return carousel_id;
    }

    public void setCarousel_id(int carousel_id) {
        this.carousel_id = carousel_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public List<Integer> getWorkingStations() {
        return workingStations;
    }

    public void setWorkingStations(List<Integer> workingStations) {
        this.workingStations = workingStations;
    }
}
