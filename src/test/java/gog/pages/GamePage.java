package gog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {
    private final By addToCartButton = By.cssSelector("[selenium-id='AddToCartButton']");
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
        waitClick(addToCartButton);
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
