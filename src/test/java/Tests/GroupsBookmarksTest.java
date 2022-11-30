package Tests;

import Elements.CompilationsItem;
import Elements.GroupsCompilationItem;
import Pages.BookmarksPage;
import Pages.GroupPage;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class GroupsBookmarksTest extends BaseTest
{
    @Nested
    public class AddGroupToBookmarks
    {
        private static final String GROUP_NAME = "Образовательный центр VK в Политехе";
        private static final String REMOVE_BOOKMARK = "Убрать из закладок";

        GroupPage groupPage;

        @BeforeEach
        public void goToPage()
        {
            groupPage = new GroupPage(driver).goToGroup();
        }

        @DisplayName("Checking the group name")
        @Timeout(value = 10, unit = TimeUnit.SECONDS)
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
                    .openOptions()
                    .addGroupToBookmarks()
                    .checkRemoveBookmark());

            groupPage.removeBookmark();
        }

        @DisplayName("Checking bookmarks with groups")
        @Nested
        public class CheckingGroupsBookmarks
        {
            private static final String GROUPS_COMPILATION_TITLE = "Группы";
            BookmarksPage bookmarksPage;

            @BeforeEach
            public void goToBookmarksPage()
            {
                groupPage.openOptions().addGroupToBookmarks();

                bookmarksPage = new BookmarksPage(driver).goToBookmarks();
            }

            public CompilationsItem FindGroupCompilation()
            {
                List<CompilationsItem> compilations = bookmarksPage.getCompilationsItem();

                CompilationsItem isThereGroupCompilation = compilations
                        .stream()
                        .filter(compilation -> compilation.getCompilationTitle().equals(GROUPS_COMPILATION_TITLE) )
                        .findAny()
                        .orElse(null);

                return isThereGroupCompilation;
            }

            @DisplayName("Bookmarks page is not empty")
            @Timeout(value = 10, unit = TimeUnit.SECONDS)
            @Test
            public void IsNotEmptyTest()
            {
                assertFalse(bookmarksPage.checkStub());
            }

            @DisplayName("Checking that a сompilation of groups exists")
            @Timeout(value = 10, unit = TimeUnit.SECONDS)
            @Test
            public void GroupCompilationExistTest()
            {
                assertNotNull(FindGroupCompilation());
            }

            @DisplayName("Checking that the added bookmark exists")
            @Timeout(value = 20, unit = TimeUnit.SECONDS)
            @Test
            public void GroupBookmarkExistTest()
            {
                List<GroupsCompilationItem> groups = FindGroupCompilation().goToCompilation().getCompilationItems();

                GroupsCompilationItem isThereAddedGroup = groups
                        .stream()
                        .filter(group -> group.getGroupTitle().equals(GROUP_NAME) )
                        .findAny()
                        .orElse(null);

                assertNotNull(isThereAddedGroup);
            }

            @AfterEach
            public void removeBookmark()
            {
                groupPage.goToGroup().openOptions().removeBookmark();
            }
        }
    }
}
