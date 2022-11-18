package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage
{
    protected WebDriver driver;

    private static final  String USERNAME_LOCATOR = "//input[@id='field_email']";
    private static final  String PASSWORD_LOCATOR = "//input[@id='field_password']";
    private static final  String LOGIN_BUTTON_LOCATOR = "//input[@value='Войти в Одноклассники']";
    private static final  String USER_PAGE_LOCATOR = "//div[@class='tico ellip']";

    @FindBy(xpath = USERNAME_LOCATOR)
    private WebElement usernameLocator;

    @FindBy(xpath = PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    @FindBy(xpath = USER_PAGE_LOCATOR)
    private WebElement userPageLocator;

    public SignInPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage loginUser(String username, String password)
    {
        usernameLocator.sendKeys(username);
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        userPageLocator.click();

        return new HomePage(driver);
    }
}
