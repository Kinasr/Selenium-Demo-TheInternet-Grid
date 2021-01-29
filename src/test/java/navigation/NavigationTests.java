package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigation() {
        homePage.clickOnDynamicLoading().clickOnExample1();
        getWindowManager().goBack();
        getWindowManager().refresh();
        getWindowManager().goForward();
        getWindowManager().goToUrl("https://translate.google.com.eg/");
    }

    @Test
    public void testSwitchToTab() {
        var tabTitle = "New Window";
        var mWindowPage = homePage.clickOnMultipleWindows();
        mWindowPage.clickOnClickHere();
        getWindowManager().switchToTab(tabTitle);
        assertEquals(mWindowPage.getWindowTitle(), tabTitle, "Wrong title");
    }

    @Test
    public void testWindowTabs() {
        var dynamicPage = homePage.clickOnDynamicLoading();
        var example2Page = dynamicPage.openExample2InNewTab();
        getWindowManager().switchToTabWithUrl("/2");
        assertTrue(example2Page.isStartButtonDisplayed(), "error");
    }
}
