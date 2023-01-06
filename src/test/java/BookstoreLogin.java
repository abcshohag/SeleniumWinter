
import Utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.DemoQAHomePage;

import java.time.Duration;

public class BookstoreLogin {
    WebDriver driver;
    JavascriptExecutor js;
    DemoQAHomePage homePage;
    BookStorePage bookstorePage;

    @BeforeClass
    void SetUp() {
        driver = DriverUtil.getWebDriver();
        //instantiating page objects
        homePage = new DemoQAHomePage();
        bookstorePage = new BookStorePage();
        driver.get(homePage.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

    @Test(priority = 1)
    void nagivateToLoginPage() throws InterruptedException {
        DriverUtil.clickUsingJS(homePage.bookStore);
        Assert.assertEquals(driver.getCurrentUrl(), bookstorePage.bookstoreUrl);
        Thread.sleep(2000);
        driver.findElement(bookstorePage.loginSubmenuLocator).click();
        Assert.assertEquals(driver.getCurrentUrl(), bookstorePage.loginUrl);
    }

    @Test(priority = 2)
    void LoginBookStore() throws InterruptedException {
        driver.findElement( bookstorePage.userNameLocator ).sendKeys("Adamhamilton@gmail.com");
        driver.findElement(bookstorePage.passwordLocator).sendKeys("@Adam123");
        driver.findElement( bookstorePage.loginButtonLocator ).click();
        Thread.sleep(3000);
        String userNameFromPage = driver.findElement( bookstorePage.userNameLabelLocator ).getText();
        Assert.assertEquals(userNameFromPage, "Adamhamilton@gmail.com");
        DriverUtil.zoomOutToPercentage(.50);
    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }




}