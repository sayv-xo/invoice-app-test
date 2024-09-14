package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DarkModePage {
    private WebDriver driver;
    private By darkModeSelector = By.cssSelector(".settings > svg");
    private By lightModeSelector = By.cssSelector(".settings path");


    public DarkModePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDarkMode() {
        driver.findElement(darkModeSelector).click();
    }

    public String getModeClass() {
        return driver.findElement(By.tagName("body")).getAttribute("class");
    }

    public String getModeColour() {
        return driver.findElement(By.tagName("body")).getCssValue("background-color");
    }

    public void clickLightMode() {
        driver.findElement(lightModeSelector).click();
    }
}
