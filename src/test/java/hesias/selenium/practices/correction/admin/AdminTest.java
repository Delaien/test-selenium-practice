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
        WebElement linkAdmin = waitUntil(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
        linkAdmin.click();

        // check if admin BO is accessible
        WebElement title = waitUntil(By.xpath("//h5[string-length(concat(text(), 'System Users')) > 0]"));
        assertNotNull(title);
    }

    @Test
    public void testAddUser() {
        loginToApp();

        // Find the link for admin BO
        WebElement linkAdmin = waitUntil(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
        linkAdmin.click();

//        WebElement addUserBtn = waitUntil(By.xpath("//button[contains(text(), ' Add ')]"));
//        System.out.println(addUserBtn.getText());
//        assertNotNull(addUserBtn);


    }

}
