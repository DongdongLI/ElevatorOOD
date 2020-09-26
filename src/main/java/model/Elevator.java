package model;

import constants.Status;

import java.util.Collections;
import java.util.List;

public class Elevator {
    List<ElevatorButton> buttons;
    List<Integer> upStops;
    List<Integer> downStops;

    int currentLevel;
    Status status;

    boolean isGateOpen;

    float weightLimit;

    void handleExternalRequest(ExternalRequest externalRequest) {

    }

    void handleInternalRequest(InternalRequest internalRequest) {

    }

    void openGate() {

    }

    void closeGate() {

    }

    float getCurrentWeight(){return 0;}

    boolean isRequestValid(InternalRequest request) {
        return false;
    }

    void addStop(int floor) {
        if(floor > currentLevel) {
            upStops.add(floor);
            Collections.sort(upStops);
        } else if(floor < currentLevel) {
            downStops.add(floor);
            Collections.sort(downStops);
        }
    }

    void moveToFloor(int floor) {
        currentLevel = floor;
        openGate();
        closeGate();

        if(hasJobs()) {
            move();
        }
    }

    boolean hasJobs() {
        return !upStops.isEmpty() || !downStops.isEmpty();
    }

    void move() {
        if(upStops.isEmpty() && downStops.isEmpty()) {
            status = Status.IDLE;
            return;
        }

        if(status == Status.UP) {
            if(upStops.isEmpty()) {
                status = Status.DOWN;
                move();
            } else {
                moveToFloor(upStops.get(0));
                upStops.remove(0);
            }
        } else {
            if(downStops.isEmpty()) {
                status = Status.UP;
                move();
            } else {
                moveToFloor(downStops.get(0));
                downStops.remove(0);
            }
        }
    }
}
