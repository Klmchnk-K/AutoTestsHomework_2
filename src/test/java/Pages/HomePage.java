package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    protected WebDriver driver;

    private static final  String FULL_NAME_LOCATOR = "//h1[contains(@class, 'user-profile-name')]";

    @FindBy(xpath = FULL_NAME_LOCATOR)
    private WebElement fullNameLocator;

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getFullNameText()
    {
        return fullNameLocator.getText();
    }
}
