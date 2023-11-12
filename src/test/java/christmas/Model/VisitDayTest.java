package christmas.Model;

import Model.VisitDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VisitDayTest {

    @DisplayName("방문 날짜 입력값이 숫자가 아니면 예외 처리")
    @ValueSource(strings = {"3day", "number", "1a5", "abed"})
    @ParameterizedTest
    void visitDayNotNumber() {
        assertThatThrownBy(() -> new VisitDay("3day"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("방문 날짜 입력값이 1 이상 31 이하가 아니면 예외 처리")
    @ValueSource(strings = {"-1", "0", "33", "123"})
    @ParameterizedTest
    void visitDay1To31(String input) {
        assertThatThrownBy(() -> new VisitDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
