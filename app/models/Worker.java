package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prate_000 on 16-05-2016.
 */
@Document(collection = "worker")
public class Worker {

    @Id
    private int id;

    private int shiftStartTime;
    private int shiftStartXCoordinate;
    private int shiftStartYCoordinate;
    private int shiftEndTime;
    private int shiftEndXCoordinate;
    private int shiftEndYCoordinate;
    private int groundHandler_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(int shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public int getShiftStartXCoordinate() {
        return shiftStartXCoordinate;
    }

    public void setShiftStartXCoordinate(int shiftStartXCoordinate) {
        this.shiftStartXCoordinate = shiftStartXCoordinate;
    }

    public int getShiftStartYCoordinate() {
        return shiftStartYCoordinate;
    }

    public void setShiftStartYCoordinate(int shiftStartYCoordinate) {
        this.shiftStartYCoordinate = shiftStartYCoordinate;
    }

    public int getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(int shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }

    public int getShiftEndXCoordinate() {
        return shiftEndXCoordinate;
    }

    public void setShiftEndXCoordinate(int shiftEndXCoordinate) {
        this.shiftEndXCoordinate = shiftEndXCoordinate;
    }

    public int getShiftEndYCoordinate() {
        return shiftEndYCoordinate;
    }

    public void setShiftEndYCoordinate(int shiftEndYCoordinate) {
        this.shiftEndYCoordinate = shiftEndYCoordinate;
    }

    public int getGroundHandler_id() {
        return groundHandler_id;
    }

    public void setGroundHandler_id(int groundHandler_id) {
        this.groundHandler_id = groundHandler_id;
    }
}
