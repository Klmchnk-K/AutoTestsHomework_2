package Tests;

import Pages.HomePage;
import Pages.UserPage;
import org.junit.jupiter.api.*;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest
{
    private static final String TEST_FULL_NAME = "technoPol15 technoPol15";
    private static final String TEST_URL = "https://ok.ru/profile/602099332624";

    @DisplayName("User verification")
    @Timeout(value = 20, unit = TimeUnit.SECONDS)
    @Test
    public void loginTest()
    {
        HomePage homePage = new HomePage(driver);

        UserPage userPage = homePage.goToUserPage();

        assertAll("Checking that the login was made to the test account",
                () -> assertEquals(TEST_FULL_NAME, userPage.getFullNameText()),
                () -> assertEquals(TEST_URL, driver.getCurrentUrl())
        );
    }

    @DisplayName("Something verification")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    @Test
    @Disabled("Not implemented yet")
    public void somethingTest()
    {

    }
}
