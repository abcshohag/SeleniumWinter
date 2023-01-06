
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LogIn {
    WebDriver driver;
    @BeforeClass
    void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    void NavigateToBookStore() throws InterruptedException {
        By navigate = new By.ByCssSelector(".category-cards div:nth-child(6)");
        WebElement navigateEL = driver.findElement(navigate);
//        navigateEL.click();
        clickUsingJS(navigateEL);
//        Action ac = new Action(driver);
        Thread.sleep(2000);
        // navigate to LogIn.
        By NavigateLogIn = new By.ByCssSelector("#login");
        WebElement logInEL = driver.findElement(NavigateLogIn);
        clickUsingJS(logInEL);
    }

    @Test(priority = 1)
    void LoginBookStore() {
        // UserName
        By userNameLocate = new By.ByCssSelector("#userName");
        WebElement userNameEL = driver.findElement(userNameLocate);
        userNameEL.sendKeys("Adamhamilton@gmail.com");

        // Password
        By passwordLocate = new By.ByCssSelector("#password");
        WebElement passwordEL = driver.findElement(passwordLocate);
        passwordEL.sendKeys("@Adam123");
    }

    public void clickUsingJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}