package Model.Events;

import Model.Customer;
import Model.Event;

public class WeekendEvent extends Event {
    private static final int DISCOUNT = 2023;

    private Customer customer;

    public WeekendEvent(Customer customer) {
        super();
        this.customer = customer;
    }

    @Override
    public int calculateDiscount() {
        boolean weekendFlag = !isWeekday(customer.getVisitDay());
        if (!weekendFlag) {
            return 0;
        }

        int mainCount = customer.countMain();
        return mainCount * DISCOUNT;
    }
}
