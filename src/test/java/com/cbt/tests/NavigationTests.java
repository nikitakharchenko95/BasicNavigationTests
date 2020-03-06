package com.cbt.tests;
import com.cbt.utilities.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationTests {
    // Method takes browse name as parameter
    public static void  TestCase1(String browserName){
        WebDriver driver = BrowserFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://google.com");
        String title1 = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String title2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title1, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title2, driver.getTitle());
        driver.quit();
    }
    //Method execute TestCase1 for all browsers depends on OS
    public static void TestCase1exe(){
        String [] browsersforWindows = new String[]{"chrome" , "firefox", "edge"};
        String [] browsersforMac = new String[]{"chrome" , "safari"};
        if(System.getProperty("os.name").toLowerCase().contains("mac")){
            for(String s : browsersforMac){
                System.out.println("Results for "+s+" browser");
                TestCase1(s);

            }
        }else if(System.getProperty("os.name").toLowerCase().contains("windows")){
            for(String s : browsersforWindows){
                System.out.println("Results for "+s+" browser");
                TestCase1(s);
            }
        }else{
            System.out.println("INVALID OS");
        }

    }

    public static void main(String[] args) {
        TestCase1exe();
    }

}
