package Model;

import java.util.List;

public class Customer {
    private VisitDay visitDay;
    private List<Menu> menuItems;

    public Customer(VisitDay visitDay, List<Menu> menuItems) {
        this.visitDay = visitDay;
        this.menuItems = menuItems;
    }
}
