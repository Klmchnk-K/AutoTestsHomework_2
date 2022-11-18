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

    @FindBy(xpath = USERNAME_LOCATOR)
    private WebElement usernameLocator;

    @FindBy(xpath = PASSWORD_LOCATOR)
    private WebElement passwordLocator;

    @FindBy(xpath = LOGIN_BUTTON_LOCATOR)
    private WebElement loginButtonLocator;

    public SignInPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignInPage inputUsername(String username)
    {
        usernameLocator.sendKeys(username);
        return this;
    }

    public SignInPage inputPassword(String password)
    {
        passwordLocator.sendKeys(password);
        return this;
    }

    public SignInPage clickLoginButton()
    {
        loginButtonLocator.click();
        return this;
    }
}
