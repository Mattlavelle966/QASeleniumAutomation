package com.qa_test_demo;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mattl\\Documents\\QAExcercise\\QATest\\src\\Resources\\chromedriver.exe"); // Optional if chromedriver is in PATH
        driver = new ChromeDriver();
    }

    @Test
    public void testFormSubmission() {
        // Open the form page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html"); // Replace with actual URL

        // Fill in the form fields
        WebElement nameField = driver.findElement(By.id("my-text-id"));
        nameField.sendKeys("John Doe");

        WebElement passwordField = driver.findElement(By.name("my-password"));
        passwordField.sendKeys("help");

        WebElement messageField = driver.findElement(By.name("my-textarea"));
        messageField.sendKeys("This is a test message.");

        // Click the submit button
        WebElement submitButton = driver.findElement(By.className("btn"));
        System.out.println(submitButton.getText());
        submitButton.click();

        //Wait for pageload
        // Verify confirmation message
        WebElement confirmation = driver.findElement(By.className("display-6"));
        String confirmationText = confirmation.getText();

        assertEquals("Form submitted", confirmationText);
    }

    @After
    public void tearDown() {
        // Close the browser
        System.out.println("test complete");

        driver.quit();
    }
}
