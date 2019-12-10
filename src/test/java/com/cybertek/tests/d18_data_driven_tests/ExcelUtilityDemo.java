package com.cybertek.tests.d18_data_driven_tests;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

public class ExcelUtilityDemo {
    @Test
    public void readExcelTest(){
        //create an instance of the excel utility
        // argument 1: lcation of the file
        ExcelUtil qa1Short= new ExcelUtil("Vytrack testusers.xlsx","QA3-all");
    }
}
