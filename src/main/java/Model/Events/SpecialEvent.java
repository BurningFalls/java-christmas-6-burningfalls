package Model.Events;

import Model.Event;
import Model.VisitDay;

import java.util.List;

public class SpecialEvent extends Event {
    private static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
    private VisitDay visitDay;

    public SpecialEvent(VisitDay visitDay) {
        super();
        this.visitDay = visitDay;
    }

    @Override
    public int calculateDiscount() {
        if (SPECIAL_DAYS.contains(visitDay.get())) {
            return 1000;
        }
        return 0;
    }
}
