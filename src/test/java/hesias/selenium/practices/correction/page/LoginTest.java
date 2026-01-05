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
        driver.get(ROOT_URL);

        // Find the inputs to fill up the login form
        WebElement username = waitUntil(By.name("username"));
        WebElement password = waitUntil(By.name("password"));

        // Fill up the inputs
        username.sendKeys("Admin");
        password.sendKeys("admin123");

        // Press ENTER to submit the form
        password.sendKeys(Keys.ENTER);

        // Other way to submit the form
//        WebElement submit = waitUntil(By.cssSelector("button[type='submit']"));
//        submit.click();

        // Check something existing in the Dashboard - accessed when we are log in
        WebElement title = waitUntil(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module"));
        assertEquals("Dashboard", title.getText());
    }

}
