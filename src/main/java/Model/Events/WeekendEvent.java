package Model.Events;

import Model.Cost;
import Model.Customer;
import Model.Event;

public class WeekendEvent extends Event {
    private static final int DISCOUNT = 2023;
    private Customer customer;
    private Cost discount;

    public WeekendEvent(Customer customer) {
        super();
        this.customer = customer;
        discount = new Cost(0);
    }

    @Override
    public Cost calculateDiscount() {
        boolean weekendFlag = !isWeekday(customer.getVisitDay());
        if (weekendFlag) {
            int mainCount = customer.countMain();
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
