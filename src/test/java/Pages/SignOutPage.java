package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage
{
    protected WebDriver driver;

    private static final  String TOOLBAR_UCARD = "//div[@class = 'ucard-mini_cnt']";
    private static final  String EXIT_USER = "//a[text() = 'Выйти']";
    private static final  String EXIT_OK = "//input[@value = 'Выйти']";

    @FindBy(xpath = TOOLBAR_UCARD)
    private WebElement toolbarUCard;

    @FindBy(xpath = EXIT_USER)
    private WebElement exitUser;

    @FindBy(xpath = EXIT_OK)
    private WebElement exitOK;

    public SignOutPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignOutPage signOut()
    {
        toolbarUCard.click();
        exitUser.click();
        exitOK.click();
        return this;
    }

}
