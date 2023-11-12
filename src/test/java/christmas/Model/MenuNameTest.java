package christmas.Model;

import Model.MenuName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuNameTest {

    @DisplayName("메뉴 이름이 메뉴판에 없으면 예외 처리")
    @ValueSource(strings = {"화이트와인", "알리오올리오", "157389", "양송이수프1"})
    @ParameterizedTest
    void menuNameNotInMenuBoard(String input) {
        assertThatThrownBy(() -> new MenuName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
