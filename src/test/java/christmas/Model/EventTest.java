package christmas.Model;

import Model.Customer;
import Model.Event;
import Model.Events.ChristmasDayEvent;
import Model.Events.WeekdayEvent;
import Model.Menu;
import Model.VisitDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {
    private static final int DISCOUNT = 2023;

    private static Customer weekdayCustomer;
    private static Customer weekendCustomer;
    private static Customer starCustomer;

    @BeforeEach
    void setUp() {
        weekdayCustomer = createCustomer("5");
        weekendCustomer = createCustomer("9");
        starCustomer = createCustomer("24");
    }

    private Customer createCustomer(String day) {
        return new Customer(
                new VisitDay(day),
                List.of(
                        new Menu("티본스테이크-1"), new Menu("바비큐립-1"),
                        new Menu("초코케이크-2"), new Menu("제로콜라-1")
                )
        );
    }

    @DisplayName("평일인지 확인")
    @CsvSource({
            "1, false", "2, false",
            "3, true", "14, true",
            "25, true", "29, false",
            "30, false", "31, true"
    })
    @ParameterizedTest
    void checkIfWeekday(String day, boolean expectedFlag) {
        boolean actualFlag = new Event().isWeekday(new VisitDay(day));

        assertThat(actualFlag).isEqualTo(expectedFlag);
    }

    @DisplayName("크리스마스 이벤트 할인 계산")
    @CsvSource({
            "1, 1000",
            "2, 1100",
            "3, 1200",
            "25, 3400",
            "26, 0"
    })
    @ParameterizedTest
    void calculateChristmasDayDiscount(String day, int expectedDiscount) {
        ChristmasDayEvent event = new ChristmasDayEvent(new VisitDay(day));
        int actualDiscount = event.calculateDiscount();

        assertThat(actualDiscount).isEqualTo(expectedDiscount);
    }

    @DisplayName("평일 이벤트 할인 계산")
    @Test
    void calculateWeekdayDiscount() {
        WeekdayEvent weekdayEvent = new WeekdayEvent(weekdayCustomer);
        int actualDiscount = weekdayEvent.calculateDiscount();
        int expectedDiscount = DISCOUNT * 2;

        assertThat(actualDiscount).isEqualTo(expectedDiscount);
    }
}
