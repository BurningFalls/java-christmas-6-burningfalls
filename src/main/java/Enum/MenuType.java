package Enum;

public enum MenuType {
    EPITIZER, MAIN, DESSERT, DRINK;

    public static MenuType findType(String type) {
        for (MenuType menuType : MenuType.values()) {
            if (menuType.name().equals(type)) {
                return menuType;
            }
        }
        return null;
    }
}
