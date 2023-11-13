package Model.Events;

import Model.Customer;
import Model.Event;

public class WeekdayEvent extends Event {
    private static final int DISCOUNT = 2023;

    private Customer customer;

    public WeekdayEvent(Customer customer) {
        super();
        this.customer = customer;
    }

    @Override
    public int calculateDiscount() {
        boolean weekdayFlag = isWeekday(customer.getVisitDay());
        if (!weekdayFlag) {
            return 0;
        }

        int dessertCount = customer.countDessert();
        return dessertCount * DISCOUNT;
    }
}
