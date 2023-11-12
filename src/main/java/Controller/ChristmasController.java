package Controller;

import Model.Customer;
import Model.Menu;
import Model.VisitDay;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class ChristmasController {
    Customer customer;

    public void startPromotion() {
        OutputView.printGreeting();
        VisitDay visitDay = readCustomerInfo();
        OutputView.printEventNotice(visitDay);
    }

    public VisitDay readCustomerInfo() {
        VisitDay customerVisitDay = readVisitDayInput();
        List<Menu> customerMenuItems = readMenuItemsInput();
        customer = new Customer(customerVisitDay, customerMenuItems);
        return customerVisitDay;
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

    public List<Menu> readMenuItemsInput() {
        List<Menu> menuItems = new ArrayList<>();
        boolean validFlag = false;

        while (!validFlag) {
            try {
                String menuItemsFromInput = InputView.inputMenu();
                menuItems = fetchMenuItems(menuItemsFromInput);
                validFlag = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return menuItems;
    }

    public List<Menu> fetchMenuItems(String menuItemsFromInput) {
        List<String> menuItemsString = List.of(menuItemsFromInput.split(","));
        List<Menu> menuItems = new ArrayList<>();

        for (String menuItemString : menuItemsString) {
            Menu menuItem = new Menu(menuItemString);
            menuItems.add(menuItem);
        }
        return menuItems;
    }
}
