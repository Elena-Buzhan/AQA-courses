package courses.lesson_14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MtsByTestPopUp {
    private WebDriver driver;
    private WebDriverWait wait;

    private final String SUMMA = "Сумма";
    private final String RUB = "Руб.";
    private final String EMAIL_FOR_SEND_RECEIPT = "E-mail для отправки чека";
    private final String INDEX = "+375";
    private final String PHONE_NUMBER = "Номер телефона";
    private final String NUMBER_ABONENT = "Номер абонента";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        acceptCookies();
    }

    @AfterEach
    void tearDown() {
        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }

    @Test
    void testCommunicationServices() {
        assertEquals("Услуги связи", driver.findElement(By.className("select__now")).getText());
        assertEquals(INDEX, driver.findElement(By.xpath("//label[text()='+375']")).getText());
        assertEquals(PHONE_NUMBER, driver.findElement(By.id("connection-phone")).getAttribute("placeholder"));
        assertEquals(SUMMA, driver.findElement(By.id("connection-sum")).getAttribute("placeholder"));
        assertEquals(RUB, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Руб.']"))).getText());
        assertEquals(EMAIL_FOR_SEND_RECEIPT, driver.findElement(By.id("connection-email")).getAttribute("placeholder"));
    }

    @Test
    void testHomeInternet() {
        driver.findElement(By.className("select__now")).click();
        driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Домашний интернет']")).click();

        assertEquals(INDEX, driver.findElement(By.xpath("//label[text()='+375']")).getText());
        assertEquals(NUMBER_ABONENT, driver.findElement(By.id("internet-phone")).getAttribute("placeholder"));
        assertEquals(SUMMA, driver.findElement(By.id("internet-sum")).getAttribute("placeholder"));
        assertEquals(RUB, wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='internet-sum']"))).getText());
        assertEquals(EMAIL_FOR_SEND_RECEIPT, driver.findElement(By.id("internet-email")).getAttribute("placeholder"));
    }

    @Test
    void testInstallmentPlan() {
        driver.findElement(By.className("select__now")).click();
        driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Рассрочка']")).click();

        assertEquals("Номер счета на 44", driver.findElement(By.id("score-instalment")).getAttribute("placeholder"));
        assertEquals(SUMMA, driver.findElement(By.id("instalment-sum")).getAttribute("placeholder"));
        assertEquals(RUB, wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='instalment-sum']"))).getText());
        assertEquals(EMAIL_FOR_SEND_RECEIPT, driver.findElement(By.id("instalment-email")).getAttribute("placeholder"));
    }

    @Test
    void testDEbt() {
        driver.findElement(By.className("select__now")).click();
        driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Задолженность']")).click();

        assertEquals("Номер счета на 2073", driver.findElement(By.id("score-arrears")).getAttribute("placeholder"));
        assertEquals(SUMMA, driver.findElement(By.id("arrears-sum")).getAttribute("placeholder"));
        assertEquals(RUB, ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;",
                driver.findElement(By.cssSelector("label[for='instalment-sum']"))));
        assertEquals(EMAIL_FOR_SEND_RECEIPT, driver.findElement(By.id("arrears-email")).getAttribute("placeholder"));
    }

    @Test
    public void testOnlineRecharge() {
        assertEquals("Услуги связи", driver.findElement(By.className("select__now")).getText());
        driver.findElement(By.xpath("//*[@id=\"connection-phone\"]")).sendKeys("297777777");
        driver.findElement(By.xpath("//*[@id=\"connection-sum\"]")).sendKeys("88");
        driver.findElement(By.xpath("//button[text()='Продолжить']")).click();

        WebElement frameElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(frameElement);
        assertEquals("88.00 BYN", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__cost']/span"))).getText());
        assertEquals("Оплата: Услуги связи Номер:375297777777",
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span"))).getText());
        assertEquals("Оплатить 88.00 BYN", driver.findElement(By.xpath("//button[text()=' Оплатить  88.00 BYN ']")).getText());

        // Проверка плейсхолдеров незаполнненных полей
        assertTrue(driver.findElement(By.xpath("//label[text()='Номер карты']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//label[text()='Срок действия']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//label[text()='CVC']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//label[text()='Имя держателя (как на карте)']")).isDisplayed());

        //Проверка иконок платежных систем
        List<String> paymentIcons = List.of(
                "assets/images/payment-icons/card-types/mastercard-system.svg",
                "assets/images/payment-icons/card-types/visa-system.svg",
                "assets/images/payment-icons/card-types/belkart-system.svg",
                "assets/images/payment-icons/card-types/mir-system-ru.svg",
                "assets/images/payment-icons/card-types/maestro-system.svg"
        );

        for (String paymentIcon : paymentIcons) {
            assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='" + paymentIcon + "']"))).isDisplayed());
        }
    }

    @Test
    private void acceptCookies() {
        WebElement cookieButton;
        try {
            cookieButton = driver.findElement(By.cssSelector("button#cookie-agree.btn.btn_black.cookie__ok"));
            cookieButton.click();
        } catch (Exception e) {
            System.out.printf("Кнопка принятия/согласия куки не найдена или не кликабельна. \nException: %s%n", e);
        }
    }

}
