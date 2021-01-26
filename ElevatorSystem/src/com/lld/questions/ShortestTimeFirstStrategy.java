package com.lld.questions;

import java.util.List;

public class ShortestTimeFirstStrategy implements ElevatorPickingStrategy {

    @Override
    public Elevator pickElevator(List<Elevator> availableElevators, int desiredFloor) {
        return getShortestTimedElevator(availableElevators, desiredFloor);
    }

    private Elevator getShortestTimedElevator(List<Elevator> availableElevators, int desiredFloor) {

        Elevator shortestTimedElevator = null;
        int shortestTime = Integer.MAX_VALUE;

        for(Elevator elevator : availableElevators) {
            int time = getTimeToReachFloor(elevator.getCurrentFloor(), desiredFloor);
            if( time < shortestTime) {
                shortestTime = time;
                shortestTimedElevator = elevator;
            }
        }
        System.out.println("Elevator with id " + shortestTimedElevator.getElevatorId() + " was selected to serve the request");
        return shortestTimedElevator;
    }

    private int getTimeToReachFloor(int currentFloor, int desiredFloor) {
        return Math.abs(desiredFloor - currentFloor) * 2; // in seconds
    }

}
