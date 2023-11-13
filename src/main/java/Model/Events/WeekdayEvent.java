package Model.Events;

import Model.Cost;
import Model.Customer;
import Model.Event;

public class WeekdayEvent extends Event {
    private static final int DISCOUNT = 2023;
    private Customer customer;
    private Cost discount;

    public WeekdayEvent(Customer customer) {
        super();
        this.customer = customer;
        discount = new Cost(0);
    }

    @Override
    public Cost calculateDiscount() {
        boolean weekdayFlag = isWeekday(customer.getVisitDay());
        if (weekdayFlag) {
            int dessertCount = customer.countDessert();
            discount = new Cost(dessertCount * DISCOUNT);
        }
        return discount;
    }

    @Override
    public String toString() {
        return "평일 할인: -" + discount.toString();
    }
}
