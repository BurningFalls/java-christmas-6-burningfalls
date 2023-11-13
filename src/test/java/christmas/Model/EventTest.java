package christmas.Model;

import Model.Events.ChristmasDayEvent;
import Model.VisitDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

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
}
