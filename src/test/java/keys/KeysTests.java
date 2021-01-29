package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testEnterBackSpace() {
        var keysPage = homePage.clickOnKeyPresses();
        keysPage.enterText("A" + Keys.BACK_SPACE);

        assertEquals(keysPage.getTextResult(),"You entered: BACK_SPACE", "wrong text");
    }

    @Test
    public void testEnterPi() {
        var keysPage = homePage.clickOnKeyPresses();
       keysPage.enterPi();

        assertEquals(keysPage.getTextResult(),"You entered: BACK_SPACE", "wrong text");
    }
}
