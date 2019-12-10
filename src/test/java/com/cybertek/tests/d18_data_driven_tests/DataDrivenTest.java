package com.cybertek.tests.d18_data_driven_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
    // this method provides test data
    @DataProvider
    public Object[][] testData() {
        String[][] data = {{"kung fu", "10"}, {"titanic", "1"}, {"Interstellar", "2"}, {"Iam a legend", "10"},{"Panda","78"}};

        return data;
    }
     @Test(dataProvider = "testData")
    public void test1(String name,String rating){
         System.out.println("Movie "+name+" has rating "+rating);

     }
}