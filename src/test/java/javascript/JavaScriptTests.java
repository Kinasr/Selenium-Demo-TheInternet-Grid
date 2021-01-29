package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        homePage.clickOnLargeAndDeepDOM().scrollToTable();
    }

    @Test
    public void testScrollToParagraph() {
        homePage.clickOnInfiniteScroll().scrollToTextBlock(5);
    }

    @Test
    public void testEnableDropDownMultipleSelections() {
        var dropDownPage = homePage.clickOnDropDown();
        var option1 = "Option 1";
        var option2 = "Option 2";
        dropDownPage.enableMultipleSelections();
        dropDownPage.selectDropDownOption(option1);
        dropDownPage.selectDropDownOption(option2);
        var selectedOptions = dropDownPage.getSelectedDropDownOptions();
        assertEquals(selectedOptions.size(), 2, "Wrong selected number");
        assertEquals(selectedOptions.get(0), "Option 1");
        assertEquals(selectedOptions.get(1), "Option 2");
    }
}
