package gog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {
    private final By addToCartButton = By.cssSelector("[selenium-id='AddToCartButton']");
    private final By genericCartButton = By.cssSelector("button.cart-button");
    private final By checkoutButton = By.cssSelector("[selenium-id='CheckoutButton']");

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public GamePage addGameToCart(String gameName) {
        dismissCookieBannerIfPresent();
        new HomePage(driver).open().goToGame(gameName);
        clickAddToCart();
        return this;
    }

    public void clickAddToCart() {
        dismissCookieBannerIfPresent();
        wait.until(d -> !d.findElements(addToCartButton).isEmpty() || !d.findElements(genericCartButton).isEmpty());
        var button = !driver.findElements(addToCartButton).isEmpty()
                ? driver.findElements(addToCartButton).get(0)
                : driver.findElements(genericCartButton).get(0);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
        );
        try {
            button.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException ignored) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }

    public boolean isInCart() {
        return !driver.findElements(checkoutButton).isEmpty();
    }

    public void waitForInCart() {
        wait.until(d -> !d.findElements(checkoutButton).isEmpty());
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
