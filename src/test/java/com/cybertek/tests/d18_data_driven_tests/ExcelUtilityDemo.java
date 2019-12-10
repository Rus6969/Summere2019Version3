package com.cybertek.tests.d18_data_driven_tests;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilityDemo {
    @Test
    public void readExcelTest(){
        //create an instance of the excel utility
        // argument 1: lcation of the file
        // when we create object of this utility it means we opened the file and accsessed certain sheet inside it
        ExcelUtil qa1Short= new ExcelUtil("src/test/resources/Vytrack testusers.xlsx","QA3-all");
         //get numbers of column
        System.out.println("qa1Short.columnCount() = " + qa1Short.columnCount());

        //get all column names
        System.out.println("qa1Short.getColumnsNames() = " + qa1Short.getColumnsNames());
        // /Users/ruslansamatov/IdeaProjects/Summer2019VATestNGSeleniumProject/src/test/resources/test_file.txt(cut till src to get right relativ xpath

        // get all data in list
        List<Map<String, String>> dataList = qa1Short.getDataList();

        for (Map<String, String> stringStringMap : dataList) {
            System.out.println(stringStringMap);
        }

        // get all data in 2d array

        String[][] dataArray = qa1Short.getDataArray();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(Arrays.deepToString(dataArray));

    }

}