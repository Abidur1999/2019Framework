package Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class CommonApi {
    public static WebDriver driver = null;

    @Parameters({"url"})

    @BeforeMethod
    public void setUp(String url ){

        System.setProperty("webdriver.chrome.driver","/Users/abidur/Desktop/AutomationWebFramework/Generic/browserdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
// driver.navigate().to(url);
// System.out.println(driver.getTitle());
    }


    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    //helper methods
    public void clickOnElement(String locator){
        try {
            driver.findElement(By.cssSelector(locator)).click();
        }catch (Exception ex){
            driver.findElement(By.id(locator)).click();
        }
    }
    public void typeOnElement(String locator,String value){
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        }catch (Exception ex2){
            driver.findElement(By.id(locator)).sendKeys(value);
        }
    }
}




