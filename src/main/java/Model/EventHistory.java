package Model;

import Model.Events.GiftEvent;

import java.util.List;

public class EventHistory {
    private List<Event> events;
    private GiftEvent giftEvent;
    private int giftDiscount = 0;
    private int eventsDiscount = 0;

    public EventHistory(List<Event> events, GiftEvent giftEvent) {
        this.events = events;
        this.giftEvent = giftEvent;
    }

    public int calculateGiftDiscount() {
        Cost cost = giftEvent.calculateDiscount();
        giftDiscount = cost.get();
        return giftDiscount;
    }

    public int calculateEventsDiscount() {
        for (Event event : events) {
            Cost cost = event.calculateDiscount();
            eventsDiscount += cost.get();
        }
        return eventsDiscount;
    }

    public GiftEvent getGiftEvent() {
        return giftEvent;
    }

    public boolean validateEventString(String eventString) {
        return !eventString.isEmpty();
    }

    public void addEventString(StringBuilder result, Event event) {
        String eventString = event.toString();
        if (validateEventString(eventString)) {
            result.append(eventString).append("\n");
        }
    }

    @Override
    public String toString() {
        if (giftDiscount + eventsDiscount == 0) {
            return "없음";
        }

        StringBuilder result = new StringBuilder();
        for (Event event : events) {
            addEventString(result, event);
        }
        addEventString(result, giftEvent);

        return result.toString();
    }
}
