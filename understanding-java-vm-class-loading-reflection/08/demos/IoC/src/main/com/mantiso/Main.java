package com.mantiso;

//import com.mantiso.Drivable;

import com.pluralsight.Container;
import com.pluralsight.IoCException;

public class Main {

    public static void main(String[] args) {
        try {
            Container container = new Container("config.json");
            com.mantiso.IMeeting meeting = container.resolve(com.mantiso.IMeeting.class);
            meeting.getMeeting();
            for (String attendee : meeting.getAttendees()) {
                System.out.println(attendee);
            }
        } catch (IoCException e) {
            e.printStackTrace();
        }
    }
}

