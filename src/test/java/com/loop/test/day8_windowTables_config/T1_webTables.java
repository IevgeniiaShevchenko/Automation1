package com.loop.test.day8_windowTables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
/*
   1. login as an advisor
   2. go to users
   3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
   4. validate that user name for alex.de.souza@gmail.com is alexdesouze
   5. validate that phone number for alex.de.souza@gmail.com is +994512060042
   6. validate that role for alex.de.souza@gmail.com is client
   7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
    */
public class T1_webTables extends TestBase {
    @Test
    public void test_webTables() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name");
        System.out.println("actualFullName = " + actualFullName);
        assertEquals(actualFullName, expectedFullName,"Actual does not match expected");

        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "username");
        System.out.println("actualUserNAme = " + actualUserName);
        assertEquals(actualUserName,expectedUserName,"Actual does not match expected");

        String expectedPhoneNumber = "+994512060042";
        String actualPhoneNumber = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "Phone number");
        System.out.println("actualPhoneNumber = " + actualPhoneNumber);
        assertEquals(actualPhoneNumber, expectedPhoneNumber, "Actual does not match expected");

        String expectedRole = "Client";
        String actualRole = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Role");
        System.out.println("actualRole = " + actualRole);
        assertEquals(actualRole, expectedRole, "Actual does not match expected");

        String expectedAdvisor = "Batch1 Group1";
        String actualAdvisor = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Advisor");
        System.out.println("actualAdvisor = " + actualAdvisor);
        assertEquals(actualAdvisor, expectedAdvisor, "Actual does not match expected");
    }
}