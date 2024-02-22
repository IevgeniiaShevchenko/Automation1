package com.loop.test.day8_windowTables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.PizzaOrderWebTableUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
/*
    1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
    3. test type
    4. test amount
    5. test date
    6. test street
    7. test city
    8. test state
    9. test zip
    10. test card
    11. test card number
    12. test exp
     */
public class T2_pizza_order extends TestBase {
    @Test
    public void test_pizza_type() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Alexandra Gray";

        String expectedPizzaType = "Thin Crust";
        String actualPizzaType = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Pizza type");
        assertEquals(actualPizzaType, expectedPizzaType, "actual does not match expected");
        String expectedAmount = "2";
        String actualAmount = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Amount");
        assertEquals(actualAmount, expectedAmount, "actual does not match expected");
        String expectedDate = "04/15/2021";
        String actualDate = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Date" );
        assertEquals(actualDate, expectedDate, "actual does not match expected");
        String expectedStreet = "7, Miller Street";
        String actualStreet = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Street");
        assertEquals(actualStreet, expectedStreet, "actual does not match expected");
        String expectedCity = "Chicago, IL";
        String actualCity = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "City");
        assertEquals(actualCity, expectedCity, "actual does not match expected");
        String expectedState = "US";
        String actualState = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "State");
        assertEquals(actualState, expectedState, "actual does not match expected");
        String expectedZip = "748";
        String actualZip = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Zip");
        assertEquals(actualZip, expectedZip, "actual does not match expected");
        String expectedCard = "VISA";
        String actualCard = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Card");
        assertEquals(actualCard, expectedCard, "actual does not match expected");
        String expectedCardNumber = "321456789012";
        String actualCardNumber = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Card Number");
        assertEquals(actualCardNumber, expectedCardNumber, "actual does not match expected");
        String expectedExp = "02/24";
        String actualExp = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Exp");
        assertEquals(actualExp, expectedExp, "actual does not match expected");
    }
}
