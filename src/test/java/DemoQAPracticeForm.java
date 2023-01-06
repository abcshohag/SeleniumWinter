import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQAPracticeForm {
    WebDriver d;
    final String TEST_IMG_PATH  = "/Users/shohag/IdeaProjects/SeleniumWinter/TestData/img.png";

    @BeforeClass
    void test_prep(){
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
        // Instantiating JS Executor
//        d.manage().window().maximize();
        d.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    void practiceFormTest() throws InterruptedException {
        By fName = new By.ByCssSelector("#firstName");
        By lName = new By.ByCssSelector("#lastName");
        By email = new By.ByCssSelector("#userEmail");
        By gender_male = new By.ByCssSelector("[for=\"gender-radio-1\"]");
        By phone = new By.ByCssSelector("#userNumber");

        WebElement fNameEl = d.findElement(fName);
        fNameEl.sendKeys("John");

        WebElement lNameEl = d.findElement(lName);
        lNameEl.sendKeys("Adams");

        WebElement emailEl = d.findElement(email);
        emailEl.sendKeys("John.Adams@USA.com");

        WebElement genderMaleEl = d.findElement(gender_male);
        genderMaleEl.click();

        WebElement phoneEl = d.findElement(phone);
        phoneEl.sendKeys("4809876543");

        // 12/16/1971

        //click on the DOB date picker
        By dob = new By.ByCssSelector("#dateOfBirthInput");
        WebElement dobEl = d.findElement(dob);
        dobEl.click();

        //selecting the year
        By yearLocator = new By.ByCssSelector(".react-datepicker__year-select");
        Select yearSelect = new Select( d.findElement(yearLocator) );
        yearSelect.selectByVisibleText("1971");

        // selecting the month
        By monthLocator = new By.ByCssSelector(".react-datepicker__month-select");
        Select monthSelect = new Select( d.findElement(monthLocator) );
        monthSelect.selectByVisibleText("December");

        By dateLocator = new By.ByXPath("//div[contains(text(),'16')]");
        WebElement dateEl = d.findElement( dateLocator );
        dateEl.click();

        By subject = new By.ByCssSelector("#subjectsInput");
        WebElement subjectEl = d.findElement(subject);
        subjectEl.sendKeys("Computer");
        Thread.sleep(1000);
        subjectEl.sendKeys(Keys.TAB);


        //Hobbies
        By hobby1 = new By.ByCssSelector("[for=\"hobbies-checkbox-1\"]");
        WebElement hobbyEl1 = d.findElement(hobby1);
        hobbyEl1.click();;

        By hobby2 = new By.ByCssSelector("[for=\"hobbies-checkbox-2\"]");
        WebElement hobbyEl2 = d.findElement(hobby2);
        hobbyEl2.click();;

        By hobby3 = new By.ByCssSelector("[for=\"hobbies-checkbox-3\"]");
        WebElement hobbyEl3 = d.findElement(hobby3);
        hobbyEl3.click();

        By uplaod = new By.ByCssSelector("#uploadPicture");
        WebElement uploadEl  = d.findElement(uplaod);
        uploadEl.sendKeys( TEST_IMG_PATH );

        By address = new By.ByCssSelector("#currentAddress");
        WebElement addressEl = d.findElement(address);
        addressEl.sendKeys("123 Broadway, New York, NY 10004");

        By state = new By.ByCssSelector("#react-select-3-input");
        WebElement stateEl = d.findElement(state);
        stateEl.sendKeys("Rajasthan");
        Thread.sleep(500);
        stateEl.sendKeys(Keys.TAB);


        By city = new By.ByCssSelector("#react-select-4-input");
        WebElement cityEl = d.findElement(city);
        cityEl.sendKeys("Jaipur");
        Thread.sleep(500);
        cityEl.sendKeys(Keys.TAB);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) d;
        jsExecutor.executeScript("document.body.style.zoom=.70");

        Thread.sleep(3000);

        By submit = new By.ByCssSelector("[type=\"submit\"");
        WebElement submitEl = d.findElement(submit);

        jsExecutor.executeScript("arguments[0].click()", submitEl);


        // Assertion
        By studentName = new By.ByCssSelector("tbody tr:first-child td:last-child");
        WebElement studentNameEl = d.findElement(studentName);
        String val = studentNameEl.getText();
        Assert.assertTrue( val.contains("John") );
        Assert.assertTrue( val.contains("Adams") );

        By phoneLocator = new By.ByCssSelector("tr:nth-child(4) td:last-child");
        WebElement phoneElement = d.findElement(phoneLocator);
        String val1 = phoneElement.getText();
        Assert.assertTrue( val1.equals("4809876543") );
    }


    @AfterClass
    void close() throws InterruptedException {
        Thread.sleep(4000);
        d.quit();
    }
}
