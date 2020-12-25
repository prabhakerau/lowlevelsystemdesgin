package com.company;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {

    private Long roomId;
    private String roomName;
    private List<Meeting> meetings;

    public MeetingRoom(Long roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.meetings = new ArrayList<>();
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean book(Meeting meeting) {
        if(isAvailable(meeting)) {
            meetings.add(meeting);
            return true;
        }
        return false;
    }

    public boolean isAvailable(Meeting newMeeting) {
        for(Meeting existingMeeting : meetings) {
            if(existingMeeting.getEndTime().getTime() > newMeeting.getStartTime().getTime() &&
                    existingMeeting.getStartTime().getTime() < newMeeting.getEndTime().getTime() ) {
                return false;
            }
        }
        return true;
    }
}
