package Model;

import java.util.Objects;

public class MenuCount {
    private int menuCount;

    public MenuCount(String menuCountString) {
        this.menuCount = validateIsNumber(menuCountString);
    }

    public int validateIsNumber(String menuCountString) {
        int menuCountInt = 0;
        try {
            menuCountInt = Integer.parseInt(menuCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return menuCountInt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MenuCount other = (MenuCount) obj;
        return menuCount == other.menuCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menuCount);
    }
}
