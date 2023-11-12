package christmas.Controller;

import Controller.ChristmasController;
import Model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChristmasControllerTest {
    ChristmasController christmasController;

    @BeforeEach
    void setUp() {
        christmasController = new ChristmasController();
    }

    @DisplayName("메뉴리스트 콤마 기준으로 분리")
    @Test
    void splitStringToMenuItems() {
        String menuItemsFromInput = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        List<Menu> actualMenuItems = christmasController.fetchMenuItems(menuItemsFromInput);
        List<Menu> expectedMenuItems = List.of(
                new Menu("티본스테이크-1"),
                new Menu("바비큐립-1"),
                new Menu("초코케이크-2"),
                new Menu("제로콜라-1")
        );

        assertThat(actualMenuItems).isEqualTo(expectedMenuItems);
    }

    @DisplayName("메뉴 이름이 중복되면 예외 처리")
    @Test
    void menuNameDuplicate() {
        assertThatThrownBy(() -> christmasController.validateIsSameMenuExists(
                List.of(
                        new Menu("티본스테이크-1"),
                        new Menu("바비큐립-1"),
                        new Menu("초코케이크-2"),
                        new Menu("제로콜라-1")
                ), new Menu("초코케이크-1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
