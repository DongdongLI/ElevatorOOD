package model;

import constants.Status;

import java.util.*;

public class ElevatorController {
    int numberOfElevator;
    int numberOfFloors;
    List<Elevator> elevators;
    TreeMap<Integer, Queue<Integer>> passengers;

    private void init() {
        elevators = new ArrayList<Elevator>();
        for(int i = 0;i < numberOfElevator;i++) {
            elevators.add(new Elevator());
        }
        passengers = new TreeMap<Integer, Queue<Integer>>();
    }

    public void goToFloor() {}

    public void addStop(int floor, int elevatorId) {
        elevators.get(elevatorId).addStop(floor);
        if(elevators.get(elevatorId).status == Status.IDLE) {
            elevators.get(elevatorId).move();
        }
    }

}
