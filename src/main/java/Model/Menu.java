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
        return List.of(menuString.split("-"));
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
        return menuName.equals(other.menuName) && menuCount.equals(other.menuCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName, menuCount);
    }
}
