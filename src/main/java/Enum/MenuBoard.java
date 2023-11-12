package Enum;

public enum MenuBoard {
    MUSHROOM_SOUP("양송이수프", 6000, MenuType.EPITIZER),
    TAPAS("타파스", 5500, MenuType.EPITIZER),
    SEZER_SALAD("시저샐러드", 8000, MenuType.EPITIZER),
    TIBON_STAKE("티본스테이크", 55000, MenuType.MAIN),
    BARBIQUE_LEAP("바비큐립", 54000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuType.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuType.DESSERT),
    ICECREAM("아이스크림", 5000, MenuType.DESSERT),
    ZERO_COKE("제로콜라", 3000, MenuType.DRINK),
    RED_WINE("레드와인", 60000, MenuType.DRINK),
    SHAMPAINE("샴페인", 25000, MenuType.DRINK);

    private String menuName;
    private int menuCost;
    private MenuType menuType;

    private MenuBoard(String menuName, int menuCost, MenuType menuType) {
        this.menuName = menuName;
        this.menuCost = menuCost;
        this.menuType = menuType;
    }

    public static int findCost(String menuName) {
        for (MenuBoard menu : MenuBoard.values()) {
            if (menu.menuName.equals(menuName)) {
                return menu.menuCost;
            }
        }
        return -1;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuCost() {
        return menuCost;
    }
}
