package crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadInvoice {
    private WebDriver driver;
    private By invoiceIdLocator = By.cssSelector(".id");
    private By invoiceDateLocator = By.cssSelector(".date:nth-child(1) > .value");
    private By invoiceAmountLocator = By.cssSelector(".grand-total");
    private By invoiceStatusLocator = By.cssSelector(".status");

    public ReadInvoice(WebDriver driver) {
        this.driver = driver;
    }

    public String getInvoiceId() {
        WebElement element = driver.findElement(invoiceIdLocator);
        return element.getText();
    }

    public String getInvoiceStatus() {
        WebElement element = driver.findElement(invoiceStatusLocator);
        return element.getText();
    }

    public String getInvoiceDate() {
        WebElement element = driver.findElement(invoiceDateLocator);
        return element.getText();
    }

    public String getInvoiceAmount() {
        WebElement element = driver.findElement(invoiceAmountLocator);
        return element.getText();
    }
}
