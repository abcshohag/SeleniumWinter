package DemoQA;

import Utils.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SelectMenuPage;

public class SelectMenuTest {
    WebDriver driver;
    SelectMenuPage selectPage;

    @BeforeClass
    void setup(){
        driver = DriverUtil.getWebDriver();
        selectPage = new SelectMenuPage();
        driver.get( selectPage.pageUrl );
    }

    @Test
    void testSingleSelect(){
        DriverUtil.selectByVisibleText( selectPage.singleSelectLocator, "Black" );
    }

    @Test
    void testMultiSelect(){
        DriverUtil.selectByVisibleText( selectPage.multiSelectLocator, "Audi" );
        DriverUtil.selectByVisibleText( selectPage.multiSelectLocator, "Volvo" );
    }

    @Test
    void testFistDropdown(){
        WebElement dropdown = driver.findElement( selectPage.firstSelectLocator );
        dropdown.click();

        WebElement option = driver.findElement( selectPage.firstSelectOption );
        option.click();
    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
