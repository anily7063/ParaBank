package TestCases;

import Base.Base;
import Pages.RegisterPage;
import Utilities.ReadConfig;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Register extends Base {
    Faker faker = new Faker();
    String generatedUser; // store username for re-use in negative case
    String generatedPass = "Password123"; // fixed password for simplicity
    ReadConfig readConfig = new ReadConfig();
    // Positive Test - Register a new user
    @Test(priority = 1)
    public void testValidRegistration() {
        try {
            driver.findElement(By.linkText("Register")).click();
            RegisterPage registerPage = new RegisterPage(driver);

            generatedUser = "user" + faker.number().digits(5); // unique username

            registerPage.fillRegistrationForm(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().state(),
                    faker.address().zipCode(),
                    faker.phoneNumber().cellPhone(),
                    faker.number().digits(9), // SSN numeric
                    generatedUser,
                    generatedPass
            );

            // Store credentials in config for login
            readConfig.setUserCredentials(generatedUser, generatedPass);


            // Assert success message
            Assert.assertTrue(driver.getPageSource().contains("Your account was created successfully"));

            System.out.println("Positive registration test passed with username: " + generatedUser);
            // Logout after successful registration
            registerPage.logout();

        } catch (Exception e) {
            System.out.println("Error in testValidRegistration: " + e.getMessage());
            Assert.fail("Test failed due to exception.");
        }
    }

    // Negative Test - Try registering with same username
    @Test(priority = 2, dependsOnMethods = "testValidRegistration")
    public void testInvalidRegistration() {
        try {
            driver.findElement(By.linkText("Register")).click();
            RegisterPage registerPage = new RegisterPage(driver);

            // Reuse the same username from positive case
            registerPage.fillRegistrationForm(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().state(),
                    faker.address().zipCode(),
                    faker.phoneNumber().cellPhone(),
                    faker.number().digits(9),
                    generatedUser,  // Duplicate username
                    "Password123"
            );

            // Assert duplicate username error
            Assert.assertTrue(driver.getPageSource().contains("This username already exists"));
            System.out.println(" Negative registration test passed (duplicate username blocked).");

        } catch (Exception e) {
            System.out.println(" Error in testInvalidRegistration: " + e.getMessage());
            Assert.fail("Test failed due to exception.");
        }
    }
}
