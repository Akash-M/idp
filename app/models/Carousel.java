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
    private Integer _id;

    private int xCoordinate;
    private int yCoordinate;
    private int parkingPositions;
    private int maxCapacity;
    private int currentCapacity;
    private List<Integer> flight_id;
    private List<Integer> workingStationsAssigned;

    public Integer getId() {
        return _id ;
    }

    public void setId(Integer id) {
         this._id = id;
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

    public List<Integer> getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(List<Integer> flight_id) {
        this.flight_id = flight_id;
    }

    public List<Integer> getWorkingStationsAssigned() {
        return workingStationsAssigned;
    }

    public void setWorkingStationsAssigned(List<Integer> workingStationsAssigned) {
        this.workingStationsAssigned = workingStationsAssigned;
    }
}
