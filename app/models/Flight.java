package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Document(collection = "flight")
public class Flight {

    @Id
    private String id;

    private int requiredNumberOfParkingStations;
    private int expectedEndOfBaggageHandling;
    private int carousel_id;
    private List<Integer> worker_ids;
    private List<Integer> workstations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRequiredNumberOfParkingStations() {
        return requiredNumberOfParkingStations;
    }

    public void setRequiredNumberOfParkingStations(int requiredNumberOfParkingStations) {
        this.requiredNumberOfParkingStations = requiredNumberOfParkingStations;
    }

    public int getExpectedEndOfBaggageHandling() {
        return expectedEndOfBaggageHandling;
    }

    public void setExpectedEndOfBaggageHandling(int expectedEndOfBaggageHandling) {
        this.expectedEndOfBaggageHandling = expectedEndOfBaggageHandling;
    }

    public int getCarousel_id() {
        return carousel_id;
    }

    public void setCarousel_id(int carousel_id) {
        this.carousel_id = carousel_id;
    }

    public List<Integer> getWorker_ids() {
        return worker_ids;
    }

    public void setWorker_ids(List<Integer> worker_ids) {
        this.worker_ids = worker_ids;
    }

    public List<Integer> getWorkstations() {
        return workstations;
    }

    public void setWorkstations(List<Integer> workstations) {
        this.workstations = workstations;
    }
}
