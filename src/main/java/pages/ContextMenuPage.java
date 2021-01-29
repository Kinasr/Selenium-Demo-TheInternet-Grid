package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By hotSpotBox =By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickOnHotSpot() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(hotSpotBox))
                .perform();
    }

    public void alert_accept() {
        driver.switchTo().alert().accept();
    }

    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }
}
