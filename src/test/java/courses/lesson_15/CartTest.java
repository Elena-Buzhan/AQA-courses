package courses.lesson_15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {
    private WebDriver driver;
    private MainPage mainPage;
    private CartPage cartPage;

    @BeforeEach
    public void setUp() {
        driver = DriverSingleton.getDriver();
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void testAddingProductsToCart() {
        mainPage.open();

        //добавление товаров в корзину
        WebElement product1 = mainPage.addProductToCart(0);
        String titleProduct1 = mainPage.getTitle(product1);

        WebElement product2 = mainPage.addProductToCart(1);
        String titleProduct2 = mainPage.getTitle(product2);

        //переход в корзину
        driver.get("https://www.wildberries.ru/lk/basket");

        // Проверка названий товаров
        List<WebElement> productNames = cartPage.getProductNames();
        assertEquals(2, productNames.size(), "Ожидается два товара в корзине");
        assertTrue(titleProduct1.contains(productNames.get(0).getText()) || titleProduct1.contains(productNames.get(1).getText()));
        assertTrue(titleProduct2.contains(productNames.get(0).getText()) || titleProduct2.contains(productNames.get(1).getText()));

        // Проверка количества товаров
        List<Integer> productsByCart = cartPage.getEachProductQuantityInCart();
        assertEquals(2, productsByCart.size(), "Количество товаров должно быть 2");
        assertEquals(1, productsByCart.get(0), "Количество первого товара должно быть 1");
        assertEquals(1, productsByCart.get(1), "Количество второго товара должно быть 1");

        // Проверка цены товаров
        List<WebElement> productPrices = cartPage.getProductPrices();
        assertEquals(2, productPrices.size(), "Количество цен должно быть 2");
        int price1 = Integer.parseInt(productPrices.get(0).getText().replaceAll("\\D", ""));
        int price2 = Integer.parseInt(productPrices.get(1).getText().replaceAll("\\D", ""));

        // Проверка общей суммы
        int expectedTotal = price1 + price2;
        int actualTotal = Integer.parseInt(cartPage.getTotalPrice().getText().replaceAll("\\D", ""));
        assertEquals(expectedTotal, actualTotal, "Общая сумма должна совпадать с суммой цен товаров");
    }

    @AfterEach
    public void tearDown() {
        DriverSingleton.quit();
    }

}
