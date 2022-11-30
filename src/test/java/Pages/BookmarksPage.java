package Pages;

import Elements.CompilationsItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

public class BookmarksPage
{
    protected WebDriver driver;

    private static final String BOOKMARKS_LOCATOR = "//div[text() = 'Закладки']";
    private static final String COMPILATIONS_LOCATOR = "//div[@class = 'bookmarks-navbar_list']";
    private static final String COMPILATIONS_ITEMS_LOCATOR = "//div[@class = 'bookmarks-navbar-card']";
    private static final String STUB_LOCATOR = "//div[contains(@class, 'stub-empty')]";
    @FindBy(xpath = BOOKMARKS_LOCATOR)
    private WebElement bookmarksLocator;

    @FindBy(xpath = COMPILATIONS_LOCATOR)
    private WebElement compilationsLocator;

    @FindBy(xpath = STUB_LOCATOR)
    private WebElement stubLocator;

    @FindBy(xpath = COMPILATIONS_ITEMS_LOCATOR)
    private List<WebElement> compilationsItemsLocator;

    public BookmarksPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean checkStub()
    {
        return stubLocator.isDisplayed();
    }

    public BookmarksPage goToBookmarks()
    {
        bookmarksLocator.click();
        return this;
    }

    public List<CompilationsItem> getCompilationsItem()
    {
        return compilationsItemsLocator
                .stream()
                .map(compilation -> new CompilationsItem(driver, compilation))
                .collect(Collectors.toList());
    }
}
