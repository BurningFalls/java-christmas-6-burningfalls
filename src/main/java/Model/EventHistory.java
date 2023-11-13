package Model;

import java.util.List;

public class EventHistory {
    private List<Event> events;
    private List<Integer> discounts;

    public EventHistory(List<Event> events) {
        this.events = events;
    }

    public int calculateEventsDiscount() {
        int totalDiscount = 0;
        for (Event event : events) {
            int discount = event.calculateDiscount();
            discounts.add(discount);
            totalDiscount += discount;
        }
        return totalDiscount;
    }
}
