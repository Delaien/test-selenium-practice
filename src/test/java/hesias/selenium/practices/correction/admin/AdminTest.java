package hesias.selenium.practices.correction.admin;

import hesias.selenium.practices.correction.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdminTest extends BaseTest {

    @Test
    public void testNavigateToAdmin() {
        loginToApp();

        // Find the link for admin BO
        WebElement linkAdmin = waitUntil(By.xpath("//span[text()='Admin']"));
        linkAdmin.click();

        // check if admin BO is accessible
        WebElement title = waitUntil(By.xpath("//h5[string-length(concat(text(), 'System Users')) > 0]"));
        assertNotNull(title);
    }

    @Test
    public void testAddUser() {
        loginToApp();

        // Find the link for admin BO
        WebElement linkAdmin = waitUntil(By.xpath("//span[text()='Admin']"));
        linkAdmin.click();

        // Click on button Add - contains search inside the element and his children
        waitUntil(By.xpath("//button[contains(., 'Add')]")).click();

        // Select the 1st div element with class "oxd-select-text-input"
        waitClickable(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
        // Select the div element with attribute "role=listbox" then select any element with text "Admin" inside
        waitClickable(By.xpath("//div[@role='listbox']//*[text()='Admin']")).click();


        // Select the 2nd div element with class "oxd-select-text-input"
        waitClickable(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
        // Select the div element with attribute "role=listbox" then select any element with text "Enabled" inside
        waitClickable(By.xpath("//div[@role='listbox']//*[text()='Enabled']")).click();


        // Select the label for text = "Password"
        // Find the div parent
        // Find the div sibling at same level
        // Find the input with type="password" inside the sibling div
        WebElement password = waitUntil(
            By.xpath("//label[text()='Password']/parent::div/following-sibling::div//input[@type='password']")
        );
        password.click();
        password.sendKeys("Test123!");

        // Simple css selector there : input with attribute placeholder = "Type for hints..."
        WebElement nameField = waitUntil(By.cssSelector("input[placeholder='Type for hints...'"));
        nameField.click();
        nameField.sendKeys("B Nasreen Samreen");

        // Select the label for text = "Confirm Password"
        // Find the div parent
        // Find the div sibling at same level
        // Find the input with type="password" inside the sibling div
        WebElement usernameField = waitUntil(
            By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input[@class='oxd-input oxd-input--active']")
        );
        usernameField.click();
        usernameField.sendKeys("SuperUsername");


        // Select the label for text = "Confirm Password"
        // Find the div parent
        // Find the div sibling at same level
        // Find the input with type="password" inside the sibling div
        WebElement passwordConfirmed = waitUntil(
            By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div//input[@type='password']")
        );
        passwordConfirmed.click();
        passwordConfirmed.sendKeys("Test123!");

    }

}
