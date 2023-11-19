package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {

        // setuo driver
        WebDriverManager.chromedriver().setup();

        // create the driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google
        driver.get("https://www.google.com/");


        // maximize the window
        driver.manage().window().maximize();

        // locate the element
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxWithName = driver.findElement(By.name("q"));
        WebElement aboutLink = driver.findElement(By.linkText("About"));

        // aboutLink.click();

        // create a string what you want to search
        searchBoxWithID.sendKeys("Feyruz is handsome");
        searchBoxWithID.clear();

        String textToSearch = "Loop Academy";
        searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);

        //Get current URL and check that it contains "Loop"
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains("Loop")) {
            System.out.println("Actual URL contains \"Loop\"");
        } else {
            System.err.println("Actual URL DOES NOT contain \"Loop\"");
        }

        //Get actual title and compare it with expected title "Loop Academy - Google Search"
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Loop Academy - Google Search")) {
            System.out.println("Actual Title contains \"Loop\"");
        } else {
            System.err.println("Actual Title DOES NOT contain \"Loop\"");

             /*
        System.out.println(driver.getCurrentUrl().contains("Loop")? "Actual URL contains \"LOOP\" in it -- PASSED" : "Current URL does not " +
                    "match -- FAILED");

        System.out.println(driver.getTitle().contains("Loop academy - Google'da axtarış")? "Actual Title contains \"LOOP\" in it -- PASSED" :
                "Current URL does not " +
                "match -- FAILED");
         */

        }
    }
}






