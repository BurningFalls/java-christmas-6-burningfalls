package Model.Events;

import Model.Event;
import Model.VisitDay;

public class ChristmasDayEvent extends Event {
    private VisitDay visitday;

    public ChristmasDayEvent(VisitDay visitday) {
        super();
        this.visitday = visitday;
    }

    @Override
    public int calculateDiscount() {
        int day = visitday.get();
        if (day > 25) {
            return 0;
        }
        return 1000 + (day - 1) * 100;
    }
}
