package hesias.selenium.practices.correction.page;

import hesias.selenium.practices.correction.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        loginToApp();

        // Check something existing in the Dashboard - accessed when we are log in
        WebElement title = waitUntil(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module"));
        assertEquals("Dashboard", title.getText());
    }

}
