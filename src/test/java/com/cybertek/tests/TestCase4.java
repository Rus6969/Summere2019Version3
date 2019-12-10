package com.cybertek.tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase4 extends TestBase {

    @Test
    public void VerifyViewDeleteEditButtons() {
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
//
////        Assert.assertTrue(calendarEventsPage.Edit.isDisplayed());
////        Assert.assertTrue(calendarEventsPage.Delete.isDisplayed());
////        Assert.assertTrue(calendarEventsPage.View.isDisplayed());
//          Assert.assertEquals(calendarEventsPage.Edit.getText(),"Edit");
//          Assert.assertEquals(calendarEventsPage.View.getText(), "View");
//          Assert.assertEquals(calendarEventsPage.Delete.getText(),"Delete");

//        List<WebElement> actualWebElemetns = driver.findElements(By.xpath("//tbody//tr[14]//td[9]//ul//li//ul//li//a[@title='Edit']"));
//        List<String>actual = new ArrayList<>() ;
//        for (WebElement each: actualWebElemetns) {
//            actual.add( each.getText());
//        }
//        System.out.println(actual.toString());

    }

    @Test
    public void VerifyTitleColumnISdisplayed() {
        // create a report test
        extentLogger = report.createTest("Verify Title Column IS dispalyed");
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

        extentLogger.info("click on Grid gear");
        calendarEventsPage.Grid.click();

        extentLogger.info("Unselect all options besides Title");
        for (int i = 2; i <= 7; i++) {
            driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[@class='visibility-cell']")).click();

        }

        extentLogger.info("Check  is tittle displayed");
        calendarEventsPage.title.isDisplayed();
        Assert.assertTrue(calendarEventsPage.title.isDisplayed());


    }

    @Test
    public void VerifyallPageSubtitlesAreDisplayed() {
        // create a report test
        extentLogger = report.createTest("Verify that “All Calendar Events” page subtitle is displayed");
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

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        extentLogger.info("click on create create a calendar event");
        calendarEventsPage.createCalendarEvent.click();

        extentLogger.info("Wait Loading element dissapear");
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("click on cancel button");
        createCalendarEventsPage.cancel.click();

        extentLogger.info("Wait Loading element dissapear");
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify Page Subtitle is displayed");

        Assert.assertTrue(createCalendarEventsPage.AllCalendarEventSubtitle.isDisplayed());

    }

    @Test
    public void VerifyTimeDifferenceInOneHour() throws InterruptedException, ParseException {
        // create a report test
        extentLogger = report.createTest("Verify 1 hour difference between start and end time");
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

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        extentLogger.info("click on create create a calendar event");
        calendarEventsPage.createCalendarEvent.click();

        extentLogger.info("Wait Loading element dissapear");
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("get a start time");
        createCalendarEventsPage.startTime.click();


        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");

        extentLogger.info(" get value in start time ");
        String start = createCalendarEventsPage.startTime.getAttribute("value");
        System.out.println("start = " + start);

        extentLogger.info("get value in end time");
        String end = createCalendarEventsPage.endTime.getAttribute("value");
        System.out.println("end = " + end);
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
//.parse helps us to convert string to actual time and getTime() method returns us time in milliseconds
//thats why we can use divided in milliseconds
//or basicly minus the meeting end time from start time
long elapsed = (sdf.parse(second).getTime() / 3600000) - (sdf.parse(first).getTime() / 3600000);
//System.out.println(elapsed/3600000);
Assert.assertEquals(elapsed, 1);
         */
        long difference =(sdf.parse(end).getTime()/3600000)-(sdf.parse(start).getTime()/3600000);
        System.out.println("difference = " + difference);
        extentLogger.info("Verify difference in one hour");
        Assert.assertEquals(difference,1);

    }

    @Test
    public void ChooseAndVerifyTime(){
        // needs for scrolling down a page .
       // JavascriptExecutor js =(JavascriptExecutor) driver;

        extentLogger = report.createTest("Choose start time 9 and Verify that end time is 10");
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

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        extentLogger.info("click on create create a calendar event");
        calendarEventsPage.createCalendarEvent.click();

        extentLogger.info("Wait Loading element dissapear");
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("click on start time");
        createCalendarEventsPage.startTime.click();

        extentLogger.info("choose 9 PM");
        createCalendarEventsPage.NinePM.click();

        extentLogger.info(" get time from end time ");
        createCalendarEventsPage.endTime.getAttribute("value");
        System.out.println(createCalendarEventsPage.endTime.getAttribute("value"));

        extentLogger.info("Verify time equal 10:00 PM");

        Assert.assertEquals(createCalendarEventsPage.endTime.getAttribute("value"),"10:00 PM");


    }
      @Test
    public void AllDayEventDisplayed(){
          extentLogger = report.createTest("Choose start time 9 and Verify that end time is 10");
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

          CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
          extentLogger.info("click on create create a calendar event");
          calendarEventsPage.createCalendarEvent.click();

          extentLogger.info("Wait Loading element dissapear");
          createCalendarEventsPage.waitUntilLoaderScreenDisappear();

          extentLogger.info("click on All Day Event checkBox");
          createCalendarEventsPage.AllDayEvent.click();
          BrowserUtils.waitFor(3);
          extentLogger.info("Check that start time IS not Displayed");
          Assert.assertFalse(createCalendarEventsPage.startTime.isDisplayed());
          extentLogger.info("Check that end time IS not Displayed");
          Assert.assertFalse(createCalendarEventsPage.endTime.isDisplayed());

      }

       @Test
      public void RepeatDropDown(){
           extentLogger = report.createTest("Choose start time 9 and Verify that end time is 10");
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

           CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
           extentLogger.info("click on create create a calendar event");
           calendarEventsPage.createCalendarEvent.click();

           extentLogger.info("Wait Loading element dissapear");
           createCalendarEventsPage.waitUntilLoaderScreenDisappear();
           extentLogger.info("click on repeat button");
           createCalendarEventsPage.repeat.click();
           extentLogger.info("Verify that repeat option is selected ");
           Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());

           extentLogger.info("Verify that 'daily' is selected by default in Repeats");
           Assert.assertEquals(createCalendarEventsPage.daily.getAttribute("value"),"daily");

            extentLogger.info("Verify that  following options are available undre repeats");
            createCalendarEventsPage.daily.click();


       }

}
