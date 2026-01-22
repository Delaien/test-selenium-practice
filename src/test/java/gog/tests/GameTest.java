package gog.tests;

import gog.pages.GamePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest extends BaseTest {

    @Test
    public void testAddGameToCart() {
        GamePage gamePage = new GamePage(driver).addGameToCart("Theme Hospital");

        gamePage.waitForInCart();
        Assertions.assertTrue(gamePage.isInCart());
    }
}
