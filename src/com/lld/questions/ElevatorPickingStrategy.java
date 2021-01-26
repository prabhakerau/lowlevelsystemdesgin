package com.lld.questions;

import java.util.List;

public interface ElevatorPickingStrategy {
    Elevator pickElevator(List<Elevator> availableElevators, int desiredFloor);
}
