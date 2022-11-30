package Elements;

import Pages.CompilationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CompilationsItem
{
    private static final By COMPILATION_TITLE_LOCATOR = By.xpath( "//a[contains(@class, 'bookmarks-navbar-card_title')]");

    private WebDriver driver;
    private WebElement item;

    public CompilationsItem(WebDriver driver, WebElement item)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.item = item;
    }

    public String getCompilationTitle()
    {
        return item.findElement(COMPILATION_TITLE_LOCATOR).getText();
    }

    public CompilationPage goToCompilation()
    {
        item.findElement(COMPILATION_TITLE_LOCATOR).click();
        return new CompilationPage(driver);
    }
}
