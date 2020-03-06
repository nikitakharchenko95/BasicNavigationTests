package com.cbt.utilities;
import org.openqa.selenium.WebDriver;


import java.util.*;
import java.util.concurrent.TimeUnit;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        driver.get(urls.get(0));
        String expectedTitle = driver.getTitle();
        String expectedURL = driver.getCurrentUrl();
        System.out.println("Title Verification:");
        for( String each : urls){
            driver.get(each);
            StringUtility.verifyEquals(expectedTitle, driver.getTitle());

        }
        System.out.println("URL Verification:");
        for( String each : urls){
            driver.get(each);

            if(driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com")){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }
        }
        driver.quit();
    }
}
