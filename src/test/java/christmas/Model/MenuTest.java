package christmas.Model;

import Model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuTest {
    Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu("티본스테이크-1");
    }

    @DisplayName("하이픈을 기준으로 메뉴 이름과 메뉴 개수 분리")
    @Test
    void splitMenuToNameAndCount() {
        String menuString = "티본스테이크-1";
        List<String> actualNameAndCount = List.of("티본스테이크", "1");
        List<String> expectedNameAndCount = menu.menuStringToNameAndCount(menuString);

        assertThat(actualNameAndCount).isEqualTo(expectedNameAndCount);
    }

    @DisplayName("하이픈을 기준으로 나눈 문자열의 개수가 2개가 아니면 예외 처리")
    @ValueSource(strings = {"티본스테이크1", "티본스테이크-1-2", "티본스테이크--1, -티본스테이크1, 티본스테이크1-, -티본스테이크1-"})
    @ParameterizedTest
    void splitListLengthNotTwo(String input) {
        assertThatThrownBy(() -> new Menu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
