package hesias.selenium.practices.correction.page;

import hesias.selenium.practices.correction.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectorTest extends BaseTest {

    @Test
    public void testSelector() {
        driver.get(ROOT_URL);

        WebElement usernameByElement = waitUntil(By.name("username"));
        WebElement usernameByCSS = waitUntil(By.cssSelector("input[name='username']"));
        WebElement usernameByXPath = waitUntil(By.xpath("//input[@name='username']"));

        // Test
        usernameByElement.sendKeys("By Element");
        usernameByCSS.sendKeys(" | By cssSelector");
        usernameByXPath.sendKeys(" | By xPath");

        WebElement passwordByElement = waitUntil(By.name("password"));
        WebElement passwordByCSS = waitUntil(By.cssSelector("input[name='password']"));
        WebElement passwordByXPath = waitUntil(By.xpath("//input[@name='password']"));

        // Test
        passwordByElement.sendKeys("By Element");
        passwordByCSS.sendKeys(" | By cssSelector");
        passwordByXPath.sendKeys(" | By xPath");
    }

}
