package com.cbt.utilities;
import org.openqa.selenium.WebDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestVerification3 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");


        for( String each : urls){
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(each);
            if(driver.getCurrentUrl().contains(driver.getTitle().toLowerCase().replaceAll(" ", ""))){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }
            driver.close();
        }

    }
}
