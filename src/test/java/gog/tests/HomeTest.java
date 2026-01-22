package gog.tests;

import gog.pages.GamePage;
import gog.pages.HomePage;
import gog.pages.WorkPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {

    @Test
    @Feature("Home action")
    @Story("Afficher la page d'accueil")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifie que la page d'accueil et le logo sont visibles.")
    public void testHomePageIsDisplayed() {
        HomePage homePage = new HomePage(driver).open();

        Assertions.assertTrue(homePage.isDisplayed());
        Assertions.assertTrue(homePage.isHomeLinkDisplayed());
    }

    @Test
    @Feature("Home action")
    @Story("Changer la langue du site")
    @Severity(SeverityLevel.NORMAL)
    @Description("Change la langue en anglais et verifie l'URL.")
    public void testChangeLanguage() {
        new HomePage(driver).changeLanguage("en");

        Assertions.assertTrue(driver.getCurrentUrl().contains("/en/"));
    }

    @Test
    @Feature("Home action")
    @Story("Naviguer dans le carousel")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clique sur la fleche gauche du slider et verifie le changement de bullet actif.")
    public void testSliderLeft() {
        HomePage homePage = new HomePage(driver).open();
        int beforeIndex = homePage.getActiveSliderBulletIndex();

        homePage.clickSliderLeft();
        homePage.waitForSliderBulletChange(beforeIndex);

        int afterIndex = homePage.getActiveSliderBulletIndex();
        Assertions.assertNotEquals(beforeIndex, afterIndex);
    }

    @Test
    @Feature("Home action")
    @Story("Aller au dernier element du carousel")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clique sur le dernier bullet du slider et verifie qu'un bullet est actif.")
    public void testClickLastSliderBullet() {
        HomePage homePage = new HomePage(driver).open();
        int beforeIndex = homePage.getActiveSliderBulletIndex();

        homePage.clickLastSliderBullet();
        homePage.waitForSliderBulletChange(beforeIndex);

        int lastIndex = homePage.getActiveSliderBulletIndex();
        Assertions.assertTrue(lastIndex >= 0);
    }

    @Test
    @Feature("Home action")
    @Story("Acceder a la page d'un jeu mis en avant")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clique le premier jeu mis en avant et verifie l'URL.")
    public void testGoToGamePage() {
        GamePage gamePage = new HomePage(driver).open().goToFirstFeaturedGame();

        Assertions.assertTrue(gamePage.getCurrentUrl().contains("/game/"));
    }

    @Test
    @Feature("Home action")
    @Story("Acceder a la page d'un jeu via la recherche")
    @Severity(SeverityLevel.NORMAL)
    @Description("Utilise la recherche pour ouvrir Theme Hospital et verifie l'URL.")
    public void testGoToGame() {
        GamePage gamePage = new HomePage(driver).open().goToGame("Theme Hospital");

        Assertions.assertTrue(gamePage.getCurrentUrl().toLowerCase().contains("theme_hospital"));
    }

    @Test
    @Feature("Home action")
    @Story("Acceder a la page des offres d'emploi")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ouvre la page Work depuis le menu A propos et verifie l'URL.")
    public void testGoToJobOfferPage() {
        WorkPage workPage = new HomePage(driver).open().goToJobOfferPage();

        Assertions.assertTrue(workPage.isDisplayed());
        Assertions.assertTrue(driver.getCurrentUrl().contains("/work"));
    }
}
