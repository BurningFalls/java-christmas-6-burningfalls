package Model.Events;

import Model.*;

public class WeekdayEvent extends Event {
    private static final int DISCOUNT = 2023;
    private VisitDay visitDay;
    private MenuItems menuItems;
    private Cost discount;

    public WeekdayEvent(VisitDay visitDay, MenuItems menuItems) {
        super();
        this.visitDay = visitDay;
        this.menuItems = menuItems;
        discount = new Cost(0);
    }

    @Override
    public Cost calculateDiscount() {
        boolean weekdayFlag = isWeekday(visitDay);
        if (weekdayFlag) {
            int dessertCount = menuItems.countDessert();
            discount = new Cost(dessertCount * DISCOUNT);
        }
        return discount;
    }

    @Override
    public String toString() {
        if (discount.noCost()) {
            return "";
        }
        return "평일 할인: -" + discount.toString();
    }
}
