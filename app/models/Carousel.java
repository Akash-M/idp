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

    private Integer xCoordinate;
    private Integer yCoordinate;
    private Integer parkingPositions;
    private Integer maxCapacity;
    private Integer currentCapacity;
    private List<Integer> flight_id;
    private Integer workingStationsAssigned;

    public Integer getId() {
        return _id ;
    }

    public void setId(Integer id) {
         this._id = id;
    }

    public Integer getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Integer getParkingPositions() {
        return parkingPositions;
    }

    public void setParkingPositions(Integer parkingPositions) {
        this.parkingPositions = parkingPositions;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public List<Integer> getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(List<Integer> flight_id) {
        this.flight_id = flight_id;
    }

    public Integer getWorkingStationsAssigned() {
        return workingStationsAssigned;
    }

    public void setWorkingStationsAssigned(Integer workingStationsAssigned) {
        this.workingStationsAssigned = workingStationsAssigned;
    }
}