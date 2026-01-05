package hesias.selenium.practices.correction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static String ROOT_URL = "https://opensource-demo.orangehrmlive.com/";

    @BeforeEach
    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    protected void down() {
        if (driver != null) {
//            driver.quit();
        }
    }

    protected void loginToApp() {
        driver.get(ROOT_URL);

        // Find the inputs to fill up the login form
        WebElement username = waitUntil(By.name("username"));
        WebElement password = waitUntil(By.name("password"));

        // Fill up the inputs
        username.sendKeys("Admin");
        password.sendKeys("admin123");

        // Press ENTER to submit the form
        password.sendKeys(Keys.ENTER);

        // Other way to submit the form
//        WebElement submit = waitUntil(By.cssSelector("button[type='submit']"));
//        submit.click();
    }

    protected WebElement waitUntil(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
