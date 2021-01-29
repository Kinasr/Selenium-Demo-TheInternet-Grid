package retrievePassword;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RetrievePasswordTests extends BaseTests {

    @Test
    public void testValidRetrievePassword() {
        var forgetPasswordPage = homePage.clickOnForgetPassword();
        forgetPasswordPage.setEmail("test@tst.com");
        var emailSendPage = forgetPasswordPage.clickOnRetrievePassword();
        assertTrue(emailSendPage.getConformMsg().contains("Your e-mail's been sent!"),
                "Wrong Message");
    }
}
