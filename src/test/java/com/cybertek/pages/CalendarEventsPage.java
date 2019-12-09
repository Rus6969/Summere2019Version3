package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//tbody//tr[14]//td[9]")
    public WebElement threeDots;

    @FindBy(xpath = "//tbody//tr[14]//td[9]//ul//li//ul//li//a[@title='Edit']")
    public WebElement Edit;

    @FindBy(xpath = "//tbody//tr[14]//td[9]//ul//li//ul//li//a[@title='Delete']")
    public WebElement Delete;

    @FindBy(xpath = "//tbody//tr[14]//td[9]//ul//li//ul//li//a[@title='View']")
    public  WebElement View;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement Grid;

    @FindBy(xpath= "//tbody//tr//td[@class='visibility-cell']")
    public WebElement SixGridOptions;

    @FindBy(xpath = "//tbody//tr//td[@class='title-cell']")
    public  WebElement title;


}
