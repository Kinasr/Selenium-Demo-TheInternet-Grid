package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editAreaId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By boldButton = By.cssSelector("[aria-label='Bold']");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea() {
        switchToEditAreaFrame();
        driver.findElement(textArea).clear();
        switchToMainFrame();
    }

    public void sendKeysToTextArea(String text) {
        switchToEditAreaFrame();
        driver.findElement(textArea).sendKeys(text);
        switchToMainFrame();
    }

    public String getTextAreaText() {
        switchToEditAreaFrame();
        String text = driver.findElement(textArea).getText();
        switchToMainFrame();
        return text;
    }

    public void activeBoldButton() {
        driver.findElement(boldButton).click();
    }

    private void switchToEditAreaFrame() {
        driver.switchTo().frame(editAreaId);
    }

    private void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }
}
