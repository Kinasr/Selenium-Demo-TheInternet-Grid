package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage {
    private WebDriver driver;
    private By inputText = By.id("target");
    private By textResult = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(inputText).sendKeys(text);
    }

    public String getTextResult() {
        return driver.findElement(textResult).getText();
    }

    public void enterPi() {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(inputText))
                .keyDown(Keys.ALT)
                .sendKeys("2")
                .sendKeys("2")
                .sendKeys("7")
                .keyUp(Keys.ALT)
                .perform();
    }

//    public void enterPi() {
//        Actions actions = new Actions(driver);
//        actions.click(driver.findElement(inputText))
//                .keyDown(Keys.SHIFT)
//                .sendKeys("a")
//                .sendKeys("b")
//                .keyUp(Keys.SHIFT)
//                .sendKeys("c")
//                .perform();
//    }
}
