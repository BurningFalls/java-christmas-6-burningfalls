package View;

import Model.Cost;
import Model.EventHistory;
import Model.Events.GiftEvent;
import Model.Menu;
import Model.VisitDay;

import java.util.List;

public class OutputView {

    public static void printGreeting() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printEventNotice(VisitDay visitDay) {
        System.out.print("12월 ");
        System.out.print(visitDay);
        System.out.println("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
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
}
