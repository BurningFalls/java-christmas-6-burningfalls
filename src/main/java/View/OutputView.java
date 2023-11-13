package View;

import Model.*;
import Model.Events.GiftEvent;

import java.util.List;

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

    public static void printMenuItems(List<Menu> menuItems) {
        System.out.println("\n<주문 메뉴>");
        for (Menu menuItem : menuItems) {
            System.out.println(menuItem);
        }
    }

    public static void printTotalCost(Cost totalCost) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(totalCost);
    }

    public static void printGiftHistory(GiftEvent giftEvent) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(giftEvent.toStringMenu());

    }

    public static void printDiscountHistory(EventHistory eventHistory) {
        System.out.println("\n<혜택 내역>");
        System.out.println(eventHistory);
    }

    public static void printTotalBenefit(Cost totalBenefit) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(totalBenefit);
    }

    public static void printTotalBuyCost(Cost buyCost) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(buyCost);
    }

    public static void printEventBadge(Badge badge) {
        System.out.println("\n12월 이벤트 배지");
        System.out.println(badge);
    }
}
