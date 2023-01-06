package pages;

import Utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStorePage {
    public String loginUrl = "https://demoqa.com/login";
    public String bookstoreUrl = "https://demoqa.com/books";
    public String profileUrl = "https://demoqa.com/profile";

    public By loginSubmenuLocator = new By.ByCssSelector("#login") ;
    public By userNameLocator = new By.ByCssSelector("#userName");
    public By passwordLocator = new By.ByCssSelector("#password");

    public By loginButtonLocator = new By.ByCssSelector("#login");

    public By userNameLabelLocator = new By.ByCssSelector("#userName-value");

}
