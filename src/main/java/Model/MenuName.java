package Model;

import java.util.Objects;

public class MenuName {
    private String menuName;

    public MenuName(String menuName) {
        this.menuName = menuName;
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
