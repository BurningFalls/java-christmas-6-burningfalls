package Model;

import java.util.Objects;

public class MenuCount {
    private int menuCount;

    public MenuCount(String menuCountString) {
        int menuCount = validateIsNumber(menuCountString);
        validateBiggerThanOne(menuCount);
        this.menuCount = menuCount;
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

    public void validateBiggerThanOne(int menuCount) {
        if (menuCount < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(menuCount);
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
