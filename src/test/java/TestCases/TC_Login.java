package TestCases;

import Base.Base;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;


public class TC_Login extends Base {


    LoginPage loginPage;


    @Test
    public void testValidLogin() {
        try {
             loginPage = new LoginPage(driver);

            // Login using credentials from config.properties via LoginPage
            loginPage.loginWithConfigCredentials();

            // Wait for a reliable post-login element (Logout link)
          //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='logout.htm']")));

            // Assert user is logged in
            Assert.assertTrue(
                    driver.findElement(By.xpath("//a[@href='logout.htm']")).isDisplayed(),
                    "Login was not successful with valid credentials!"
            );

            System.out.println(" Valid login test passed.");
        } catch (Exception e) {
            Assert.fail(" Exception in testValidLogin: " + e.getMessage());
        }
    }
}
