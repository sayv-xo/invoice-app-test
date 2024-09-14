package pages;

import crud.InvoiceFormPage;
import crud.InvoiceListPage;
import crud.ReadInvoice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By invoiceItemLocator = By.className("invoice-item");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public DarkModePage darkMode() {
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        return new DarkModePage(driver);
    }

    public ReadInvoice getInvoiceDetails() {
        driver.findElement(By.cssSelector(".invoice-item:nth-child(1)")).click();
        return new ReadInvoice(driver);
    }

    public InvoiceListPage invoiceList() {
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        return new InvoiceListPage(driver);
    }

    public InvoiceFormPage createInvoice() {
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        driver.findElement(By.cssSelector(".btn-container")).click();
        return new InvoiceFormPage(driver);
    }
}
