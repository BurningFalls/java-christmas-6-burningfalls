package Model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private MenuName menuName;
    private MenuCount menuCount;

    public Menu(String menuString) {
        List<String> menuNameAndCount = menuStringToNameAndCount(menuString);
        this.menuName = new MenuName(menuNameAndCount.get(0));
        this.menuCount = new MenuCount(menuNameAndCount.get(1));
    }

    public List<String> menuStringToNameAndCount(String MenuString) {
        return List.of(MenuString.split("-"));
    }
}
