package com.company;

import java.text.SimpleDateFormat;

public class Notification {
    public boolean sendMail(String emailId, String message, Meeting meeting) {
        //TODO send mail code

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
        System.out.println(message + " at time interval :" + simpleDateFormat.format(meeting.getStartTime())
                + " to "+ simpleDateFormat.format(meeting.getEndTime())
                + " with meeting room :"+ meeting.getRoom().getRoomName());
        System.out.println("Email Id: "+ emailId +", mail subject: "+ meeting.getSubject());
        return true;
    }
}
