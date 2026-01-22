package gog.tests;

import gog.pages.WorkPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkTest extends BaseTest {

    @Test
    public void testSearchForJobOffer() {
        WorkPage workPage = new WorkPage(driver).searchForJobOffer("backend");

        Assertions.assertEquals("backend", workPage.getJobSearchValue());
    }
}
