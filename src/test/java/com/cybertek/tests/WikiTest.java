package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.tests.d10_synchronization.ImplicitWaitTest;
import com.cybertek.utilities.WebDriverFactory;
import net.bytebuddy.implementation.bind.annotation.Morph;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
Wiki assignment
1. Go to https://www.wikipedia.org/
2. Enter redsox
3. Wait until all the search suggestions load
4. Verify that there are more that 1 search suggestions
5. Verify that first search suggestion starts with text Boston Red Sox
6. Create a summary that includes that show when the test started, ended and how long it took. It can be printed in console or some external report. You can use any tools.
 */
public class WikiTest  {
    // ExtentReports report; —> this class is used for starting and building the reports.
    ExtentReports report;
    // ExtentHtmlReporter htmlReporter; —> this class is used to create the HTML report file
    ExtentHtmlReporter htmlReporter;
    // ExtentTest extentLogger;—>  this will define a test, enables adding logs, authors, test info, etc
    ExtentTest extentLogger;

    @Test
    public void wiwkiTest(){
        report = new ExtentReports();
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        report.createTest("Wiki search verification");

         extentLogger.info("go to wiwkipediaPage");
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.id("searchInput")).sendKeys("redsox");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        System.out.println(driver.findElements(By.cssSelector("h3[class]")).size());


    }
}
