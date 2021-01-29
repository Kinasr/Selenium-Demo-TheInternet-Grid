package actions;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextTests extends BaseTests {

    @Test
    public void testContextMenu() {
        var contextMenuPage = homePage.clickOnContextMenu();
        contextMenuPage.rightClickOnHotSpot();
        String alertText = contextMenuPage.alert_getText();
        contextMenuPage.alert_accept();

        assertEquals(alertText, "You selected a context menu", "Wrong text alert");
    }
}
