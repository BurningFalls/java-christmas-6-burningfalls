package Model;

import Enum.MenuBoard;
import Enum.MenuType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuItems {
    private List<Menu> menuItems;
    int totalCost = 0;

    public MenuItems(List<Menu> menuItems) {
        validate(menuItems);
        this.menuItems = menuItems;
    }

    public void validate(List<Menu> menuItems) {
        validateOnlyDrinks(menuItems);
        validateBiggerThan20(menuItems);
        validateIsSameMenuExists(menuItems);
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

    public void validateIsSameMenuExists(List<Menu> menuItems) {
        Set<Menu> menuSet = new HashSet<>();
        boolean duplicateFlag = false;
        for(Menu menu : menuItems) {
            if (!menuSet.add(menu)) {
                duplicateFlag = true;
                break;
            }
        }
        if (duplicateFlag) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void calculateMenuItemsCost() {
        for (Menu menu : menuItems) {
            totalCost += menu.getCost() * menu.getCount();
        }
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

    public int getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Menu menu : menuItems) {
            String menuString = menu.toString();
            result.append(menuString).append("\n");
        }
        return result.toString();
    }
}
