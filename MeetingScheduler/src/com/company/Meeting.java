package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting {

    private Long meetingId;
    private String subject;
    private Date startTime;
    private Date endTime;
    private MeetingRoom room;
    private User organizer;
    private List<User> attendees;

    public Meeting(Long meetingId, String subject, Date startTime, Date endTime) {
        this.meetingId = meetingId;
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSubject() {
        return subject;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public MeetingRoom getRoom() {

        return room;
    }

    public void setRoom(MeetingRoom room) {
        this.room = room;
    }
}