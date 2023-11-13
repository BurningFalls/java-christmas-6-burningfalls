package christmas.Model;

import Enum.MenuBoard;

import Enum.MenuType;
import Model.Menu;
import Model.MenuName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuBoardTest {

    @DisplayName("메뉴 이름에 해당하는 메뉴의 가격 가져오기")
    @CsvSource({
            "양송이수프, 6000",
            "초코케이크, 15000",
            "샴페인, 25000",
            "티본스테이크, 55000"
    })
    @ParameterizedTest
    void findMenuCostWithMenuName(String menuName, int expectedCost) {
        int actualCost = MenuBoard.findCost(new MenuName(menuName));

        assertThat(actualCost).isEqualTo(expectedCost);
    }

    @DisplayName("메뉴 이름에 해당하는 메뉴의 타입 가져오기")
    @CsvSource({
            "양송이수프-1, EPITIZER",
            "초코케이크-1, DESSERT",
            "샴페인-1, DRINK",
            "티본스테이크-1, MAIN"
    })
    @ParameterizedTest
    void findMenuTypeWithMenuName(String menuName, String expectedMenuType) {
        MenuType actualType = MenuBoard.findType(new Menu(menuName));
        MenuType expectedType = MenuType.findType(expectedMenuType);
        assertThat(actualType).isEqualTo(expectedType);
    }
}
