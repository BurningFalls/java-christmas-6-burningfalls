package Controller;

import Model.Customer;
import Model.VisitDay;
import View.InputView;
import View.OutputView;

public class ChristmasController {
    Customer customer;

    public void startPromotion() {
        OutputView.printGreeting();
        readCustomerInfo();
    }

    public void readCustomerInfo() {
        VisitDay customerVisitDay = readVisitDayInput();
        customer = new Customer(customerVisitDay);
        // readMenuInput();
    }

    public VisitDay readVisitDayInput() {
        String visitDay = InputView.inputVisitDay();
        return new VisitDay(visitDay);
    }
}
