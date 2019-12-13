package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Wikipedia {
    //todo
    /*
Wiki assignment
1. Go to https://www.wikipedia.org/
2. Enter redsox
3. Wait until all the search suggestions load
4. Verify that there are more that 1 search suggestions
5. Verify that first search suggestion starts with text Boston Red Sox
6. Create a summary that includes that show when the test started, ended and how long it took. It can be printed in console or some external report. You can use any tools.
 */

    // ExtentReports report; —> this class is used for starting and building the reports.
    ExtentReports report;
    // ExtentHtmlReporter htmlReporter; —> this class is used to create the HTML report file
    ExtentHtmlReporter htmlReporter;
    // ExtentTest extentLogger;—>  this will define a test, enables adding logs, authors, test info, etc
    ExtentTest extentLogger;
     @BeforeMethod
     public void dooo(){
         report = new ExtentReports();
         String path = System.getProperty("user.dir") + "/test-output/report.html";
         htmlReporter = new ExtentHtmlReporter(path);
         report.attachReporter(htmlReporter);

         htmlReporter.config().setReportName("Regression tests");

         report.setSystemInfo("Environment", "QA");
         report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
         report.setSystemInfo("OS", System.getProperty("os.name"));

     }


    @Test
    public void Wiki() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("redsox");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        System.out.println(driver.findElements(By.cssSelector("h3[class]")).size());
        int actual = driver.findElements(By.cssSelector("h3[class]")).size();
        int given = 1;
        Assert.assertTrue(actual > given);


    }

    @Test
    public void ReSocks() {
        extentLogger = report.createTest("How fast test is passed");
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        extentLogger.info("go to wiki");
        driver.get("https://www.wikipedia.org/");
        extentLogger.info("enter red sox");
        driver.findElement(By.id("searchInput")).sendKeys("redsox");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String expected = "Boston Red Sox";
        String actual = driver.findElement(By.xpath("//h3[@class='suggestion-title']")).getText();
        System.out.println("actual = " + actual);
        extentLogger.info("compare results");
        Assert.assertTrue(actual.startsWith(expected));
    }

    @AfterMethod
    public void close(){
        // this is when the report is actually created.
        // this line must run after everything.
        report.flush();
    }

}



