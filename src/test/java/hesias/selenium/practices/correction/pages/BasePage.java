package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    static final String ROOT_URL = "https://www.gog.com/fr/";

    protected final By refuseCookies = By.cssSelector("button#CybotCookiebotDialogBodyButtonDecline");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected BasePage goTo(String url) {
        driver.get(url);
        return this;
    }

    protected WebElement waitUntil(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClick(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void type(By locator, String text) {
        WebElement element = waitClick(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected void keyDown(By locator, Keys key) {
        WebElement element = waitClick(locator);
        element.click();
        element.sendKeys(key);
    }

    protected String getText(By locator) {
        return  waitUntil(locator).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void scrollToElement(By locator) {
        new Actions(driver).scrollToElement(waitUntil(locator));
    }

    public void refuseCookies() {
        waitClick(refuseCookies).click();
    }

}
