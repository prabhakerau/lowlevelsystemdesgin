package com.lld.questions;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Elevator implements Runnable{
    private int elevatorId;
    private int currentFloor;

    private ElevatorDoor elevatorDoor = new ElevatorDoor();
    private ElevatorButtonsPanel elevatorButtonsPanel = new ElevatorButtonsPanel();

    private BlockingQueue<Request> queue = new PriorityBlockingQueue<>();

    public Elevator(int elevatorId, int currentFloor) {
        this.elevatorId = elevatorId;
        this.currentFloor = currentFloor;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorButtonsPanel getElevatorButtonPanel() {
        return elevatorButtonsPanel;
    }

    public void serveRequest(Request request) {
        try
        {
           queue.put(request);
        }
        catch (InterruptedException ex)
        {
            System.out.println("Elevator Interrupted");
        }
    }

    public void moveUp(){
        try {
            Thread.sleep(1000 * 2); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentFloor++;
        System.out.println("Elevator with id :"+ elevatorId + " moving up to floor : " + currentFloor);
    }

    public void moveDown() {
        try {
            Thread.sleep(1000 * 2); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentFloor--;
        System.out.println("Elevator with id :"+ elevatorId + " moving down to floor : " + currentFloor);
    }


    @Override
    public void run() {
        try
        {
            while (true)

            {
                Request currentRequest = queue.take();
                moveToDesiredFloors(currentRequest.getDesiredFloors());
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("Elevator Interrupted");
        }
    }

    private void moveToDesiredFloors(List<Integer> desiredFloors) {

        if(desiredFloors.contains(currentFloor)) {
            System.out.println("Elevator with id :"+ elevatorId + " reached to floor:"+ currentFloor);
            elevatorDoor.open();
            try {
                Thread.sleep(1000 * 2);// 2 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elevatorDoor.close();
            desiredFloors.remove(Integer.valueOf(currentFloor));
        }
        if(desiredFloors.size() <= 0) {
            return;
        }
        int desiredFloor = desiredFloors.get(0);
        if(currentFloor > desiredFloor) {
            moveDown();
        } else {
            moveUp();
        }
        moveToDesiredFloors(desiredFloors);
    }

    class ElevatorButtonsPanel {
        private Request request = new Request(new Date().getTime());
        public void click(int desiredFloor) {
            request.addDesiredFloor(desiredFloor);
            Elevator.this.serveRequest(request);
        }
    }

    private class ElevatorDoor {
        public void open() {
            System.out.println("Elevator with id :"+ elevatorId + " 's door opened at floor: "+ currentFloor);
        }

        public void close() {
            System.out.println("Elevator with id :"+ elevatorId + " 's door closed at floor: "+ currentFloor);
        }
    }
}
