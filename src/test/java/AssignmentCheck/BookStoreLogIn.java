// Lamia

package AssignmentCheck;

import Utils.DriverUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookStoreLogIn {
    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.edgedriver().setup();
        driver = DriverUtil.getWebDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }
    @Test
    void ClickToBookStore() throws  InterruptedException{
        By Click = new By.ByCssSelector("div.category-cards :nth-child(6)");
        WebElement ClickEl = driver.findElement(Click);
        ClickEl.click();
        Thread.sleep(2000);

        //navigate to  login page
        By navigatetoLogin = new By.ByCssSelector("#login");
        WebElement LoginEl = driver.findElement(navigatetoLogin);
        LoginEl.click();
        Thread.sleep(2000);

        //username
        By UserName = new By.ByCssSelector("#userName");
        WebElement UserNameEl = driver.findElement(UserName);
        UserNameEl.sendKeys("Lamia");

        //password
        By Password = new By.ByCssSelector("#password");
        WebElement PasswordEl = driver.findElement(Password);
        PasswordEl.sendKeys("'L''a'mi12,%");

        //enter login button
        By enterLogin = new By.ByCssSelector("#login");
        WebElement enterLoginEl = driver.findElement(enterLogin);
        enterLoginEl.click();

        //Assertion
        Thread.sleep(2000);
        By Unamefrompage = new By.ByCssSelector("#userName-value");
        WebElement UnamefrompageEl = driver.findElement(Unamefrompage);
        String value = UnamefrompageEl.getText();
        Assert.assertEquals(UnamefrompageEl.getText(),"Lamia" );
        Thread.sleep(2000);


        //click a book
        By Book = new By.ByCssSelector("[id='see-book-Git Pocket Guide']");
        WebElement BookEl = driver.findElement(Book);
        BookEl.click();
        Thread.sleep(2000);

        //Add to the collection
        Thread.sleep(2000);
        By addingCollection = new By.ByCssSelector("div:last-child> #addNewRecordButton");
        WebElement addingCollectionEl = driver.findElement(addingCollection);
        DriverUtil.clickUsingJS(addingCollectionEl);

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //navigate to profile page
        By navigateToProfilePage = new By.ByCssSelector(".element-group:nth-child(6) #item-3");
        WebElement ProfileEl = driver.findElement(navigateToProfilePage);
        ProfileEl.click();

        //delete the book
        Thread.sleep(1000);
        By deleteTheBook = new By.ByCssSelector("#delete-record-undefined");
        WebElement deletethebookEl = driver.findElement(deleteTheBook);
        deletethebookEl.click();

        //confirm delete
        By confirmDelete = new By.ByCssSelector("#closeSmallModal-ok");
        WebElement confirmEl = driver.findElement(confirmDelete);
        confirmEl.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


    }
    @AfterClass
    void  wrapUp() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}