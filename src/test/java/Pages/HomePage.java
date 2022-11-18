package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    protected WebDriver driver;

    private static final  String USER_PAGE_LOCATOR = "//div[@class='tico ellip']";

    @FindBy(xpath = USER_PAGE_LOCATOR)
    private WebElement userPageLocator;

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public UserPage goToUserPage()
    {
        userPageLocator.click();

        return new UserPage(driver);
    }
}
