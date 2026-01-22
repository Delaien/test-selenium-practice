package gog.tests;

import gog.pages.HomePage;
import gog.pages.SearchResultsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchCyberpunk() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Cyberpunk");

        Assertions.assertTrue(results.getCurrentUrl().toLowerCase().contains("cyberpunk"));
    }

    @Test
    public void testSearchBindingOf() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Binding of");

        Assertions.assertTrue(results.isDisplayed());
    }

    @Test
    public void testFirstResultContainsWitcher() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Witcher");

        Assertions.assertTrue(results.getFirstGameTitle().toLowerCase().contains("witcher"));
    }

    @Test
    public void testFilterGoodOldGames() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Witcher");

        results.applyGoodOldGamesFilter();
        Assertions.assertTrue(results.isGoodOldGamesFilterDisplayed());
    }

    @Test
    public void testRemoveFilter() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Witcher");

        results.applyGoodOldGamesFilter();
        Assertions.assertTrue(results.isGoodOldGamesFilterDisplayed());

        results.removeFilters();
        results.waitForFiltersCleared();

        Assertions.assertFalse(results.isGoodOldGamesFilterDisplayed());
    }
}
