package com.lld.questions;


public class Main {

    public static void main(String[] args) {

        ElevatorSystemController.addElevator(new Elevator(1, 5));
        ElevatorSystemController.addElevator(new Elevator(2, 2));

       // FloorButton fourthFloorButton = new FloorButton(4);
        //Elevator elevator1 = fourthFloorButton.click();
        //elevator1.getElevatorButtonPanel().click(3);

        FloorButton firstFloorButton = new FloorButton(1);
        Elevator elevator2 = firstFloorButton.click();
        elevator2.getElevatorButtonPanel().click(5);
        elevator2.getElevatorButtonPanel().click(3);
       // elevator2.getElevatorButtonPanel().click(4);

    }
}
