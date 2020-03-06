package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browserName){

        if(System.getProperty("os.name").toLowerCase().contains("windows")&&browserName.equalsIgnoreCase("safari")){
            return null;
        }else if(System.getProperty("os.name").toLowerCase().contains("mac")&&browserName.equalsIgnoreCase("edge")){
            return null;
        }else{
            if(browserName.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }else if(browserName.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }else if(browserName.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }else if(browserName.equalsIgnoreCase("safari")){

                return new SafariDriver();
            }else{
                return null;
            }
        }


    }



}
