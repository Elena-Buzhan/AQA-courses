package courses.lesson_17;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private IOSDriver driver;

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "18.1");
        capabilities.setCapability("deviceName", "iPhone 16 Pro");
        capabilities.setCapability("app", "com.apple.calculator");
        capabilities.setCapability("udid", "5D6D03C9-0DC6-4A5F-A596-A4C2F82DC132");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("newCommandTimeout", 300);
        capabilities.setCapability("automationName", "XCUITest");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    @Order(1)
    @DisplayName("Тест сложения")
    public void testAddition() {
        driver.findElement(AppiumBy.accessibilityId("2")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.accessibilityId("3")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.accessibilityId("result")).getText();
        Assertions.assertEquals("5", result, "Ошибка в операции сложения!");
    }

    @Test
    @Order(2)
    @DisplayName("Тест вычитания")
    public void testSubtraction() {
        driver.findElement(AppiumBy.accessibilityId("8")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.accessibilityId("3")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.accessibilityId("result")).getText();
        Assertions.assertEquals("5", result, "Ошибка в операции вычитания!");
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}