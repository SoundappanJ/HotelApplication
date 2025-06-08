package utils;

import enums.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.List;

public class PageUtil {

    public static WebElement waitForVisibility(WebDriver driver, By locator, Timeout seconds){
        WebDriverWait wait= new WebDriverWait(driver, seconds.getSeconds());
        return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebDriver driver, By locator, Timeout seconds){
        WebDriverWait wait= new WebDriverWait(driver, seconds.getSeconds());
        return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static List<WebElement> waitForVisibilityAll(WebDriver driver, By locator, Timeout seconds){
        WebDriverWait wait= new WebDriverWait(driver, seconds.getSeconds());
        return (List) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void  waitForInvisibility(WebDriver driver, By locator, Timeout seconds){
        WebDriverWait wait= new WebDriverWait(driver, seconds.getSeconds());
          wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
