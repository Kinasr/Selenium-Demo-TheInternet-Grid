package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwygEditor() {
        var text1 = "Hello ";
        var text2 = "World!!!";

        var editorPage = homePage.clickOnWysiwygEditor();
        editorPage.clearTextArea();
        editorPage.sendKeysToTextArea(text1);
        editorPage.activeBoldButton();
        editorPage.sendKeysToTextArea(text2);

        assertEquals(editorPage.getTextAreaText(), text1 + "\uFEFF" + text2, "Wrong text");
    }

    @Test
    public void testNestedFrames() {
        var nestedFramesPage = homePage.clickOnFrames()
                .clickOnNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Wrong left");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Wrong bottom");
    }
}
