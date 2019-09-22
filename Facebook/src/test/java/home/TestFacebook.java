package home;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestFacebook {

    public static WebDriver driver = null;

    @BeforeClass
    public static void setUp() {
        // Opening up the browser.
        System.setProperty("webdriver.chrome.driver",
                "/Users/abidur/Desktop/Facebook/src/main/java/driver/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Navigate to facebook.com
        driver.get("https://facebook.com");
    }

    @AfterClass
    public static void cleanUp() {
        // Close the driver.
        driver.close();
    }

    @Test
    public void testUserCannotLogInWithInvalidCredentials() {
        // Enter in an invalid email
        driver.findElement(By.id("email")).sendKeys("@@##2");

        // Enter in an invalid password
        driver.findElement(By.name("pass")).sendKeys("A@E");

        // Click on the Log In button
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

        // Assert error message
        boolean isErrorDisplayed = driver.findElement
                (By.xpath("//div[text()='The email or phone number you’ve " +
                        "entered doesn’t match any account. ']")).isDisplayed();

        Assert.assertTrue(isErrorDisplayed);
    }

}




