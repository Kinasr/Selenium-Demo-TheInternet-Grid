package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTextBlock(int index) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        while (getNumberOfTextBlocks() < index) {
            executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
    }

    private int getNumberOfTextBlocks() {
        return driver.findElements(textBlocks).size();
    }
}
