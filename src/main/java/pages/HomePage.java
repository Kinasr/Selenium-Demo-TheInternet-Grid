package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public LoginPage clickOnFormAuthentication() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickOnDropDown() {
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    public ForgetPasswordPage clickOnForgetPassword() {
        clickLink("Forgot Password");
        return new ForgetPasswordPage(driver);
    }

    public HoversPage clickOnHovers() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickOnKeyPresses() {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickOnHorizontalSlider() {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public AlertsPage clickOnAlerts() {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickOnFileUpload() {
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickOnContextMenu () {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygEditorPage clickOnWysiwygEditor() {
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickOnFrames() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickOnDynamicLoading() {
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDOMPage clickOnLargeAndDeepDOM() {
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDOMPage(driver);
    }

    public InfiniteScrollPage clickOnInfiniteScroll() {
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickOnMultipleWindows () {
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    public void deleteCookie(String cookieName) {
        driver.manage().deleteCookieNamed(cookieName);
    }

    public boolean isThisCookieExist(String cookieName) {
        var cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return true;
            }
        }
        return false;
    }
}
