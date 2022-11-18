package Tests;

import Pages.SignInPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest
{
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final  String CHROME_DRIVER_PATH = "\\src\\main\\resources\\chromedriver.exe";
    private static final  String OK_URL = "https://ok.ru";
    private static final String TEST_USERNAME = "technoPol15";
    private static final String TEST_PASSWORD = "technoPolis2022";

    static WebDriver driver;

    @BeforeAll
    static void setup()
    {
        System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + CHROME_DRIVER_PATH);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    static void teardown()
    {
        driver.quit();
    }

    @BeforeEach
    public void login()
    {
        driver.get(OK_URL);

        SignInPage signInPage = new SignInPage(driver)
                .inputUsername(TEST_USERNAME)
                .inputPassword(TEST_PASSWORD)
                .clickLoginButton();
    }
}
