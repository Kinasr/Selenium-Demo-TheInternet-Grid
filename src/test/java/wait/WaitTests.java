package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testExample1Wait() {
        var examplePage = homePage.clickOnDynamicLoading().clickOnExample1();
        examplePage.clickStartButton();
        assertEquals(examplePage.getLoadedText(), "Hello World!", "Wrong text");
    }

    @Test
    public void testExample2Wait() {
        var examplePage = homePage.clickOnDynamicLoading().clickOnExample2();
        examplePage.clickStartButton();
        assertEquals(examplePage.getLoadedText(), "Hello World!", "Wrong text");
    }
}
