package com.company;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingScheduler {

    private Map<Long, MeetingRoom> meetingRooms = new HashMap<Long, MeetingRoom>();

    public boolean schedule(Long roomId, Meeting meeting) {
        MeetingRoom meetingRoom = meetingRooms.get(roomId);
        meeting.setRoom(meetingRoom);
        boolean bookingStatus = meetingRoom.book(meeting);
        if (bookingStatus) {
            List<User> attendees = meeting.getAttendees();
            for (User attendee : attendees) {
                new Notification().sendMail(attendee.getEmailId(), "Meeting booked successfully", meeting);
            }
        } else {
            User organizer = meeting.getOrganizer();
            new Notification().sendMail(organizer.getEmailId(), "Meeting booking failed", meeting);
        }
        return bookingStatus;
    }

    public boolean addRoom(MeetingRoom room) {
        return meetingRooms.put(room.getRoomId(), room) != null;
    }

    public boolean removeRoom(Long roomId) {
        return meetingRooms.remove(roomId) != null;
    }

}
