package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GroupsCompilationItem
{
    private static final By ITEM_TITLE_LOCATOR = By.xpath("//a[contains(@class, 'title' )]");

    private WebDriver driver;
    private WebElement item;


    public GroupsCompilationItem(WebDriver driver, WebElement item)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.item = item;
    }

    public String getGroupTitle()
    {
        return item.findElement(ITEM_TITLE_LOCATOR).getText();
    }
}
