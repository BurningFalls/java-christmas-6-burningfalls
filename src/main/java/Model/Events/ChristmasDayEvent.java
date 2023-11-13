package Model.Events;

import Model.Cost;
import Model.Event;
import Model.VisitDay;

public class ChristmasDayEvent extends Event {
    private VisitDay visitday;
    private Cost discount;

    public ChristmasDayEvent(VisitDay visitday) {
        super();
        this.visitday = visitday;
        discount = new Cost(0);
    }

    @Override
    public Cost calculateDiscount() {
        int day = visitday.get();
        if (day <= 25) {
            discount = new Cost(1000 + (day - 1) * 100);
        }
        return discount;
    }

    @Override
    public String toString() {
        if (discount.noCost()) {
            return "";
        }
        return "크리스마스 디데이 할인: -" + discount.toString();
    }
}
