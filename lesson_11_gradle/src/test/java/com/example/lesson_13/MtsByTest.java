package com.example.lesson_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
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

    // Проверка названия блока
    @Test
    void testBlockTitle() {
        WebElement title = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", title.getText());
    }

    // Проверка наличия логотипов платежных систем
    @Test
    void testPaymentLogoDisplaying() {
        WebElement visaLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]"));
        assertTrue(visaLogo.isDisplayed());

        WebElement verifiedByVisaLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]"));
        assertTrue(verifiedByVisaLogo.isDisplayed());

        WebElement mastercardLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]"));
        assertTrue(mastercardLogo.isDisplayed());

        WebElement mastercardSecureCodeLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]"));
        assertTrue(mastercardSecureCodeLogo.isDisplayed());

        WebElement belcardLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]"));
        assertTrue(belcardLogo.isDisplayed());
    }

    // Проверка работы ссылки «Подробнее о сервисе»
    @Test
    void testCheckLink() {
        WebElement checkLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        checkLink.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    // Заполнение полей и проверка кнопки «Продолжить»
    @Test
    public void testCheckFillForm() {
        WebElement dropdown = driver.findElement(By.className("select__now"));
        assertEquals("Услуги связи", dropdown.getText());

        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumber.sendKeys("297777777");
        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.sendKeys("555");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        email.sendKeys("test_buzhan@mail.ru");
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        continueButton.click();

        WebElement frameElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(frameElement);
        WebElement elementInsideIframe = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span")));
        assertEquals("Оплата: Услуги связи Номер:375297777777", elementInsideIframe.getText());
    }

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
