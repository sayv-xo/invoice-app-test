package crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InvoiceFormPage {
    private WebDriver driver;

    // Locators for form fields
    private By senderStreetInput = By.id("sender-street");
    private By senderCityInput = By.id("sender-city");
    private By senderCodeInput = By.id("sender-code");
    private By senderCountryInput = By.id("sender-country");

    private By clientNameInput = By.id("name");
    private By clientEmailInput = By.id("email");
    private By clientStreetInput = By.id("street");
    private By clientCityInput = By.id("city");
    private By clientCodeInput = By.id("code");
    private By clientCountryInput = By.id("country");

    private By invoiceDateInput = By.id("invoice-date");
    private By paymentTermsSelect = By.id("payment-terms");
    private By descriptionInput = By.id("description");



    private By itemNameInput = By.id("item-name0");
    private By itemQuantityInput = By.id("quantity0");
    private By itemPriceInput = By.id("price0");
    private By itemTotalInput = By.id("total0");

    private By addItemButton = By.className("add-btn");
    private By discardButton = By.className("discard");
    private By draftButton = By.className("draft");
    private By sendButton = By.className("send");

    public InvoiceFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to fill out the Bill From section
    public void fillBillFrom(String street, String city, String code, String country) {
        driver.findElement(senderStreetInput).sendKeys(street);
        driver.findElement(senderCityInput).sendKeys(city);
        driver.findElement(senderCodeInput).sendKeys(code);
        driver.findElement(senderCountryInput).sendKeys(country);
    }

    // Method to fill out the Bill To section
    public void fillBillTo(String name, String email, String street, String city, String code, String country) {
        driver.findElement(clientNameInput).sendKeys(name);
        driver.findElement(clientEmailInput).sendKeys(email);
        driver.findElement(clientStreetInput).sendKeys(street);
        driver.findElement(clientCityInput).sendKeys(city);
        driver.findElement(clientCodeInput).sendKeys(code);
        driver.findElement(clientCountryInput).sendKeys(country);
    }

    // Method to fill out the invoice details
    public void fillInvoiceDetails(String invoiceDate, String paymentTerms, String description) {
        Select paymentTerm = new Select(driver.findElement(paymentTermsSelect));
        driver.findElement(invoiceDateInput).sendKeys(invoiceDate);
        paymentTerm.selectByVisibleText(paymentTerms);
        driver.findElement(descriptionInput).sendKeys(description);

    }

    // Method to add an item to the invoice
    public void addItem(String itemName, String quantity, String price) {
        driver.findElement(itemNameInput).sendKeys(itemName);
        driver.findElement(itemQuantityInput).sendKeys(quantity);
        driver.findElement(itemPriceInput).sendKeys(price);

    }

    // Method to submit the form as Draft
    public void submitAsDraft() {
        driver.findElement(draftButton).click();
    }

    // Method to submit the form and Send the invoice
    public void submitAndSend() {
        driver.findElement(sendButton).click();
    }

    // Method to discard the form
    public void discardForm() {
        driver.findElement(discardButton).click();
    }
}
