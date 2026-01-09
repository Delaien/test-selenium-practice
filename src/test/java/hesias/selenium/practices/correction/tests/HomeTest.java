package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends  BaseTest {

    @Test
    public void testHomePageOpen() {
        boolean homeIsDisplayed = new HomePage(driver)
                .open()
                .isDisplayed();

        assertTrue(homeIsDisplayed);
    }

}
