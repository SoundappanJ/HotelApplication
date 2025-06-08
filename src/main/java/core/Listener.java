package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jshell.Snippet;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listener implements ITestListener {

    public Listener(){}
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Started Test: " + result.getMethod());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("\nTEST PASSED\n");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        if (DriverManager.getDriver() != null) {
            TakesScreenshot screen = (TakesScreenshot) DriverManager.getDriver();
            File sourceFile = screen.getScreenshotAs(OutputType.FILE);
            try {
                File destFile = new File("./screenshot/" + result.getName() + ".png");
                FileUtils.copyFile(sourceFile, destFile);

            } catch ( IOException e) {
                System.out.println("Error in taking screenshot"+e.getMessage());
            }
        }else{
            System.out.println("Failed to take screnshot"+DriverManager.getDriver().getCurrentUrl());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("TEST SKIPPED"+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TEST FINISHED");

    }

}
