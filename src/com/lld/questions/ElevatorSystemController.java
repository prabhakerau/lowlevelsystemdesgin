package com.lld.questions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElevatorSystemController {

    private static List<Elevator> elevators = new ArrayList<>();
    private static ElevatorPickingStrategy elevatorPickingStrategy = new ShortestTimeFirstStrategy();

    public static Elevator requestForElevator(int floorNumber) {

        Elevator elevator = elevatorPickingStrategy.pickElevator(elevators, floorNumber);
        Request request = new Request(new Date().getTime());
        request.addDesiredFloor(floorNumber);
        elevator.serveRequest(request);
        return elevator;
    }

    public static void setElevatorPickingStrategy(ElevatorPickingStrategy elevatorPickingStrategy) {
        elevatorPickingStrategy = elevatorPickingStrategy;
    }

    public static void addElevator(Elevator elevator) {
        Thread thread = new Thread(elevator);
        thread.start();
        elevators.add(elevator);
    }

}
