package Controller;

import Enum.BadgeBoard;
import Enum.MenuBoard;
import Enum.MenuType;
import Model.*;
import Model.Events.*;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class ChristmasController {
    private Customer customer;
    private EventHistory eventHistory;
    private int totalCost = 0;
    private int giftDiscount = 0;
    private int eventsDiscount = 0;

    public void startPromotion() {
        readCustomersPlan();
        calculateBenefit();
        showEventPlanner();
    }

    public void readCustomersPlan() {
        OutputView.printGreeting();
        setCustomerInfo();
        OutputView.printEventNotice(customer.getVisitDay());
        OutputView.printMenuItems(customer.getMenuItems());
    }

    public void calculateBenefit() {
        eventSetting();
        totalCost = customer.calculateMenuItemsCost();
        if (totalCost < 10000) {
            return;
        }
        giftDiscount = eventHistory.calculateGiftDiscount();
        eventsDiscount = eventHistory.calculateEventsDiscount();
    }

    public void showEventPlanner() {
        int totalBenefit = giftDiscount + eventsDiscount;
        OutputView.printTotalCost(new Cost(totalCost));
        OutputView.printGiftHistory(eventHistory.getGiftEvent());
        OutputView.printDiscountHistory(eventHistory);
        OutputView.printTotalBenefit(new Cost(-totalBenefit));
        OutputView.printTotalBuyCost(new Cost(totalCost - eventsDiscount));
        showEventBadge(totalBenefit);
    }

    public void setCustomerInfo() {
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

        validateOnlyDrinks(menuItems);
        validateBiggerThan20(menuItems);

        return menuItems;
    }

    public void validateOnlyDrinks(List<Menu> menuItems) {
        int drinkCount = 0;
        for (Menu menu : menuItems) {
            MenuType menuType = MenuBoard.findType(menu);
            if (menuType == MenuType.DRINK) {
                drinkCount += 1;
            }
        }
        if (drinkCount == menuItems.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateBiggerThan20(List<Menu> menuItems) {
        int menuCount = 0;
        for (Menu menu : menuItems) {
            menuCount += menu.getCount();
        }
        if (menuCount > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateIsSameMenuExists(List<Menu> menuItems, Menu menuItem) {
        if (menuItems.contains(menuItem)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void eventSetting() {
        eventHistory = new EventHistory(List.of(
                new ChristmasDayEvent(customer.getVisitDay()),
                new WeekdayEvent(customer),
                new WeekendEvent(customer),
                new SpecialEvent(customer.getVisitDay())
        ),
                new GiftEvent(customer.calculateMenuItemsCost())
        );
    }

    public void showEventBadge(int totalBenefit) {
        String badgeName = BadgeBoard.getBadgeName(totalBenefit);
        OutputView.printEventBadge(new Badge(badgeName));
    }
}
