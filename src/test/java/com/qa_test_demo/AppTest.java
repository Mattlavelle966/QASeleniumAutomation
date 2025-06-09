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

import static org.junit.Assert.assertEquals;

public class AppTest 
{
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);



    @Before
    public void setUp() {
        // Set up Chrome driver
        logger.info("Setting up ChromeDriver...");
        
        driver = new ChromeDriver();
    }

    @Test
    public void testFormSubmission() {
        // Open the form page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html"); // Replace with actual URL

        // Fill in the form fields
        logger.info("Starting form submission test");
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        logger.info("Opened form page");


        WebElement nameField = driver.findElement(By.id("my-text-id"));
        nameField.sendKeys("John Doe");
        logger.info("Entered name: John Doe");

        WebElement passwordField = driver.findElement(By.name("my-password"));
        passwordField.sendKeys("help");
         logger.info("Entered password");

        WebElement messageField = driver.findElement(By.name("my-textarea"));
        messageField.sendKeys("This is a test message.");
        logger.info("Entered message");
        // Click the submit button
        WebElement submitButton = driver.findElement(By.className("btn"));

        logger.info("Submit button text: {}", submitButton.getText());

        submitButton.click();

        //Wait for pageload
        // Verify confirmation message
        WebElement confirmation = driver.findElement(By.className("display-6"));
        String confirmationText = confirmation.getText();

        logger.info("Confirmation text received: {}", confirmationText);
        System.out.println( confirmationText );
        assertEquals("Form submitted", confirmationText);
    }

    @After
    public void tearDown() {
        logger.info("Tearing down and closing browser");

        logger.info("-------------Test complete------------------------");

        driver.quit();
    }
}
