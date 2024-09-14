package crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InvoiceListPage {
    private WebDriver driver;

    public InvoiceListPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for invoice items
    private By invoiceItemLocator = By.className("invoice-item");

    // Method to get a list of all invoice items
    public List<WebElement> getInvoiceItems() {
        return driver.findElements(invoiceItemLocator);
    }

    // Method to find an invoice item by invoice Name
    public WebElement findInvoiceItemByName(String invoiceName) {
        List<WebElement> items = getInvoiceItems();
        for (WebElement item : items) {
            String id = item.findElement(By.className("name")).getText();
            if (id.contains(invoiceName)) {
                return item;
            }
        }
        return null;
    }
}
