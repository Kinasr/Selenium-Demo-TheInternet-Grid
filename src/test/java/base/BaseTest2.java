package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest2 {

    public static String baseUrl = "https://the-internet.herokuapp.com/";

    protected ThreadLocal<RemoteWebDriver> driver = null;
//    protected HomePage homePage;

    @BeforeClass
    @Parameters(value = "browser")
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);

        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
        getDriver().navigate().to(baseUrl);

//        homePage = new HomePage(getDriver());
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }

}
