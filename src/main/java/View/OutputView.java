package View;

import Model.*;
import Model.Events.GiftEvent;

public class OutputView {

    public static void printGreeting() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printEventNotice(VisitDay visitDay) {
        System.out.println("12월 " + visitDay.toString() + "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printMenuItems(MenuItems menuItems) {
        System.out.println("\n<주문 메뉴>");
        System.out.println(menuItems);
    }

    public static void printTotalCost(int totalCost) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(new Cost(totalCost));
    }

    public static void printGiftHistory(GiftEvent giftEvent) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(giftEvent.toStringMenu());

    }

    public static void printDiscountHistory(EventHistory eventHistory) {
        System.out.println("\n<혜택 내역>");
        System.out.println(eventHistory);
    }

    public static void printTotalDiscount(int totalBenefit) {
        System.out.println("<총혜택 금액>");
        System.out.println(new Cost(-totalBenefit));
    }

    public static void printTotalBuyCost(int buyCost) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(new Cost(buyCost));
    }

    public static void printEventBadge(Badge badge) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
