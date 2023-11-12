package christmas.Model;

import Model.MenuCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuCountTest {

    @DisplayName("메뉴 개수가 숫자가 아니면 예외 처리")
    @ValueSource(strings = {"5e3", "menu", "abed", "1 3"})
    @ParameterizedTest
    void menuCountIsNumber(String input) {
        assertThatThrownBy(() -> new MenuCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 개수가 1개 이상이 아니면 예외 처리")
    @ValueSource(strings = {"0", "-5", "-123", "-1"})
    @ParameterizedTest
    void menuCountBiggerThanOne(String input) {
        assertThatThrownBy(() -> new MenuCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
