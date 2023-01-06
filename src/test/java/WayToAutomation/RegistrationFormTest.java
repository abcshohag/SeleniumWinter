package WayToAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RegistrationFormTest {
    WebDriver driver; //declaration

    // String name; - Declaration
    // String age;
    // name = "USA"
    // WebDriver d = new ChromeDriver();
    // sout(name.toLowerCase());


    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //Instantiation
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");
    }


    @Test
    void completeRegistration() throws InterruptedException {
        //locator for Registaration menu
        By regLink = new By.ByCssSelector(".linkbox:nth-child(5) a");
        WebElement regLinkElement = driver.findElement(regLink);
        regLinkElement.click();
        Thread.sleep(1000);

        //steps to get all opened tabs
        ArrayList<String> tabs = new ArrayList<>( driver.getWindowHandles() );

        String secondTabAddress = tabs.get(1);

        //navigate to tab #2
        driver.switchTo().window( secondTabAddress );

        Thread.sleep(5000);

        //enter first name
        By firstName = new By.ByCssSelector("fieldset:first-child p:first-child input");
        WebElement firstNameEl = driver.findElement(firstName);
        firstNameEl.sendKeys("Donald");

        //enter last name
        By lastName = new By.ByCssSelector("fieldset:first-child p:last-child input");
        WebElement lastNameEl = driver.findElement(lastName);
        lastNameEl.sendKeys("Trump");

        //Select single
        By single = new By.ByCssSelector("label:nth-child(1) [name='m_status']");
        WebElement singleRadio = driver.findElement(single);
        singleRadio.click();


        //Select hobby reading
        By reading = new By.ByCssSelector("label:nth-child(2) [name='hobby']");
        WebElement readingCheckbox = driver.findElement(reading);
        readingCheckbox.click();

        //Select country
        By country = new By.ByCssSelector("fieldset:nth-child(4) select");
        Select countrySelect = new Select( driver.findElement(country) );
        countrySelect.selectByVisibleText("India");


        //Select month
        By month = new By.ByCssSelector(".time_feild:nth-child(2) select");
        Select monthSelect = new Select(driver.findElement(month));
        monthSelect.selectByVisibleText("1");

        //Select day
        By day = new By.ByCssSelector(".time_feild:nth-child(3) select");
        Select daySelect = new Select(driver.findElement(day));
        daySelect.selectByVisibleText("1");

        //Select year
        By year = new By.ByCssSelector(".time_feild:nth-child(4) select");
        Select yearSelect = new Select(driver.findElement(year));
        yearSelect.selectByVisibleText("2014");


        //Phone number
        By phone = new By.ByCssSelector(".fieldset [name='phone']");
        WebElement phoneElement = driver.findElement(phone);
        phoneElement.sendKeys("3476543210");

        //user name
        By username = new By.ByCssSelector(".fieldset [name='username']");
        WebElement usernameElement = driver.findElement(username);
        usernameElement.sendKeys("DonaldTrump@gmail.com");

        //email
        By email = new By.ByCssSelector(".fieldset [name='email']");
        WebElement emailElement = driver.findElement(lastName);
        emailElement.sendKeys("DonaldTrump@gmail.com");


        Thread.sleep(3000);
//        Actions act = new Actions(driver);
//        act.moveToElement(regLinkElement).click().build().perform();
    }



    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}
