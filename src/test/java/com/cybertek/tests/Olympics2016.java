package com.cybertek.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Olympics2016 extends TestBase {


    @Test
    public void MedalTable() {

        extentLogger = report.createTest("Verify that by default the Medal table is sorted by rank.");
        extentLogger.info("go to Wikipedia");
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        extentLogger.info("get a rank range");
        List<WebElement> rank= driver.findElements(By.xpath("//table[9]//tbody//tr//td[1]"));
        List<String> str = new ArrayList<>();

        for (WebElement each : rank) {
            str.add(each.getText());
        }

        str.remove(11);
        str.remove(10);
        System.out.println(str);

        List<Integer> numbers = new ArrayList<>() ;

        for (int i = 0 ; i < str.size(); i++){
            numbers.add(Integer.parseInt(str.get(i)));

        }
            boolean blat=false;
            for ( int i = 0 ; i<str.size(); i++){
                if(numbers.get(i)== i+1){
                    blat=true;
                }

            Assert.assertTrue(blat);

            }

            List<Integer>expected= new ArrayList<>(Arrays.asList(1,2,3,4,6,5,7,8,9,10));
              Collections.sort(expected);

              Assert.assertTrue(numbers==expected);

    }



}
