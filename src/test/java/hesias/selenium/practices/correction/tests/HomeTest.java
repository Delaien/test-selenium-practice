package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends  BaseTest {

    @Test
    public void testHomePageIsDisplayed() {
        boolean homeIsDisplayed = new HomePage(driver)
                .open()
                .isDisplayed();

        assertTrue(homeIsDisplayed);
    }

    @Test
    public void testHomePageChangeLanguageToEn() {
        boolean homeIsDisplayed = new HomePage(driver)
                .changeLanguage("en")
                .isDisplayed();

        assertTrue(homeIsDisplayed);
    }

    @Test
    public void testSliderLeft() {
        boolean lastElementIsActive = new HomePage(driver)
                .open()
                .clickSliderLeftArrow();

        assertTrue(lastElementIsActive);
    }

    @Test
    public void testClickFirstGameInSwiper() {
        boolean isOnGamePage = new HomePage(driver)
                .open()
                .clickFirstItemSlider()
                .isDisplayed();

        assertTrue(isOnGamePage);
    }

}
