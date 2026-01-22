package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private final By titlePageHeader = By.cssSelector("h1[selenium-id='pageHeader']");
    private final By firstGameTitle = By.xpath("//product-title[@selenium-id='productTitle'][1]//span");

    private final By checkBoxGoodOldGames = By.cssSelector("input[name='onlypreservedgames']");
    private final By spanFilterClearing = By.xpath("//span[@selenium-id='filterClearingItemLabel'][contains(text(), 'GOOD OLD GAMES')]");
    private final By spanResetFilters = By.xpath("//filter-title[contains(text(), ' Supprimer les filtres ')]//ancestor::div[@selenium-id='filterClearingItem']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstGameTitle() {
        return driver.findElement(firstGameTitle).getText();
    }

    public boolean isFilterGoodOldGamesActive() {
        waitClick(checkBoxGoodOldGames).click();
        return waitClick(spanFilterClearing).isDisplayed();
    }

    public boolean hasResetFilters() {
        waitClick(checkBoxGoodOldGames).click();
        waitClick(spanResetFilters).click();
        return getCurrentUrl().equals(ROOT_URL + "games");
    }

    public boolean isDisplayed() {
        try {
            waitUntil(titlePageHeader);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
