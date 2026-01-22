package gog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkPage extends BasePage {
    private static final String WORK_URL = "https://www.gog.com/fr/work";
    private final By jobListingsAnchor = By.id("job-listings");
    private final By jobSearchInput = By.cssSelector(".job-listings-search-input");

    public WorkPage(WebDriver driver) {
        super(driver);
    }

    public WorkPage goToJobOfferInput() {
        driver.get(WORK_URL);
        dismissCookieBannerIfPresent();
        WebElement anchor = wait.until(ExpectedConditions.presenceOfElementLocated(jobListingsAnchor));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                anchor
        );
        waitUntil(jobSearchInput);
        return this;
    }

    public WorkPage searchForJobOffer(String job) {
        dismissCookieBannerIfPresent();
        goToJobOfferInput();
        type(jobSearchInput, job);
        return this;
    }

    public boolean isDisplayed() {
        return waitUntil(jobSearchInput).isDisplayed();
    }

    public String getJobSearchValue() {
        return waitUntil(jobSearchInput).getAttribute("value");
    }
}
