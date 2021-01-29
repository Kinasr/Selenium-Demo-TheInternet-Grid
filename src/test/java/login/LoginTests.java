package login;

import base.BaseTest2;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest2 {

    @Test
    public void testSuccessfulLogin() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = homePage.clickOnFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickOnLogin();
        assertTrue(secureAreaPage.getAlert().contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}
