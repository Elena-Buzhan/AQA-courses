package courses.lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By productNameLocator = By.cssSelector(".list-item__good-info .good-info__good-name");
    private By productQuantityInputsLocator = By.cssSelector("input[data-link*='quantity']");
    private By productPriceLocator = By.cssSelector(".list-item__price-new.wallet");
    private By totalPriceLocator = By.cssSelector(".b-top__total.line span[data-link]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<WebElement> getProductNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNameLocator));
        return driver.findElements(productNameLocator);
    }

    public List<Integer> getEachProductQuantityInCart() {
        List<WebElement> quantityInputs = driver.findElements(productQuantityInputsLocator);
        List<Integer> quantities = new ArrayList<>();
        for (WebElement input : quantityInputs) {
            String quantityValue = input.getAttribute("value");
            quantities.add(Integer.parseInt(quantityValue));
        }
        return quantities;
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(productPriceLocator);
    }

    public WebElement getTotalPrice() {
        return driver.findElement(totalPriceLocator);
    }

}
