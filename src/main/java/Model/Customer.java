package Model;

import Enum.MenuBoard;
import Enum.MenuType;

import java.util.List;

public class Customer {
    private VisitDay visitDay;
    private List<Menu> menuItems;

    public Customer(VisitDay visitDay, List<Menu> menuItems) {
        this.visitDay = visitDay;
        this.menuItems = menuItems;
    }

    public int calculateMenuItemsCost() {
        int totalMoney = 0;
        for (Menu menu : menuItems) {
            totalMoney += menu.getCost() * menu.getCount();
        }
        return totalMoney;
    }

    public int countDessert() {
        int cnt = 0;
        for (Menu menu : menuItems) {
            if (MenuBoard.findType(menu) == MenuType.DESSERT) {
                cnt += menu.getCount();
            }
        }
        return cnt;
    }

    public int countMain() {
        int cnt = 0;
        for (Menu menu : menuItems) {
            if (MenuBoard.findType(menu) == MenuType.MAIN) {
                cnt += menu.getCount();
            }
        }
        return cnt;
    }

    public VisitDay getVisitDay() {
        return visitDay;
    }

    public List<Menu> getMenuItems() {
        return menuItems;
    }
}
