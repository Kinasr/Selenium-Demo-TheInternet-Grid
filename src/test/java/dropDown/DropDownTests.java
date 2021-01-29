package dropDown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropDownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        var dropDownPage = homePage.clickOnDropDown();
        var option = "Option 1";
        dropDownPage.selectDropDownOption(option);
        var selectedOptions = dropDownPage.getSelectedDropDownOptions();
        assertEquals(selectedOptions.size(), 1, "Wrong selected number");
        assertTrue(selectedOptions.contains(option));
    }
}
