package crud;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateInvoiceTest extends BaseTest {

    private String street = "123 Elm Street";
    private String city = "San Francisco";
    private String postCode = "94105";
    private String country = "USA";
    private String name = "John Smith";
    private String email = "john.smith@gmail.com";
    private String date = "12122000";
    private String paymentTerms = "Next Day";
    private String description = "Lorem ipsum dolor sit amet";
    private String itemName = "Fish";
    private String itemQuantity = "1";
    private String itemPrice = "12";


    @Test
    public void testCreateInvoice() {
        InvoiceFormPage invoiceFormPage = homePage.createInvoice();

        invoiceFormPage.fillBillFrom(street, city, postCode, country);
        invoiceFormPage.fillBillTo(name, email, street, city, postCode, country);
        invoiceFormPage.fillInvoiceDetails(date, paymentTerms, description);
        invoiceFormPage.addItem(itemName, itemQuantity, itemPrice);
        invoiceFormPage.submitAndSend();

        InvoiceListPage invoiceListPage = homePage.invoiceList();

        WebElement invoiceName =  invoiceListPage.findInvoiceItemByName(name);
        Assert.assertNotNull(invoiceName, "Invoice name not found");
    }
}
