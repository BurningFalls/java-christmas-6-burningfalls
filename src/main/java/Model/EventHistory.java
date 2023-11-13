package Model;

import java.util.List;

public class EventHistory {
    List<Event> events;

    public EventHistory(List<Event> events) {
        this.events = events;
    }

    public int calculateEventsDiscount() {
        int totalDiscount = 0;
        for (Event event : events) {
            totalDiscount += event.calculateDiscount();
        }
        return totalDiscount;
    }
}
