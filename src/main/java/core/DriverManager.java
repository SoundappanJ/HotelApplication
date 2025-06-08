package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager{
    private static WebDriver driver;
    private static final String baseurl="https://adactinhotelapp.com/";

    //Singleton Constructor
    private DriverManager(){

    }
    public static WebDriver getDriver(){
        if(driver==null){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

        }
        return driver;

    }

    public static void StartWeb(){
        if(baseurl!=null&& ! baseurl.isEmpty()){
            driver.get(baseurl);
        }else{
            System.out.println("Web Appilication URL in NULL");
        }

    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}