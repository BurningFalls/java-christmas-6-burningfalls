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

    public void calculateGiftDiscount() {
        Cost cost = giftEvent.calculateDiscount();
        giftDiscount = cost.get();
    }

    public void calculateEventsDiscount() {
        for (Event event : events) {
            Cost cost = event.calculateDiscount();
            eventsDiscount += cost.get();
        }
    }

    public GiftEvent getGiftEvent() {
        return giftEvent;
    }

    public int getEventsDiscount() {
        return eventsDiscount;
    }

    public int getTotalDiscount() {
        return giftDiscount + eventsDiscount;
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
            return "없음\n";
        }

        StringBuilder result = new StringBuilder();
        for (Event event : events) {
            addEventString(result, event);
        }
        addEventString(result, giftEvent);

        return result.toString();
    }
}
