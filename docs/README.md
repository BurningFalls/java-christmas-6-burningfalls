# 미션 - 크리스마스 프로모션

## 출력 예시

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```

## 기능 목록

- [X] 식당 방문인사 문구 출력 OutputView.*printGreeting*
- [X] 방문 날짜 입력받기 InputView.*inputVisitDay*
- [X] 방문 날짜가 숫자인지 확인 VisitDay.*validateIsNumber*
- [X] 방문 날짜가 1 이상 31 이하인지 확인 VisitDay.*validate1To31*
- [X] 주문할 메뉴와 개수 입력받기 InputView.*inputMenu*
- [X] 메뉴 이름이 메뉴판에 있는 메뉴인지 확인 Menu.*validateMenuName*
- [] 메뉴 이름을 중복해서 입력했는지 확인 Menu.*validateDuplicate*
- [X] 메뉴 개수가 숫자인지 확인 Menu.*validateIsNumber*
- [X] 메뉴 개수가 1 이상인지 확인 Menu.*validateBiggerThanOne*
- [X] 식당 이벤트 공지 출력 OutputView.*printEventNotice*
- [] 주문한 메뉴와 개수 출력 OutputView.*printMenu*
- [] 총주문 금액 계산 christmasController.*calculateTotalMoney*
- [] 모든 할인 금액 계산 christmasController.*calculateTotalDiscount*
- [] 크리스마스 디데이 할인 금액 계산 christmasDayEvent.*calculateDiscount*
- [] 평일 할인 금액 계산 weekdayEvent.*calculateDiscount*
- [] 주말 할인 금액 계산 weekendEvent.*calculateDiscount*
- [] 특별 할인 금액 계산 specialEvent.*calculateDiscount*
- [] 증정 이벤트 금액 계산 giftEvent.*calculateDiscount*
- [] 이벤트 배지 부여 EventBadge.*giveBadge*
- [] 이벤트 내역 출력 OutputView.*printEventHistory*
















