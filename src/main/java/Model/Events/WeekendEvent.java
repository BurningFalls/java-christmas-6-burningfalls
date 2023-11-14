package Model.Events;

import Model.*;

public class WeekendEvent extends Event {
    private static final int DISCOUNT = 2023;
    private VisitDay visitDay;
    private MenuItems menuItems;
    private Cost discount;

    public WeekendEvent(VisitDay visitDay, MenuItems menuItems) {
        super();
        this.visitDay = visitDay;
        this.menuItems = menuItems;
        discount = new Cost(0);
    }

    @Override
    public Cost calculateDiscount() {
        boolean weekendFlag = !isWeekday(visitDay);
        if (weekendFlag) {
            int mainCount = menuItems.countMain();
            discount = new Cost(mainCount * DISCOUNT);
        }
        return discount;
    }

    @Override
    public String toString() {
        if (discount.noCost()) {
            return "";
        }
        return "주말 할인: -" + discount.toString();
    }
}
