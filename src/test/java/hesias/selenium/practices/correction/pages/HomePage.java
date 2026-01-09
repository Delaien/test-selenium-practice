package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By refuseCookies = By.cssSelector("button#CybotCookiebotDialogBodyButtonDecline");
    private By linkHome = By.cssSelector("a.menu__logo");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        goTo(ROOT_URL);
        waitClick(refuseCookies).click();
        return this;
    }

    public boolean isDisplayed() {
        try {
            waitUntil(linkHome);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
