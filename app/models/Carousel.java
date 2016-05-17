package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Document(collection = "carousel")
public class Carousel {


    @Id
    private int id;

    private int xCoordinate;
    private int yCoordinate;
    private int parkingPositions;
    private int maxCapacity;
    private int currentCapacity;
    private List<Integer> flight_ids;
    private List<Integer> workingStationsAssigned;

    public int getId() {
        return id ;
    }

    public void setId(int id) {
         this.id = id;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getParkingPositions() {
        return parkingPositions;
    }

    public void setParkingPositions(int parkingPositions) {
        this.parkingPositions = parkingPositions;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public List<Integer> getFlight_ids() {
        return flight_ids;
    }

    public void setFlight_ids(List<Integer> flight_ids) {
        this.flight_ids = flight_ids;
    }

    public List<Integer> getWorkingStationsAssigned() {
        return workingStationsAssigned;
    }

    public void setWorkingStationsAssigned(List<Integer> workingStationsAssigned) {
        this.workingStationsAssigned = workingStationsAssigned;
    }
}
