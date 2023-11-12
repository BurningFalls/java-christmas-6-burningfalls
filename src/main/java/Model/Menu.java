package Model;

import java.util.List;
import java.util.Objects;

public class Menu {
    private MenuName menuName;
    private MenuCount menuCount;

    public Menu(String menuString) {
        List<String> menuNameAndCount = menuStringToNameAndCount(menuString);
        this.menuName = new MenuName(menuNameAndCount.get(0));
        this.menuCount = new MenuCount(menuNameAndCount.get(1));
    }

    public List<String> menuStringToNameAndCount(String menuString) {
        List<String> menuNameAndCount = List.of(menuString.split("-"));
        if (menuNameAndCount.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return List.of(menuString.split("-"));
    }

    @Override
    public String toString() {
        return menuName + " " + menuCount + "개";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Menu other = (Menu) obj;
        return menuName.equals(other.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName);
    }
}
