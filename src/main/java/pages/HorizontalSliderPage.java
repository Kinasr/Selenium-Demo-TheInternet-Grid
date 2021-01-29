package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.cssSelector(".sliderContainer input");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSlider(float value) {
        value = (float) (Math.round(value * 2) / 2.0);
        WebElement sliderElement = driver.findElement(slider);

        for(int i = 0; i < value * 2; i++) {
            sliderElement.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getRange() {
        return driver.findElement(range).getText();
    }
}
