package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By submitButton = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputField(String path) {
        driver.findElement(inputField).sendKeys(path);
    }

    public void UploadFile() {
        driver.findElement(submitButton).click();
    }

    public String getUploadedFileName() {
        return driver.findElement(uploadedFile).getText();
    }
}
