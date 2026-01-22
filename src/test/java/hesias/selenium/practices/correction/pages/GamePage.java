package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {

    private final By addToCartBtn = By.cssSelector("button[selenium-id='AddToCartButton']");

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        try {
            waitClick(addToCartBtn);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
