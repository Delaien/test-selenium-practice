package gog.tests;

import gog.pages.WorkPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkTest extends BaseTest {

    @Test
    @Feature("Work action")
    @Story("Rechercher une offre d'emploi")
    @Severity(SeverityLevel.NORMAL)
    @Description("Saisit un mot cle dans la recherche d'offres et verifie la valeur.")
    public void testSearchForJobOffer() {
        WorkPage workPage = new WorkPage(driver).searchForJobOffer("backend");

        Assertions.assertEquals("backend", workPage.getJobSearchValue());
    }
}
