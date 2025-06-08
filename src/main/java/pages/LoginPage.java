package pages;

import core.DriverManager;
import enums.LoginPageEnum;
import enums.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReaderUtil;
import utils.PageUtil;

public class LoginPage extends Basepage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver= driver;
    }


    @Override
    public boolean isPageLoaded() {
        System.out.println("Ensure Login Page Loaded");
        WebElement closebtn= PageUtil.waitForVisibility(DriverManager.getDriver(), LoginPageEnum.USERNAME_INPUT.getLocator(), Timeout.TEN_SEC);
        boolean result= closebtn!=null && closebtn.isDisplayed();
        System.out.println("IS Login Page Loaded! "+result);
        return result;
    }
    public boolean LoginCredentials() {
        // Wait and click "Go to Build 2" link
        WebElement build2 = PageUtil.waitForVisibility(driver, LoginPageEnum.CLICK_BUILD2.getLocator(), Timeout.TEN_SEC);
        build2.click();

        // Wait for username field
        WebElement usernameField = PageUtil.waitForVisibility(driver, LoginPageEnum.USERNAME_INPUT.getLocator(), Timeout.TEN_SEC);
        WebElement passwordField = driver.findElement(LoginPageEnum.PASSWORD_INPUT.getLocator());
        WebElement loginButton = driver.findElement(LoginPageEnum.LOGIN_BUTTON.getLocator());

        // Send credentials
        usernameField.sendKeys(ConfigReaderUtil.get("username"));
        passwordField.sendKeys(ConfigReaderUtil.get("password"));
        loginButton.click();
        return true;
    }

    public boolean LoginSuccess(){
        WebElement welcomemsg=PageUtil.waitForVisibility(DriverManager.getDriver(),LoginPageEnum.WELCOME_MSG.getLocator(), Timeout.TEN_SEC);
        boolean result=welcomemsg!=null&& welcomemsg.isDisplayed();
        System.out.println("Is Welcome Messsage displayed! "+result);
        return result;
    }


}
