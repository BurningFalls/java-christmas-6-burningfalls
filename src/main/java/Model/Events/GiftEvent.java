package Model.Events;

import Enum.MenuBoard;
import Model.Event;
import Model.MenuName;

public class GiftEvent extends Event {
    private static final int MINIMUM_COST = 120000;
    private int totalCost;

    public GiftEvent(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public int calculateDiscount() {
        if (totalCost >= MINIMUM_COST) {
            return MenuBoard.findCost(new MenuName("샴페인"));
        }
        return 0;
    }
}
