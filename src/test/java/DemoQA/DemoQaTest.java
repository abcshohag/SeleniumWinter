package DemoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQaTest {
    WebDriver driver;
    WebElement header;
    By headerLocator;
    String headerText;

    //declare and initialize driver
    @BeforeClass
    void preparation(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/"); // .get() method to navigate to a website
    }


    @Test(priority = 2, groups = "Smoke Test")
    void testingElement(){
        // Click on the Element Menu
        By elementLocator = new By.ByCssSelector(".mt-4:first-child");
        WebElement element = driver.findElement(elementLocator);
        element.click();


        //Header element
        headerLocator = new By.ByCssSelector(".main-header");
        header = driver.findElement(headerLocator);
        headerText = header.getText();
        Assert.assertEquals(headerText, "Elements");
    }


    @Test(priority = 3)
    void testForm(){
        // Click on the logo to come to the home screen
        By logoLocator = new By.ByCssSelector("header img");
        WebElement logo = driver.findElement(logoLocator);
        logo.click();

        //Click on the Form menu
        By formsLocator = new By.ByCssSelector(".mt-4:nth-child(2)");
        WebElement forms = driver.findElement(formsLocator);
        forms.click();

        header = driver.findElement(headerLocator);
        headerText = header.getText();
        Assert.assertEquals(headerText, "Forms");
    }


    @AfterClass
    void wrapUp(){
        //quitting the browser
        driver.quit();
    }
}
