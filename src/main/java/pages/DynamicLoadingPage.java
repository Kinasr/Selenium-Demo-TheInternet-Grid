package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String xpathLink = ".//a[contains(text(), '%s')]";
    private By example1Link = By.xpath(String.format(xpathLink, "Example 1"));
    private By example2Link = By.xpath(String.format(xpathLink, "Example 2"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public Example1Page clickOnExample1() {
        driver.findElement(example1Link).click();
        return new Example1Page(driver);
    }

    public Example2Page clickOnExample2() {
        driver.findElement(example2Link).click();
        return new Example2Page(driver);
    }

    public Example2Page openExample2InNewTab() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(driver.findElement(example2Link))
                .perform();
        return new Example2Page(driver);
    }

    public class Example1Page {
        private WebDriver driver;
        private By startButton = By.cssSelector("#start button");
        private By loadingIndicator = By.id("loading");
        private By loadedText = By.id("finish");


        public Example1Page(WebDriver driver) {
            this.driver = driver;
        }

        public void clickStartButton() {
            driver.findElement(startButton).click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
        }

        public String getLoadedText() {
            return driver.findElement(loadedText).getText();
        }
    }

    public class Example2Page {
        private WebDriver driver;
        private By startButton = By.cssSelector("#start button");
        private By loadedText = By.id("finish");

        public Example2Page(WebDriver driver) {
            this.driver = driver;
        }

        public void clickStartButton() {
            driver.findElement(startButton).click();
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
        }

        public String getLoadedText() {
            return driver.findElement(loadedText).getText();
        }

        public boolean isStartButtonDisplayed() {
            return driver.findElement(startButton).isDisplayed();
        }
    }
}
