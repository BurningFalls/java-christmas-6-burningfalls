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
        VisitDay visitDay = null;
        boolean validFlag = false;

        while (!validFlag) {
            try {
                String visitDayFromInput = InputView.inputVisitDay();
                visitDay = new VisitDay(visitDayFromInput);
                validFlag = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return visitDay;
    }
}
