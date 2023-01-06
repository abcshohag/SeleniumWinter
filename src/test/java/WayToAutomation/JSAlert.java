package WayToAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class JSAlert{
    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
    }

    @Test
    void test_Alert1() throws InterruptedException {
        By alertButtonLocator = new By.ByCssSelector(".row:first-child button");
        WebElement alertButton = driver.findElement(alertButtonLocator);
        alertButton.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }

    @Test
    void test_Alert2() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By alertButtonLocator = new By.ByCssSelector("#timerAlertButton");
        WebElement alertButton = driver.findElement(alertButtonLocator);
        alertButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    @Test
    void test_Alert3() throws InterruptedException {
        Thread.sleep(3000);
        By alertButtonLocator = new By.ByCssSelector("#confirmButton");
        WebElement alertButton = driver.findElement(alertButtonLocator);

        //clicking Ok
        alertButton.click();
        driver.switchTo().alert().accept();

        //confirm is the right text shows up
        By resultLocator = new By.ByCssSelector("#confirmResult");
        WebElement resultEl = driver.findElement(resultLocator);

        String result = resultEl.getText();
        Assert.assertTrue( result.contains("Ok") );

        //clicking Cancel
        alertButton.click();
        driver.switchTo().alert().dismiss();

        //confirm is the right text shows up
        result = resultEl.getText();
        Assert.assertTrue( result.contains("Cancel") );
    }

    @Test
    void testAlert() throws InterruptedException {
        By prompLocator = new By.ByCssSelector("#promtButton");
        WebElement promptButton = driver.findElement(prompLocator);

        //Negetive Test
        promptButton.click();
        driver.switchTo().alert().sendKeys("1e0e3868ee");
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();

        By resultSelector = new By.ByCssSelector("#promptResult");
        Assert.assertThrows( () -> driver.findElement(resultSelector) );

        //Positive  Test
        promptButton.click();
        driver.switchTo().alert().sendKeys("1e0e3868ee");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        WebElement resultEl = driver.findElement(resultSelector);
        String resultText = resultEl.getText();
        Assert.assertTrue(resultText.contains("1e0e3868ee"));
    }

    @AfterClass
    void wrapup() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
