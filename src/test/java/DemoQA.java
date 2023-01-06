import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DemoQA {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/"); // .get() method to navigate to a website

        // Click on the Element Menu
        By elementLocator = new By.ByCssSelector(".mt-4:first-child");
        WebElement element = driver.findElement(elementLocator);
        element.click();


        //Header element
        By headerLocator = new By.ByCssSelector(".main-header");
        WebElement header = driver.findElement(headerLocator);
        String headerText = header.getText();
        Assert.assertEquals(headerText, "Elements");


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

        //quitting the browser
        driver.quit();
    }
}
