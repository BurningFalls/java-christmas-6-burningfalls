package Controller;

import Model.*;
import Model.Events.*;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class ChristmasController {
    Customer customer;
    EventHistory eventHistory;

    public void startPromotion() {
        OutputView.printGreeting();
        readCustomerInfo();
        printDayEventNotice();
        printOrderedMenuItems();

        int money = calculateDiscountedMoney();
    }

    public void readCustomerInfo() {
        VisitDay customerVisitDay = readVisitDayInput();
        List<Menu> customerMenuItems = readMenuItemsInput();
        customer = new Customer(customerVisitDay, customerMenuItems);
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
            validateIsSameMenuExists(menuItems, menuItem);
            menuItems.add(menuItem);
        }
        return menuItems;
    }

    public void validateIsSameMenuExists(List<Menu> menuItems, Menu menuItem) {
        if (menuItems.contains(menuItem)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void printDayEventNotice() {
        OutputView.printEventNotice(customer.getVisitDay());
    }

    public void printOrderedMenuItems() {
        System.out.println("\n<주문 메뉴>");
        OutputView.printMenuItems(customer.getMenuItems());
    }

    public int calculateDiscountedMoney() {
        int totalMoney = calculateTotalMoney();
        int totalDiscount = calculateTotalDiscount();
        return totalMoney - totalDiscount;
    }

    public int calculateTotalMoney() {
        return customer.calculateMenuItemsCost();
    }

    public int calculateTotalDiscount() {
        eventSetting();
        return eventHistory.calculateEventsDiscount();
    }

    public void eventSetting() {
        eventHistory = new EventHistory(List.of(
                new ChristmasDayEvent(customer.getVisitDay()),
                new WeekdayEvent(customer),
                new WeekendEvent(customer),
                new SpecialEvent(customer.getVisitDay()),
                new GiftEvent(customer.calculateMenuItemsCost())
        ));
    }
}
