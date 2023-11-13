package Model.Events;

import Enum.MenuBoard;
import Model.Cost;
import Model.Event;
import Model.MenuName;

public class GiftEvent extends Event {
    private static final int MINIMUM_COST = 120000;
    private int totalCost;
    private Cost discount;

    public GiftEvent(int totalCost) {
        this.totalCost = totalCost;
        discount = new Cost(0);
    }

    public boolean isGifted() {
        return !discount.noCost();
    }

    @Override
    public Cost calculateDiscount() {
        if (totalCost >= MINIMUM_COST) {
            discount = new Cost(MenuBoard.findCost(new MenuName("샴페인")));
        }
        return discount;
    }

    @Override
    public String toString() {
        return "증정 이벤트: -" + discount.toString();
    }
}
