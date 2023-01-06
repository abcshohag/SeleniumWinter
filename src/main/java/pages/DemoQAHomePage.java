package pages;
import org.openqa.selenium.By;

public class DemoQAHomePage {
    public String url = "https://demoqa.com/";
    public By bookStore = new By.ByCssSelector (".category-cards div:nth-child(6)");
}
