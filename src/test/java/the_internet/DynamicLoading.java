package the_internet;

import Utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SelectMenuPage;

import java.time.Duration;

public class DynamicLoading {

    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = DriverUtil.getWebDriver();
        driver.get( "https://the-internet.herokuapp.com/dynamic_loading/1" );
    }

    @Test
    void dynamicWaitTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By startButton = new By.ByCssSelector("#start button");
        driver.findElement( startButton ).click();

        By outputText = new By.ByCssSelector("#finish");

        wait.until(ExpectedConditions.titleIs ( "The Internet" ));

        WebElement el = driver.findElement(outputText);

        String output = el.getText();

        Assert.assertEquals(output, "Hello World!");

    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
