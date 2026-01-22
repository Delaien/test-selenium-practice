package gog.tests;

import gog.pages.HomePage;
import gog.pages.SearchResultsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    @Test
    @Feature("Search action")
    @Story("Rechercher un jeu par mot cle")
    @Severity(SeverityLevel.NORMAL)
    @Description("Recherche Cyberpunk et verifie l'URL des resultats.")
    public void testSearchCyberpunk() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Cyberpunk");

        Assertions.assertTrue(results.getCurrentUrl().toLowerCase().contains("cyberpunk"));
    }

    @Test
    @Feature("Search action")
    @Story("Afficher des resultats de recherche")
    @Severity(SeverityLevel.NORMAL)
    @Description("Recherche Binding of et verifie que la page de resultats est affichee.")
    public void testSearchBindingOf() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Binding of");

        Assertions.assertTrue(results.isDisplayed());
    }

    @Test
    @Feature("Search action")
    @Story("Verifier le premier resultat")
    @Severity(SeverityLevel.NORMAL)
    @Description("Recherche Witcher et verifie le titre du premier jeu.")
    public void testFirstResultContainsWitcher() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Witcher");

        Assertions.assertTrue(results.getFirstGameTitle().toLowerCase().contains("witcher"));
    }

    @Test
    @Feature("Search action")
    @Story("Appliquer un filtre de recherche")
    @Severity(SeverityLevel.NORMAL)
    @Description("Active le filtre Good Old Games et verifie qu'il est applique.")
    public void testFilterGoodOldGames() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Witcher");

        results.applyGoodOldGamesFilter();
        Assertions.assertTrue(results.isGoodOldGamesFilterDisplayed());
    }

    @Test
    @Feature("Search action")
    @Story("Supprimer les filtres")
    @Severity(SeverityLevel.NORMAL)
    @Description("Supprime tous les filtres et verifie qu'ils sont retires.")
    public void testRemoveFilter() {
        SearchResultsPage results = new HomePage(driver).open().searchGame("Witcher");

        results.applyGoodOldGamesFilter();
        Assertions.assertTrue(results.isGoodOldGamesFilterDisplayed());

        results.removeFilters();
        results.waitForFiltersCleared();

        Assertions.assertFalse(results.isGoodOldGamesFilterDisplayed());
    }
}
