package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchCyberpunk() {
        boolean pageResultIsDisplayed = new HomePage(driver)
            .searchGame("Cyberpunk")
            .isDisplayed();

        assertTrue(pageResultIsDisplayed);
    }

    @Test
    public void testSearchBindingOf() {
        boolean pageResultIsDisplayed = new HomePage(driver)
                .searchGame("Binding of")
                .isDisplayed();

        assertTrue(pageResultIsDisplayed);
    }

    @Test
    public void testFirstResultContainsWitcher() {
        String firstGameTitle = new HomePage(driver)
                .searchGame("Witcher")
                .getFirstGameTitle();

        assertTrue(firstGameTitle.contains("Witcher"));
    }

    @Test
    public void testFilterGoodOldGames() {
        boolean isFilterActive = new HomePage(driver)
                .searchGame("Binding of")
                .isFilterGoodOldGamesActive();

        assertTrue(isFilterActive);
    }

    @Test
    public void testResetFilters() {
        boolean hasResetFiler = new HomePage(driver)
                .searchGame("Binding of")
                .hasResetFilters();

        assertTrue(hasResetFiler);
    }

}
