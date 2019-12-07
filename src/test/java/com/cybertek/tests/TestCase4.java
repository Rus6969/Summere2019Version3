package com.cybertek.tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase4 extends TestBase {

    @Test
    public  void VerifyViewDeleteEditButtons(){
        // create a report test
        extentLogger = report.createTest("Verify View, Delete, Edit Buttons");
        extentLogger.info("Log in under store manager");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);


        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Go to Calaendar events ");
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();


        extentLogger.info("Wait Loading element dissapear");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on Three dots option");
        calendarEventsPage.threeDots.click();

//        extentLogger.info("check expected List");
//        List<String>expected =Arrays.asList("View", "Edit","Delete");

        extentLogger.info("find those elemets");
        extentLogger.info("Button edit is displayed");
        calendarEventsPage.Edit.isDisplayed();
        extentLogger.info("Button Delete is displayed");
        calendarEventsPage.Delete.isDisplayed();
        extentLogger.info("Button View is displayed");
        calendarEventsPage.View.isDisplayed();



//        List<WebElement> actualWebElemetns = driver.findElements(By.xpath("//tbody//tr[14]//td[9]//ul//li//ul//li//a[@title='Edit']"));
//        List<String>actual = new ArrayList<>() ;
//        for (WebElement each: actualWebElemetns) {
//            actual.add( each.getText());
//        }
//        System.out.println(actual.toString());

    }
    @Test
    public void VerifyTitleColumnISdisplayed(){
        // create a report test
        extentLogger = report.createTest("Verify View, Delete, Edit Buttons");
        extentLogger.info("Log in under store manager");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);


        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Go to Calaendar events ");
        dashboardPage.navigateToModule("Activities", "Calendar Events");

    }

}
