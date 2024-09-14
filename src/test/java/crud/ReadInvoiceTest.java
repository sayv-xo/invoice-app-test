package crud;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadInvoiceTest extends BaseTest {
    private String expectedInvoiceId = "#RT3080";
    private String expectedInvoiceStatus = "• Paid";
    private String expectedInvoiceDate = "18 Aug 2021";
    private String expectedInvoiceAmount = "£1,800.90";

    @Test
    public void testReadInvoice() {
        ReadInvoice viewInvoice = homePage.getInvoiceDetails();
        String actualInvoiceId = viewInvoice.getInvoiceId();
        String actualInvoiceStatus = viewInvoice.getInvoiceStatus();
        String actualInvoiceDate = viewInvoice.getInvoiceDate();
        String actualInvoiceAmount = viewInvoice.getInvoiceAmount();

        // Asserting the values
        Assert.assertEquals(actualInvoiceId, expectedInvoiceId, "Invoice ID does not match");
        Assert.assertEquals(actualInvoiceStatus, expectedInvoiceStatus, "Invoice Status does not match");
        Assert.assertEquals(actualInvoiceDate, expectedInvoiceDate, "Invoice Date does not match");
        Assert.assertEquals(actualInvoiceAmount, expectedInvoiceAmount, "Invoice Amount does not match");
    }

}
