package pages;

import org.openqa.selenium.By;

public class SelectMenuPage {
    public final String pageUrl = "https://demoqa.com/select-menu";
    public By singleSelectLocator = new By.ByCssSelector("#oldSelectMenu");
    public By multiSelectLocator = new By.ByCssSelector("#cars");

    public By firstSelectLocator = new By.ByCssSelector("#withOptGroup .css-1hwfws3");

    public By firstSelectOption = new By.ByXPath("//div[text()='Group 2, option 2']");

}
