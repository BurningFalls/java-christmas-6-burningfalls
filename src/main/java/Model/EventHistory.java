package Model;

import Model.Events.GiftEvent;

import java.util.List;

public class EventHistory {
    private List<Event> events;
    private int totalDiscount = 0;

    public EventHistory(List<Event> events) {
        this.events = events;
    }

    public int calculateEventsDiscount() {
        for (Event event : events) {
            Cost cost = event.calculateDiscount();
            totalDiscount += cost.get();
        }
        return totalDiscount;
    }

    public GiftEvent getGiftEvent() {
        for (Event event : events) {
            if (event instanceof GiftEvent) {
                return (GiftEvent) event;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (totalDiscount == 0) {
            return "없음";
        }
        StringBuilder result = new StringBuilder();
        for (Event event : events) {
            String eventString = event.toString();
            if (!eventString.isEmpty()) {
                result.append(event.toString()).append("\n");
            }
        }
        return result.toString();
    }
}
