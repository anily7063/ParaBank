package Pages;

import Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    LoginPage login;
    ReadConfig readConfig;
    WebDriver driver;
@FindBy(xpath = "//input[@name='username']")
WebElement userName;
@FindBy(xpath = "//input[@name='password']")
WebElement password;
@FindBy(xpath = "//input[@value='Log In']")
WebElement loginBtn;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        readConfig = new ReadConfig();
    }
    //  Login method
    public void login(String uname, String pwd) {

            userName.clear();
            userName.sendKeys(uname);
            password.clear();
            password.sendKeys(pwd);
            loginBtn.click();

    }

    // Login using values from config.properties
    public void loginWithConfigCredentials() {

            String uname = readConfig.getUserName();
            String pwd = readConfig.getPassword();
            login(uname, pwd);

    }

}
