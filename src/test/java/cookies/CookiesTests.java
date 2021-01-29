package cookies;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class CookiesTests extends BaseTests {

    @Test
    public void testDeleteCookie() {
        var cookieName = "optimizelyBuckets";
        homePage.deleteCookie(cookieName);
        assertFalse(homePage.isThisCookieExist(cookieName), "The cookie is exit");
    }
}
