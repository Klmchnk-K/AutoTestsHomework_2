package Tests;

import Pages.HomePage;
import Pages.UserPage;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest
{
    private static final String TEST_FULL_NAME = "technoPol15 technoPol15";

    @Tag("login")
    @DisplayName("Name verification")
    @Timeout(value = 20, unit = TimeUnit.SECONDS)
    @Test
    public void loginTest()
    {
        HomePage homePage = new HomePage(driver);

        UserPage userPage = homePage.goToUserPage();

        Assertions.assertEquals(TEST_FULL_NAME, userPage.getFullNameText());
    }
}
