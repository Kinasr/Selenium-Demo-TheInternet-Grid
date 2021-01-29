package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By toggleAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By toggleConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By togglePromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By result = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void toggleAlert() {
        driver.findElement(toggleAlertButton).click();
    }

    public void toggleConfirm() {
        driver.findElement(toggleConfirmButton).click();
    }

    public void togglePrompt() {
        driver.findElement(togglePromptButton).click();
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }

    public void alert_accept() {
        driver.switchTo().alert().accept();
    }

    public void alert_dismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void alert_sendKeys(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }
}
