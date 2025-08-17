package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;


    // Constructor for PageFactory initialization
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
@FindBy(xpath = "//input[@id='customer.firstName']")
WebElement firstName;
@FindBy(xpath = "//input[@id='customer.lastName']")
WebElement lastName;
@FindBy(xpath = "//input[@id='customer.address.street']")
WebElement address;
@FindBy(xpath ="//input[@id='customer.address.city']" )
WebElement city;
@FindBy(xpath = "//input[@id='customer.address.state']")
WebElement state;
@FindBy(xpath = "//input[@id='customer.address.zipCode']")
WebElement zipCode;
@FindBy(xpath = "//input[@id='customer.phoneNumber']")
WebElement phone;
@FindBy(xpath = "//input[@id='customer.ssn']")
WebElement ssn;
@FindBy(xpath = "//input[@id='customer.username']")
WebElement userNameReg;
@FindBy(xpath = "//input[@id='customer.password']")
WebElement passwordReg;

@FindBy(xpath = "//input[@id='repeatedPassword']")
WebElement confirmPassword;
@FindBy(xpath = "//input[@value='Register']")
WebElement registerBtn;

@FindBy(xpath = "//a[@href='logout.htm']")
WebElement logout;

    // Action method to fill the form
    public void fillRegistrationForm(String fName, String lName, String addr, String cityVal, String stateVal,
                                     String zip, String phoneNum, String ssnVal, String user, String pass) {
        try {
            firstName.sendKeys(fName);
            lastName.sendKeys(lName);
            address.sendKeys(addr);
            city.sendKeys(cityVal);
            state.sendKeys(stateVal);
            zipCode.sendKeys(zip);
            phone.sendKeys(phoneNum);
            ssn.sendKeys(ssnVal);
            userNameReg.sendKeys(user);
            passwordReg.sendKeys(pass);
            confirmPassword.sendKeys(pass);
            registerBtn.click();

        } catch (Exception e) {
            System.out.println("Error while filling registration form: " + e.getMessage());
        }
    }
    // Logout method
    public void logout() {
        try {
            logout.click();
            System.out.println("User logged out successfully.");
        } catch (Exception e) {
            System.out.println("Logout failed: " + e.getMessage());
        }
    }
}
