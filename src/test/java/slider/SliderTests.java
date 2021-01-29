package slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {

    @Test
    public void testHorizontalSliderTo4() {
        var sliderPage = homePage.clickOnHorizontalSlider();
        sliderPage.setSlider(4);
        assertEquals(sliderPage.getRange(), "4", "Wrong range");
    }
}
