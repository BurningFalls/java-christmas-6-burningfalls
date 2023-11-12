package christmas.Model;

import Model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
