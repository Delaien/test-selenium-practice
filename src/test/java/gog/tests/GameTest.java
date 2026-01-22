package gog.tests;

import gog.pages.GamePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest extends BaseTest {

    @Test
    @Feature("Cart action")
    @Story("Ajouter un jeu au panier")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ajoute Theme Hospital au panier et verifie que l'etat change.")
    public void testAddGameToCart() {
        GamePage gamePage = new GamePage(driver).addGameToCart("Theme Hospital");

        gamePage.waitForInCart();
        Assertions.assertTrue(gamePage.isInCart());
    }
}
