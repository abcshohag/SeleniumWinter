package DemoQA;

import Utils.DriverUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoQAHomePage;

public class DemoQA {
    WebDriver driver;
    DemoQAHomePage homePage;

    @BeforeClass
    void setup(){
        driver = DriverUtil.getWebDriver();
        driver.manage().window().maximize();
        homePage = new DemoQAHomePage();
        driver.get("http://demoqa.com");
    }

    @Test(priority = 2)
    void testTitle(){
        Assert.assertEquals(driver.getTitle(), "ToolsQA");
    }

    @Test (priority = 3)
    void varifyBannerIsVisible(){
        WebElement el = driver.findElement( homePage.banner );
        Assert.assertTrue(el.isDisplayed());
    }

    @Test (priority = 4)
    void verifyIfTheLogoIsVisible(){
        WebElement el = driver.findElement( homePage.logo );
        el.getText();
        Assert.assertTrue(el.isDisplayed());
    }

    @Test (priority = 5)
    void validateFooter(){
        WebElement el = driver.findElement( homePage.footerText );
        String f = el.getText();
        System.out.println( f.contains("ALL RIGHTS RESERVED") );
        Assert.assertTrue( f.contains("ALL RIGHTS RESERVED"));
    }

    @Test(priority = 1)
    void validateAllMenuPresent() {
        for(String menuName : homePage.menuItems.keySet()){
            DriverUtil.scrollToElementAndClick(homePage.menuItems.get(menuName));
            Assert.assertEquals(driver.findElement(homePage.mainHeader).getText(), menuName);
            driver.navigate().back();
        }
    }

    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}

