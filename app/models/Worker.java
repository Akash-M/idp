package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Document(collection = "worker")
public class Worker {

    @Id
    private Integer id;

    private Integer shiftStartTime;
    private Integer shiftStartXCoordinate;
    private Integer shiftStartYCoordinate;
    private Integer shiftEndTime;
    private Integer shiftEndXCoordinate;
    private Integer shiftEndYCoordinate;
    private Integer groundHandler_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(Integer shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public Integer getShiftStartXCoordinate() {
        return shiftStartXCoordinate;
    }

    public void setShiftStartXCoordinate(Integer shiftStartXCoordinate) {
        this.shiftStartXCoordinate = shiftStartXCoordinate;
    }

    public Integer getShiftStartYCoordinate() {
        return shiftStartYCoordinate;
    }

    public void setShiftStartYCoordinate(Integer shiftStartYCoordinate) {
        this.shiftStartYCoordinate = shiftStartYCoordinate;
    }

    public Integer getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(Integer shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }

    public Integer getShiftEndXCoordinate() {
        return shiftEndXCoordinate;
    }

    public void setShiftEndXCoordinate(Integer shiftEndXCoordinate) {
        this.shiftEndXCoordinate = shiftEndXCoordinate;
    }

    public Integer getShiftEndYCoordinate() {
        return shiftEndYCoordinate;
    }

    public void setShiftEndYCoordinate(Integer shiftEndYCoordinate) {
        this.shiftEndYCoordinate = shiftEndYCoordinate;
    }

    public Integer getGroundHandler_id() {
        return groundHandler_id;
    }

    public void setGroundHandler_id(Integer groundHandler_id) {
        this.groundHandler_id = groundHandler_id;
    }
}
