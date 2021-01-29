package actions;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoversTests extends BaseTests {

    @Test
    public void testHoversUser1() {
        var hoversPage = homePage.clickOnHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(),"Caption is not displayed");
        assertEquals(caption.getHeaderText(), "name: user1", "Wrong user name");
        assertEquals(caption.getLinkText(), "View profile", "Wrong link text");
        assertTrue(caption.getLink().endsWith("/users/1"), "Wrong link");
    }
}
