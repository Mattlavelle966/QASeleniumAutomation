package com.qa_test_demo;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class AppTest 
{
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    // TODO testCase should be auto increment relative to current running test
    private String testCase = "TC_001";



    @Before
    public void setUp() {
        // Set up Chrome driver
        driver = new ChromeDriver();
    }

    @Test
    public void testFormSubmission() {

        String scenario = "Login with valid credentials";

        String[] entered = {"john doe","help","This is a test message."};

        String enteredMashString = String.join("|", entered);

        String expected = "Form submitted";

        String actual = "NULL";
        
        // Open the form page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");// Replace with actual URL

        // Input array
        WebElement nameField = driver.findElement(By.id("my-text-id"));
        nameField.sendKeys(entered[0]);
        WebElement passwordField = driver.findElement(By.name("my-password"));
        passwordField.sendKeys(entered[1]);
        WebElement messageField = driver.findElement(By.name("my-textarea"));
        messageField.sendKeys(entered[2]);
        // Submit
        WebElement submitButton = driver.findElement(By.className("btn"));

        submitButton.click();

        // Verify confirmation message
        WebElement confirmation = driver.findElement(By.className("display-6"));
        
        String confirmationText = confirmation.getText();

        try {
            actual = confirmationText;
            MDC.put("testCase", testCase);
            MDC.put("scenario", scenario);
            MDC.put("entered", enteredMashString);
            MDC.put("expected", expected);
            MDC.put("actual", actual);
            MDC.put("status", expected.equals(actual) ? "PASSED" : "FAILED");
            logger.info("");
            
        } finally {
            MDC.clear();
        }

        assertEquals("Form submitted", confirmationText);
    }
    

    @After
    public void tearDown() {
        //Close browser
        driver.quit();
    }
}
