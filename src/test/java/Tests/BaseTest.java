package Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest
{
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final  String CHROME_DRIVER_PATH = "\\src\\main\\resources\\chromedriver.exe";
    private static final  String OK_URL = "https://ok.ru";

    static WebDriver driver;

    @BeforeAll
    static void setup()
    {
        System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + CHROME_DRIVER_PATH);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(OK_URL);
    }

    @AfterAll
    static void teardown()
    {
        driver.quit();
    }
}
