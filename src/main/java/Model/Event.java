package Model;

public class Event {

    public boolean isWeekday(VisitDay visitDay) {
        int day = visitDay.get();
        return 2 <= ((day - 1) % 7);
    }

    public int calculateDiscount() {
        return 0;
    }
}
