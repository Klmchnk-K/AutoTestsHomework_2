package Pages;

import Elements.GroupsCompilationItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

public class CompilationPage
{
    protected WebDriver driver;
    private static final String GROUP_COMPILATION_ITEMS_LOCATOR = "//div[@class = 'bookmarks-menu-group-card' ]";

    @FindBy(xpath = GROUP_COMPILATION_ITEMS_LOCATOR)
    private List<WebElement> groupCompilationItemsLocator;

    public CompilationPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<GroupsCompilationItem> getCompilationItems()
    {
        return groupCompilationItemsLocator
                .stream()
                .map(group -> new GroupsCompilationItem(driver, group))
                .collect(Collectors.toList());
    }
}
