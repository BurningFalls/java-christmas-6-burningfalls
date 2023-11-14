package Model;

public class Customer {
    private VisitDay visitDay;
    private MenuItems menuItems;

    public Customer(VisitDay visitDay, MenuItems menuItems) {
        this.visitDay = visitDay;
        this.menuItems = menuItems;
    }

    public VisitDay getVisitDay() {
        return visitDay;
    }

    public MenuItems getMenuItems() {
        return menuItems;
    }
}
