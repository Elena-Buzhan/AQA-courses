package courses.lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By productLocator = By.cssSelector("div.product-card__wrapper");
    private By productLinkLocator = By.cssSelector("a.product-card__link.j-card-link.j-open-full-product-card");
    private By addToCartButton = By.cssSelector("a.product-card__add-basket.j-add-to-basket");
    private By cookiesOkButtonLocator = By.cssSelector(".cookies__btn");
    private By sizeOptionLocator = By.cssSelector("label.j-quick-order-size-fake.sizes-list__button");


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.wildberries.ru/");
        closeCookiesPopup();
    }

    private void closeCookiesPopup() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookiesOkButtonLocator));
            driver.findElement(cookiesOkButtonLocator).click();
        } catch (Exception e) {
            System.out.println("Ошибка при отображении куки: " + e.getMessage());
        }
    }

    public WebElement addProductToCart(int productIndex) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productLocator, productIndex));
        WebElement product = driver.findElements(productLocator).get(productIndex);
        product.findElement(addToCartButton).click();
        selectSizeIfAvailable();
        return product;
    }

    public void selectSizeIfAvailable() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement sizeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(sizeOptionLocator));
            if (!sizeButton.getAttribute("class").contains("disabled")) {
                sizeButton.click();
                System.out.println("Размер выбран успешно.");
            } else {
                System.out.println("Размер недоступен.");
            }
        } catch (TimeoutException e) {
            System.out.println("Кнопка выбора размера не появилась.");
        }
    }

    public String getTitle(WebElement webElement) {
        return webElement.findElement(productLinkLocator).getAttribute("aria-label");
    }

}
