package christmas.Model;

import Model.Menu;
import Model.MenuItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuItemsTest {
    MenuItems sampleMenuItems;

    @BeforeEach
    void setUp() {
        sampleMenuItems = new MenuItems(List.of(
                new Menu("티본스테이크-1"),
                new Menu("바비큐립-1"),
                new Menu("초코케이크-2"),
                new Menu("제로콜라-1")
        ));
    }

    @DisplayName("메뉴 이름이 중복되면 예외 처리")
    @Test
    void menuNameDuplicate() {
        List<Menu> menuItems = List.of(new Menu("바비큐립-1"), new Menu("바비큐립-3"));

        assertThatThrownBy(() -> new MenuItems(menuItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("음료수만 주문 시 예외 처리")
    @Test
    void orderOnlyDrinks() {
        List<Menu> menuItems = List.of(new Menu("제로콜라-3"), new Menu("레드와인-1"));

        assertThatThrownBy(() -> new MenuItems(menuItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 20개 초과 주문 시 예외 처리")
    @Test
    void orderUpTo20() {
        List<Menu> menuItems = List.of(new Menu("양송이수프-15"), new Menu("아이스크림-6"));
        assertThatThrownBy(() -> new MenuItems(menuItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 주문 금액 계산")
    @Test
    void calculateTotalMoney() {
        sampleMenuItems.calculateMenuItemsCost();
        int actualTotalMoney = sampleMenuItems.getTotalCost();
        int expectedTotalMoney = 142000;

        assertThat(actualTotalMoney).isEqualTo(expectedTotalMoney);
    }

    @DisplayName("주문 메뉴 중 디저트 개수 세기")
    @Test
    void countDessertMenu() {
        int actualDessertCount = sampleMenuItems.countDessert();
        int expectedDessertCount = 2;

        assertThat(actualDessertCount).isEqualTo(expectedDessertCount);
    }

    @DisplayName("주문 메뉴 중 메인 개수 세기")
    @Test
    void countMainMenu() {
        int actualMainCount = sampleMenuItems.countMain();
        int expectedMainCount = 2;

        assertThat(actualMainCount).isEqualTo(expectedMainCount);
    }
}
