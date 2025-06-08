package enums;

import org.openqa.selenium.By;

public enum LoginPageEnum {
    CLICK_BUILD2("//strong[contains(text(),'Go to Build 2')]/parent::a", "CLICK Build 2"),
    USERNAME_INPUT("//input[@name='username']", "ENTER USERNAME"),
    PASSWORD_INPUT("//input[contains(@name,'password')]", "ENTER PASSWORD"),
    LOGIN_BUTTON("//input[contains(@name,'login')]", "CLICK LOGIN"),
    WELCOME_MSG("//td[contains(text(),'Welcome to Adactin Group of Hotels')]/parent::tr","Welcome");

    private final String xpath;
    private final By locator;
    private final String descp;

    LoginPageEnum(String xpath, String descp) {
        this.xpath = xpath;
        this.locator = By.xpath(xpath); // ✅ Assign the By locator
        this.descp = descp;
    }

    public String getXpath() {
        return xpath;
    }

    public By getLocator() {
        return locator;
    }

    public String getDescp() {
        return descp;
    }
}
