package christmas.Model;

import Model.VisitDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VisitDayTest {

    @DisplayName("방문 날짜 입력값이 숫자가 아니면 예외 처리")
    @Test
    void visitDayNotNumber() {
        assertThatThrownBy(() -> new VisitDay("3day"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
