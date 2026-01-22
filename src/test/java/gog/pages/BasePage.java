package gog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitUntil(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitClick(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (ElementClickInterceptedException e) {
            dismissCookieBannerIfPresent();
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    element
            );
            try {
                element.click();
            } catch (ElementClickInterceptedException ignored) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        }
    }

    protected void dismissCookieBannerIfPresent() {
        By cookieAcceptButton = By.cssSelector("#CybotCookiebotDialogBodyLevelButtonAccept, #CybotCookiebotDialogBodyButtonAccept");
        By cookieDialog = By.id("CybotCookiebotDialog");
        var buttons = driver.findElements(cookieAcceptButton);
        if (!buttons.isEmpty() && buttons.get(0).isDisplayed()) {
            buttons.get(0).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieDialog));
            return;
        }

        ((JavascriptExecutor) driver).executeScript(
                "var dialog=document.getElementById('CybotCookiebotDialog');"
                        + "if(dialog){dialog.style.display='none';}"
                        + "var overlays=document.querySelectorAll('.CybotCookiebotScrollArea');"
                        + "overlays.forEach(function(o){o.style.display='none';});"
        );
    }

    protected void type(By locator, String text) {
        WebElement element = waitUntil(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void hover(By locator) {
        new Actions(driver).moveToElement(waitUntil(locator)).perform();
    }

    protected String getText(By locator) {
        return waitUntil(locator).getText();
    }
}
