package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private By nestedFramesLink = By.linkText("Nested Frames");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage clickOnNestedFrames() {
        driver.findElement(nestedFramesLink).click();
        return new NestedFramesPage(driver);
    }

    public class NestedFramesPage {
        private WebDriver driver;
        private By topFrame = By.name("frame-top");
        private By leftFrame = By.name("frame-left");
        private By bottomFrame = By.name("frame-bottom");
        private By body = By.tagName("body");

        public NestedFramesPage(WebDriver driver) {
            this.driver = driver;
        }

        public String getLeftFrameText() {
            switchToTopFrame();
            switchToLeftFrame();
            String text = driver.findElement(body).getText();
            switchToParentFrame();
            switchToParentFrame();
            return text;
        }

        public String getBottomFrameText() {
            switchToBottomFrame();
            String text = driver.findElement(body).getText();
            switchToParentFrame();
            return text;
        }

        private void switchToTopFrame() {
            driver.switchTo().frame(driver.findElement(topFrame));
        }

        private void switchToLeftFrame() {
            driver.switchTo().frame(driver.findElement(leftFrame));
        }

        private void switchToBottomFrame() {
            driver.switchTo().frame(driver.findElement(bottomFrame));
        }

        private void switchToParentFrame() {
            driver.switchTo().parentFrame();
        }
    }
}
