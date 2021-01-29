package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refresh() {
        navigate.refresh();
    }

    public void goToUrl(String url) {
        navigate.to(url);
    }

    public void switchToTab(String tabTitle) {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);

            if (driver.getTitle().equals(tabTitle)) break;
        }
    }

    public void switchToTabWithUrl(String url) {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);

            if (driver.getCurrentUrl().endsWith(url)) break;
        }
    }
}
