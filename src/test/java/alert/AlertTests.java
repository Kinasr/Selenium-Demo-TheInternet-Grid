package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        var alertPage = homePage.clickOnAlerts();
        alertPage.toggleAlert();
        alertPage.alert_accept();
        assertEquals(alertPage.getResult(), "You successfuly clicked an alert", "accept failed");
    }

    @Test
    public void testGetAlertText() {
        var alertPage = homePage.clickOnAlerts();
        alertPage.toggleConfirm();
        String alertText = alertPage.alert_getText();
        alertPage.alert_dismiss();
        assertEquals(alertText, "I am a JS Confirm", "Wrong alert text");
    }

    @Test
    public void testDismissAlert() {
        var alertPage = homePage.clickOnAlerts();
        alertPage.toggleConfirm();
        alertPage.alert_dismiss();
        assertEquals(alertPage.getResult(), "You clicked: Cancel", "Dismiss failed");
    }

    @Test
    public void testSendTextToAlert() {
        String text = "test";
        var alertPage = homePage.clickOnAlerts();
        alertPage.togglePrompt();
        alertPage.alert_sendKeys(text);
        alertPage.alert_accept();
        assertEquals(alertPage.getResult(), "You entered: test", "Wrong text");
    }
}
