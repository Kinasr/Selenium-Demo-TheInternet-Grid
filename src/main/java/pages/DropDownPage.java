package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {
    private WebDriver driver;

    private By dropDown = By.id("dropdown");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    private Select findDropDownElement() {
        return new Select(driver.findElement(dropDown));
    }

    public void selectDropDownOption(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedDropDownOptions() {
        return findDropDownElement().getAllSelectedOptions().stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void enableMultipleSelections() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('multiple', '')",
                driver.findElement(dropDown));
    }
}
