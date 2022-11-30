package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupPage
{
    protected WebDriver driver;

    private static final String GROUP_URL = "https://ok.ru/technopolis";
    private static final String GROUP_NAME_LOCATOR = "//h1[@class = 'group-name_h']";
    private static final  String OPTIONS_LOCATOR = "//span[@class = 'u-menu_a toggle-dropdown']";
    private static final  String ADD_TO_BOOKMARKS_LOCATOR = "//a[text() = 'Добавить в закладки']";
    private static final  String REMOVE_BOOKMARK_LOCATOR = "//span[@class = 'u-menu_switch_item']";

    @FindBy(xpath = OPTIONS_LOCATOR)
    private WebElement optionsLocator;

    @FindBy(xpath = GROUP_NAME_LOCATOR)
    private WebElement groupNameText;

    @FindBy(xpath = ADD_TO_BOOKMARKS_LOCATOR)
    private WebElement addToBookmarksLocator;

    @FindBy(xpath = REMOVE_BOOKMARK_LOCATOR)
    private WebElement removeBookmarkLocator;

    public GroupPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public GroupPage goToGroup()
    {
        driver.get(GROUP_URL);
        return this;
    }

    public String getGroupNameText()
    {
        return groupNameText.getText();
    }

    public GroupPage openOptions()
    {
        optionsLocator.click();
        return this;
    }
    public GroupPage addGroupToBookmarks()
    {
        addToBookmarksLocator.click();
        return this;
    }

    public String checkRemoveBookmark()
    {
        return removeBookmarkLocator.getText();
    }

    public void removeBookmark()
    {
        removeBookmarkLocator.click();
    }
}
