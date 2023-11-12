package View;

import Model.VisitDay;

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
}
