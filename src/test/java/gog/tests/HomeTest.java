package gog.tests;

import gog.pages.GamePage;
import gog.pages.HomePage;
import gog.pages.WorkPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {

    @Test
    public void testHomePageIsDisplayed() {
        HomePage homePage = new HomePage(driver).open();

        Assertions.assertTrue(homePage.isDisplayed());
        Assertions.assertTrue(homePage.isHomeLinkDisplayed());
    }

    @Test
    public void testChangeLanguage() {
        new HomePage(driver).changeLanguage("en");

        Assertions.assertTrue(driver.getCurrentUrl().contains("/en/"));
    }

    @Test
    public void testSliderLeft() {
        HomePage homePage = new HomePage(driver).open();
        int beforeIndex = homePage.getActiveSliderBulletIndex();

        homePage.clickSliderLeft();
        homePage.waitForSliderBulletChange(beforeIndex);

        int afterIndex = homePage.getActiveSliderBulletIndex();
        Assertions.assertNotEquals(beforeIndex, afterIndex);
    }

    @Test
    public void testClickLastSliderBullet() {
        HomePage homePage = new HomePage(driver).open();
        int beforeIndex = homePage.getActiveSliderBulletIndex();

        homePage.clickLastSliderBullet();
        homePage.waitForSliderBulletChange(beforeIndex);

        int lastIndex = homePage.getActiveSliderBulletIndex();
        Assertions.assertTrue(lastIndex >= 0);
    }

    @Test
    public void testGoToGamePage() {
        GamePage gamePage = new HomePage(driver).open().goToFirstFeaturedGame();

        Assertions.assertTrue(gamePage.getCurrentUrl().contains("/game/"));
    }

    @Test
    public void testGoToGame() {
        GamePage gamePage = new HomePage(driver).open().goToGame("Theme Hospital");

        Assertions.assertTrue(gamePage.getCurrentUrl().toLowerCase().contains("theme_hospital"));
    }

    @Test
    public void testGoToJobOfferPage() {
        WorkPage workPage = new HomePage(driver).open().goToJobOfferPage();

        Assertions.assertTrue(workPage.isDisplayed());
        Assertions.assertTrue(driver.getCurrentUrl().contains("/work"));
    }
}
