package Model;

import Enum.MenuBoard;

import java.util.Objects;

public class MenuName {
    private String menuName;

    public MenuName(String menuName) {
        menuName = menuName.strip();
        validateMenuName(menuName);
        this.menuName = menuName;
    }

    public void validateMenuName(String menuName) {
        boolean validFlag = false;
        for (MenuBoard menu : MenuBoard.values()) {
            String menuBoardMenuName = menu.getMenuName();
            if (menuBoardMenuName.equals(menuName)) {
                validFlag = true;
                break;
            }
        }
        if (!validFlag) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    @Override
    public String toString() {
        return menuName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MenuName other = (MenuName) obj;
        return menuName.equals(other.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menuName);
    }
}
