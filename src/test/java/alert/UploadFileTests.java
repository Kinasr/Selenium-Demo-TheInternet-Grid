package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UploadFileTests extends BaseTests {

    @Test
    public void testUploadFile() {
        var uploadPage = homePage.clickOnFileUpload();
        uploadPage.setInputField("D:\\My_Projects\\Test Automation\\TAU_SeleniumWebDriver_JAVA\\resources\\chromedriver.exe");
        uploadPage.UploadFile();
        assertEquals(uploadPage.getUploadedFileName(), "chromedriver.exe", "Wrong file name");
    }
}
