package Controller;

import Enum.BadgeBoard;
import Model.*;
import Model.Events.*;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class ChristmasController {
    private VisitDay visitDay;
    private MenuItems menuItems;
    private EventHistory eventHistory;

    public void startPromotion() {
        readCustomersPlan();
        calculateBenefit();
        showEventPlanner();
    }

    public void readCustomersPlan() {
        OutputView.printGreeting();
        setCustomerInfo();
        OutputView.printEventNotice(visitDay);
        OutputView.printMenuItems(menuItems);
    }

    public void calculateBenefit() {
        menuItems.calculateMenuItemsCost();
        eventSetting();
        if (menuItems.getTotalCost() < 10000) {
            return;
        }

        eventHistory.calculateGiftDiscount();
        eventHistory.calculateEventsDiscount();
    }

    public void showEventPlanner() {
        OutputView.printTotalCost(menuItems.getTotalCost());
        OutputView.printGiftHistory(eventHistory.getGiftEvent());
        OutputView.printDiscountHistory(eventHistory);
        OutputView.printTotalDiscount(eventHistory.getTotalDiscount());
        OutputView.printTotalBuyCost(menuItems.getTotalCost() - eventHistory.getEventsDiscount());
        showEventBadge();
    }

    public void setCustomerInfo() {
        visitDay = readVisitDayInput();
        menuItems = readMenuItemsInput();
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

    public MenuItems readMenuItemsInput() {
        MenuItems menuItems = null;
        boolean validFlag = false;

        while (!validFlag) {
            try {
                String menuItemsFromInput = InputView.inputMenu();
                menuItems = new MenuItems(fetchMenuItems(menuItemsFromInput));
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

    public void eventSetting() {
        eventHistory = new EventHistory(List.of(
                new ChristmasDayEvent(visitDay),
                new WeekdayEvent(visitDay, menuItems),
                new WeekendEvent(visitDay, menuItems),
                new SpecialEvent(visitDay)
        ),
                new GiftEvent(menuItems.getTotalCost())
        );
    }

    public void showEventBadge() {
        String badgeName = BadgeBoard.getBadgeName(eventHistory.getTotalDiscount());
        OutputView.printEventBadge(new Badge(badgeName));
    }
}
