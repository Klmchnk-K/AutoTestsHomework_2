package Tests;

import Pages.GroupPage;
import org.junit.jupiter.api.*;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupsBookmarksTest extends BaseTest
{
    private static final String GROUP_NAME = "Образовательный центр VK в Политехе";
    private static final String REMOVE_BOOKMARK = "Убрать из закладок";

    GroupPage groupPage;

    @Nested
    public class AddGroupToBookmarks
    {
        @BeforeEach
        public void goToPage()
        {
            groupPage = new GroupPage(driver).goToGroup();
        }

        @DisplayName("Checking the group name")
        @Timeout(value = 20, unit = TimeUnit.SECONDS)
        @Test
        public void checkGroupNameTest()
        {
            assertEquals(GROUP_NAME, groupPage.getGroupNameText());
        }

        @DisplayName("Adding a group to bookmarks")
        @Timeout(value = 20, unit = TimeUnit.SECONDS)
        @Test
        public void addToBookmarksTest()
        {
            assertEquals(REMOVE_BOOKMARK, groupPage
                    .addGroupToBookmarks()
                    .checkRemoveBookmark());

            groupPage.removeBookmark();
        }
    }
}
