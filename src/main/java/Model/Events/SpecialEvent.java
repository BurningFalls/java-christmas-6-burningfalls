package Model.Events;

import Model.Cost;
import Model.Event;
import Model.VisitDay;

import java.util.List;

public class SpecialEvent extends Event {
    private static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
    private VisitDay visitDay;
    private Cost discount;

    public SpecialEvent(VisitDay visitDay) {
        super();
        this.visitDay = visitDay;
        discount = new Cost(0);
    }

    @Override
    public Cost calculateDiscount() {
        if (SPECIAL_DAYS.contains(visitDay.get())) {
            discount = new Cost(1000);
        }
        return discount;
    }

    @Override
    public String toString() {
        return "특별 할인: -" + discount.toString();
    }
}
