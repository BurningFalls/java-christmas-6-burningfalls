package christmas.Model;

import Model.Customer;
import Model.Menu;
import Model.VisitDay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(
                new VisitDay("5"),
                List.of(
                        new Menu("티본스테이크-1"),
                        new Menu("바비큐립-1"),
                        new Menu("초코케이크-2"),
                        new Menu("제로콜라-1")
                )
        );
    }

    @DisplayName("총 주문 금액 계산")
    @Test
    void calculateTotalMoney() {
        int actualTotalMoney = customer.calculateMenuItemsCost();
        int expectedTotalMoney = 142000;

        assertThat(actualTotalMoney).isEqualTo(expectedTotalMoney);
    }

    @DisplayName("주문 메뉴 중 디저트 개수 세기")
    @Test
    void countDessertMenu() {
        int actualDessertCount = customer.countDessert();
        int expectedDessertCount = 2;

        assertThat(actualDessertCount).isEqualTo(expectedDessertCount);
    }
}
