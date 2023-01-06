package Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {
    public static WebDriver driver;
    public static WebDriver getWebDriver(){
        WebDriverManager.chromedriver().setup();
        if(driver != null && !driver.toString().contains("(null)")){
            return driver;
        }
        driver = new ChromeDriver();
        return driver;
    }

    public static void clickUsingJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickUsingJS(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void zoomOutToPercentage(double percentage) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '" + percentage + "'");
    }

}
