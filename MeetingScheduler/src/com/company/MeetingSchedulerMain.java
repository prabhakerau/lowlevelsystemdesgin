package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingSchedulerMain {

    public static void main(String[] args) throws ParseException {

        //Meeting room creation
        MeetingRoom meetingRoom1 = new MeetingRoom(1L, "Room1");
        MeetingRoom meetingRoom2 = new MeetingRoom(2L, "Room2");

        //Users creation
        User user1 = new User(1L,"user1", "user1@user.com");
        User user2 = new User(2L, "user2", "user2@user.com");
        User user3 = new User(3L, "user3", "user3@user.com");
        User user4 = new User(4L, "user4", "user4@user.com");
        User user5 = new User(5L, "user5", "user5@user.com");

        //attendees
        List<User> attendees = new ArrayList<User>();
        attendees.add(user4);
        attendees.add(user5);

        //creation of meeting1
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
        Meeting meeting1 = new Meeting(1L, "Meeting 1", simpleDateFormat.parse("10:00 am"), simpleDateFormat.parse("11:00 am"));
        meeting1.setOrganizer(user1);
        meeting1.setAttendees(attendees);

        //creation of meeting2
        Meeting meeting2 = new Meeting(2L, "Meeting 2", simpleDateFormat.parse("10:30 am"), simpleDateFormat.parse("12:00 pm"));
        meeting2.setOrganizer(user2);
        meeting2.setAttendees(attendees);

        //creation of meeting3
        Meeting meeting3 = new Meeting(3L, "Meeting 3", simpleDateFormat.parse("11:00 am"), simpleDateFormat.parse("12:00 pm"));
        meeting3.setOrganizer(user3);
        meeting3.setAttendees(attendees);

        //creation of meeting scheduler
        MeetingScheduler meetingScheduler = new MeetingScheduler();

        //adding meeting room 1
        meetingScheduler.addRoom(meetingRoom1);

        //adding meeting room 2
        meetingScheduler.addRoom(meetingRoom2);

        //schedule meeting1 on 1st room for the user1
        System.out.println("========================================================================================");
        meetingScheduler.schedule(1L, meeting1);
        System.out.println("========================================================================================");

        //schedule meeting2 on 1st room for user2
        System.out.println("========================================================================================");
        meetingScheduler.schedule(1L, meeting2);
        System.out.println("========================================================================================");

        //schedule meeting3 on 2nd room for the user3
        System.out.println("========================================================================================");
        meetingScheduler.schedule(2L, meeting3);
        System.out.println("========================================================================================");

    }
}
