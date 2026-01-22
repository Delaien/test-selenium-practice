package gog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {
    private final By firstGameTitle = By.cssSelector("[selenium-id='productTileGameTitle']");
    private final By goodOldGamesFilter = By.cssSelector("[selenium-id='showOnlyPreservedGamesCheckbox'] .filter-option__label");
    private final By goodOldGamesAppliedFilter = By.cssSelector("[selenium-id='showOnlyPreservedGamesCheckbox'] input[type='checkbox']:checked");
    private final By removeFiltersButton = By.cssSelector("[selenium-id='filterClearingList'] [selenium-id='filterClearingItemIcon']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return waitUntil(firstGameTitle).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getFirstGameTitle() {
        return getText(firstGameTitle);
    }

    public void applyGoodOldGamesFilter() {
        dismissCookieBannerIfPresent();
        waitClick(goodOldGamesFilter);
    }

    public boolean isGoodOldGamesFilterDisplayed() {
        return !driver.findElements(goodOldGamesAppliedFilter).isEmpty();
    }

    public void waitForGoodOldGamesFilterApplied() {
        wait.until(d -> !d.findElements(goodOldGamesAppliedFilter).isEmpty());
    }

    public void removeFilters() {
        dismissCookieBannerIfPresent();
        waitClick(removeFiltersButton);
    }

    public void waitForFiltersCleared() {
        wait.until(d -> d.findElements(goodOldGamesAppliedFilter).isEmpty());
    }
}
