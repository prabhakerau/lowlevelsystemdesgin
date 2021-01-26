package com.lld.questions;


public class FloorButton {

    private int floorNumber;

    public FloorButton(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Elevator click() {
        return ElevatorSystemController.requestForElevator(floorNumber);
    }
}
