package Tests;

import Pages.HomePage;
import Pages.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest
{
    private static final String TEST_USERNAME = "technoPol15";
    private static final String TEST_PASSWORD = "technoPolis2022";
    private static final String TEST_FULL_NAME = "technoPol15 technoPol15";

    @Test
    public void loginTest()
    {
        SignInPage signInPage = new SignInPage(driver);

        HomePage homePage = signInPage.loginUser(TEST_USERNAME, TEST_PASSWORD);

        Assertions.assertEquals(TEST_FULL_NAME, homePage.getFullNameText());
    }
}
