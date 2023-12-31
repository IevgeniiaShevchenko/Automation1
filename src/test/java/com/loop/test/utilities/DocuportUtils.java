package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {

    /**
     * logins to docuport application
     *
     * @param driver, which initialized in test base
     * @param role,   comes from docuport constants
     * @author ievgeniia
     */

    public static void login(WebDriver driver, String role) throws InterruptedException {
        driver.get("https://beta.docuport.app");
        WebElement username = driver.findElement(By.xpath("//label[contains(text(), 'Username or email')]/following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        switch (role.toLowerCase()) {
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD_CLIENT);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_SUPERVISOR);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_ADVISOR);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD_EMPLOYEE);
                break;
            default:
                throw new InputMismatchException("There is not such a role " + role);

        }
        loginButton.click();

        if (role.toLowerCase().equals("client")) {
            Thread.sleep(3000);
            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
            cont.click();
        }
    }
    /**
     * logs out from the application
     * @param driver
     * @author nadir
     */
    public static void logOut(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
}
