package com.lld.questions;

import java.util.ArrayList;
import java.util.List;

public class Request implements Comparable<Request>{

    private long requestId;
    private List<Integer> desiredFloors = new ArrayList<>();

    public Request(long requestId) {
        this.requestId = requestId;
    }

    public long getRequestId() {
        return requestId;
    }

    public List<Integer> getDesiredFloors() {
        return desiredFloors;
    }

    public void addDesiredFloor(int desiredFloor) {
        desiredFloors.add(desiredFloor);
    }

    @Override
    public int compareTo(Request request) {
        return (int) (request.getRequestId() - this.getRequestId());
    }
}
